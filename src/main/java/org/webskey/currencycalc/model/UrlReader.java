package org.webskey.currencycalc.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class UrlReader {

	private static String currency;
	private static String date;

	public static String readURL() throws IOException {	
		URL url;
		String tmp, webString = "";
		
			url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/" + date + "?format=json");		
			try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")))){  			
				while((tmp = br.readLine()) != null) webString += tmp + "\n";
			}
		return webString;
	}

	public static String getCurrency() {
		return currency;
	}

	public static void setCurrency(String currenc) {
		currency = currenc.toLowerCase();
	}

	public static String getDate() {
		return date;
	}

	public static void setDate(String dat) {
		date = dat;
	}
}
