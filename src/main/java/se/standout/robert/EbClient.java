package se.standout.robert;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import se.standout.robert.helpers.DateHelper;

public class EbClient extends ExtraBrainClient {
	private Credentials credentials;
	private String url;

	public EbClient(Credentials credentials) {
		this.url = "https://extrabrain.se/";
		this.credentials = credentials;
	}

	public static void main(String[] args) {
		EbClient client = new EbClient(new Credentials() {
			public String getUsername() { return "robert.sjoblom@gmail.com"; }
			public String getPassword() { return "LXf=s%}=-m:kgw?^77??"; }
		});

		client.connect();
	};

	@Override
	public void connect() {
		getTimersForCurrentWeek();
	}

	private void getTimersForCurrentWeek() {
		DateHelper dateHelper = new DateHelper();
		List<String> dates = dateHelper.getDatesOfCurrentWeek();

		List<EbWorker> workers = dates.stream()
		.map(date -> String.format("%stimers/on/%s", url, date))
		.map(string -> new EbHelper(this).createConnection(string))
		.map(con -> new EbWorker(con))
		.collect(Collectors.toList());

		ExecutorService executor = Executors.newFixedThreadPool(workers.size());

		try {
			List<Future<String>> results = executor.invokeAll(workers);
			for (Future<String> future : results) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
