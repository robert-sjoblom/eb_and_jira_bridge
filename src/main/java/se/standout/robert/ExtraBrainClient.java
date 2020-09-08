package se.standout.robert;

public abstract class ExtraBrainClient {
	private Credentials credentials;

	abstract void connect();

	public Credentials getCredentials() {
		return credentials;
	}
}
