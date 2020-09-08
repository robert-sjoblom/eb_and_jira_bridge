package se.standout.robert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class EbWorker implements Callable<String> {
	private HttpURLConnection con;

	/**
	 * A worker that will fetch an EB url and return the result as a string.
	 */
	public EbWorker(final HttpURLConnection con) {
		this.con = con;
	}

	@Override
	public String call() throws Exception {
		final BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream())
			);

		final StringBuffer content = new StringBuffer();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}

		in.close();

		return content.toString();
	}
}
