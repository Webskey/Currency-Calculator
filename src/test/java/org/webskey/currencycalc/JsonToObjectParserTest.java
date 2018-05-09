package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.webskey.currencycalc.model.JsonToObjectParser;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.model.NbpNullBuilder;
import org.webskey.currencycalc.model.UrlReader;

@RunWith(MockitoJUnitRunner.class)
public class JsonToObjectParserTest {
	
	@Mock
	private UrlReader urlReader = new UrlReader();
	
	Nbp nbp;
	NbpNullBuilder nbpNullBuilder;
	
	@InjectMocks
	JsonToObjectParser jsonToObjectParser;

	@Test//(expected = IOException.class)
	public void testParseMethod() throws IOException {
		//urlReader.setCurrency("GBP");
		//urlReader.setDate("2018-05-03");
		String json = "{\r\n" + 
				"  \"table\": \"C\",\r\n" + 
				"  \"currency\": \"funt szterling\",\r\n" + 
				"  \"code\": \"GBP\",\r\n" + 
				"  \"rates\": [\r\n" + 
				"    {\r\n" + 
				"      \"no\": \"082/C/NBP/2018\",\r\n" + 
				"      \"effectiveDate\": \"2018-04-26\",\r\n" + 
				"      \"bid\": 4.7929,\r\n" + 
				"      \"ask\": 4.8897\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		Mockito.when(urlReader.readURL()).thenReturn(json);
		jsonToObjectParser = new JsonToObjectParser();
		nbp = jsonToObjectParser.parse(urlReader.readURL());
		nbpNullBuilder = new NbpNullBuilder();
		//Nbp nbpNull = nbpNullBuilder.getNbp();
		assertEquals(nbp.getCurrency(), "funt szterling");
	}
}
