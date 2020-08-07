package co.com.s4n.demo_bc2.infrastructure.paramenters;

import static co.com.s4n.demo_bc2.infrastructure.util.MonadUtil.getOptionEnv;

public class ApplicationConf {

	private static final String URL_ISSIER= "URL_ISSIER";
	private static final String CLIENT_ID= "CLIENT_ID";
	private static final String CLIENT_SECRET = "CLIENT_SECRET";

	private static ApplicationConf instance;

	private ApplicationConf() {
	}

	public static ApplicationConf getInstance() {
		if (instance == null) {
			instance = new ApplicationConf();
		}
		return instance;
	}

	public String getUrlIssuer() {
		return getOptionEnv(URL_ISSIER)
				.getOrElse("http://localhost:8000");
	}

	public String getClientID() {
		return getOptionEnv(CLIENT_ID)
				.getOrElse("demo-b2c");
	}

	public String getClientSecret() {
		return getOptionEnv(CLIENT_SECRET)
				.getOrElse("secr3t");
	}

	public String getRedirectUri() {
		return "https://localhost:8000";
	}
}
