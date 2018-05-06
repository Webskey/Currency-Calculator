package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.webskey.currencycalc.model.UrlReader;

public class UrlReaderTest {

	@Test
	public void shouldReturnJsonString_whenDateCurrencyCorrect() throws IOException {
		//given
		UrlReader.setCurrency("GBP");
		UrlReader.setDate("2018-04-13");
		//when
		String json = "{\"table\":\"C\",\"currency\":\"funt szterling\",\"code\""
				+ ":\"GBP\",\"rates\":[{\"no\":\"073/C/NBP/2018\",\"effectiveDate\":\"2018-04-13\",\"bid\":4.7715,\"ask\":4.8679}]}\n";
		String url = UrlReader.readURL();
		//then
		assertEquals(url, json); 
	}
	
	@Test(expected = FileNotFoundException.class)
	public void shouldError_whenCurrencyIncorrect() throws IOException {
		//given
		UrlReader.setCurrency("GrB");
		UrlReader.setDate("2018-04-13");
		//when		
		String usb = UrlReader.readURL();
		//then
		assertNull(usb);
	}

	@Test(expected = FileNotFoundException.class)
	public void shouldError_whenDateCurrencyIncorrect() throws IOException {
		//given
		UrlReader.setCurrency("USD");
		UrlReader.setDate("2018-02-31");
		//when		
		String usb = UrlReader.readURL();
		//then
		assertNull(usb);
	}
}
