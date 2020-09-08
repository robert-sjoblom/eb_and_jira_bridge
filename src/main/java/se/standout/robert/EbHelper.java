package se.standout.robert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EbHelper {
	private EbClient client;
	private URL url;
	private HttpURLConnection con;

	public EbHelper(EbClient client) {
		this.client = client;
	}

	public HttpURLConnection createConnection(String string) {
		createUrl(string);

		try {
			this.con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Authorization", getAuthString());
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return con;
	}

	private void createUrl(String string) {
		try {
			this.url = new URL(string);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private String getAuthString() {
		String str = String.format(
			"%s:%s",
			client.getCredentials().getUsername(),
			client.getCredentials().getPassword()
		);

		final byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		final String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
		final String base64 = Base64.getEncoder()
																.encodeToString(utf8EncodedString.getBytes());
		return String.format("Basic %s", base64);
  }
}
