package org.webskey.currencycalc.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class UrlReader {

	private String currency;
	private String date;
	
	public UrlReader() {
		this.currency = "gbp";
		this.date = LocalDate.now().toString();
	}

	public String readURL() throws IOException {	
		URL url;
		String tmp, webString = "";
		
			url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/" + date + "?format=json");		
			try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")))){  			
				while((tmp = br.readLine()) != null) webString += tmp + "\n";
			}
		return webString;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currenc) {
		currency = currenc.toLowerCase();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String dat) {
		date = dat;
	}
}
