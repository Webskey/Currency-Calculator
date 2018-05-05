package org.webskey.currencycalc;

import org.junit.Test;
import org.webskey.currencycalc.model.UrlReader;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class UrlReaderTest {

	@Test
	public void Test() throws IOException {
		UrlReader.setCurrency("GBP");
		UrlReader.setDate("2018-04-13");
		String ulr = "{\"table\":\"C\",\"currency\":\"funt szterling\",\"code\""
				+ ":\"GBP\",\"rates\":[{\"no\":\"073/C/NBP/2018\",\"effectiveDate\":\"2018-04-13\",\"bid\":4.7715,\"ask\":4.8679}]}\n";
		String usb = UrlReader.readURL();
		assertEquals(usb, ulr); 
	}

}
