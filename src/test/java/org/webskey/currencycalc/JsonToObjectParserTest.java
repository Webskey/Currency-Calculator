package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.webskey.currencycalc.model.JsonToObjectParser;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.model.NbpNullBuilder;
import org.webskey.currencycalc.model.UrlReader;


public class JsonToObjectParserTest {

	Nbp nbp;
	NbpNullBuilder nbpNullBuilder;
	JsonToObjectParser jsonToObjectParser;

	@Test(expected = FileNotFoundException.class)
	public void testParseMethod() throws IOException {
		UrlReader.setCurrency("GBP");
		UrlReader.setDate("2018-05-03");
		jsonToObjectParser = new JsonToObjectParser();
		nbp = jsonToObjectParser.parse(UrlReader.readURL());
		nbpNullBuilder = new NbpNullBuilder();
		Nbp nbpNull = nbpNullBuilder.getNbp();
		assertEquals(nbp, nbpNull);
	}
}
