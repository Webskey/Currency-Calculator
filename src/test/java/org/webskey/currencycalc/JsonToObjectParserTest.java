package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Before;
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
	
	private Nbp nbp;
	private NbpNullBuilder nbpNullBuilder;
	
	@InjectMocks
	JsonToObjectParser jsonToObjectParser;
	
	@Before
	public void setup() {
		jsonToObjectParser = new JsonToObjectParser();		
	}

	@Test
	public void shouldPass_whenCorrectJsonStringPassed() throws IOException {
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
		Mockito.when(urlReader.readURL()).thenReturn(json);	
		
		nbpNullBuilder = new NbpNullBuilder();
		Nbp nbpTest = nbpNullBuilder.getNbp();		
		//when			
		nbp = jsonToObjectParser.parse(urlReader.readURL());
		//then
		assertEquals(nbp, nbpTest);
	}
	
	@Test(expected = IOException.class)
	public void shouldThrowIOException_whenIncorrectJsonStringPassed() throws IOException {		
		//given
		String json = "WRONG";
		Mockito.when(urlReader.readURL()).thenReturn(json);
		//when
		nbp = jsonToObjectParser.parse(urlReader.readURL());
		//then
		assertNull(nbp);
	}
}
