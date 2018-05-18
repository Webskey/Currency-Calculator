package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.service.JsonToObjectParser;
import org.webskey.currencycalc.service.NbpNullBuilder;

public class JsonToObjectParserTest {

	private Nbp nbp;
	private NbpNullBuilder nbpNullBuilder;	
	private JsonToObjectParser jsonToObjectParser;

	@Before
	public void setup() {
		jsonToObjectParser = new JsonToObjectParser();		
	}

	@Test
	public void shouldMatchNbpNullBuilderObject_whenEmptyFieldsPassed() throws IOException {
		//given
		String json = "{\r\n" + 
				"  \"table\": \"\",\r\n" + 
				"  \"currency\": \"\",\r\n" + 
				"  \"code\": \"\",\r\n" + 
				"  \"rates\": [\r\n" + 
				"    {\r\n" + 
				"      \"no\": \"\",\r\n" + 
				"      \"effectiveDate\": \"\",\r\n" + 
				"      \"bid\": 0,\r\n" + 
				"      \"ask\": 0\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";

		nbpNullBuilder = new NbpNullBuilder();
		Nbp nbpTest = nbpNullBuilder.getNbp();		
		//when			
		nbp = jsonToObjectParser.parse(json);
		//then
		assertEquals(nbp, nbpTest);
	}

	@Test
	public void shouldReturnNbpObject_whenCorrectJsonStringPassed() throws IOException {
		//given
		String json = "{\"table\":\"C\","
				+ "\"currency\":\"dolar amerykañski\","
				+ "\"code\":\"USD\","
				+ "\"rates\":[{"
				+ "\"no\":\"066/C/NBP/2018\","
				+ "\"effectiveDate\":\"2018-04-04\","
				+ "\"bid\":3.3977,"
				+ "\"ask\":3.4663}]}";				
		//when			
		nbp = jsonToObjectParser.parse(json);
		//then
		assertEquals(nbp.getCode(), "USD");
		assertEquals(nbp.getRates().get(0).getBid(), 3.3977, 0);
	}

	@Test(expected = IOException.class)
	public void shouldThrowIOException_whenIncorrectJsonStringPassed() throws IOException {		
		//given
		String json = "WRONG";
		//when
		nbp = jsonToObjectParser.parse(json);
		//then
		assertNull(nbp);
	}
}
