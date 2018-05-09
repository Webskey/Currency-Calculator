package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.webskey.currencycalc.model.UrlReader;

public class UrlReaderTest {

	private static UrlReader urlReader;

	@BeforeClass
	public static void beforeClass() {
		urlReader = new UrlReader();
	}

	@Test
	public void shouldReturnJsonString_whenDateCurrencyCorrect() throws IOException {
		//given
		urlReader.setCurrency("GBP");
		urlReader.setDate("2018-04-13");
		String json = "{\"table\":\"C\",\"currency\":\"funt szterling\",\"code\""
				+ ":\"GBP\",\"rates\":[{\"no\":\"073/C/NBP/2018\",\"effectiveDate\":\"2018-04-13\",\"bid\":4.7715,\"ask\":4.8679}]}\n";
		//when
		String url = urlReader.readURL();
		//then
		assertEquals(url, json); 
	}

	@Test(expected = FileNotFoundException.class)
	public void shouldError_whenCurrencyIncorrect() throws IOException {
		//given
		urlReader.setCurrency("GrB");
		urlReader.setDate("2018-04-13");
		//when		
		String usb = urlReader.readURL();
		//then
		assertNull(usb);
	}

	@Test(expected = FileNotFoundException.class)
	public void shouldError_whenDateCurrencyIncorrect() throws IOException {
		//given
		urlReader.setCurrency("USD");
		urlReader.setDate("2018-02-31");
		//when		
		String usb = urlReader.readURL();
		//then
		assertNull(usb);
	}
}
