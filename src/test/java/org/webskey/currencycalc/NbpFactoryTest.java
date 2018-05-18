package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.service.JsonToObjectParser;
import org.webskey.currencycalc.service.NbpFactory;
import org.webskey.currencycalc.service.NbpNullBuilder;
import org.webskey.currencycalc.service.UrlReader;

@RunWith(MockitoJUnitRunner.class)
public class NbpFactoryTest {

	@Mock
	private UrlReader urlReader;

	@Mock
	private JsonToObjectParser jsonToObjectParser;

	@InjectMocks
	NbpFactory nbpFactory;

	private Nbp nbp;

	@Test
	public void shuoldReturnNbpObject_whenNoExceptionThrown() throws IOException {
		//given
		String json = "JSON";
		nbp = new Nbp();
		nbp.setInfo("Test info");
		when(urlReader.readURL()).thenReturn(json);
		when(jsonToObjectParser.parse(json)).thenReturn(nbp);
		//when
		nbpFactory.setNbp();
		//then
		assertEquals(nbpFactory.getInfo(), nbp.getInfo());
		assertEquals(nbpFactory.getInfo(), "Test info");
		assertEquals(nbp, nbpFactory.getNbp());
	}

	@Test
	public void shuoldReturnNullNbpBuilderObject_whenUrlReaderThrowsIOException() throws IOException {
		//given
		when(urlReader.readURL()).thenThrow(IOException.class);
		nbp = new NbpNullBuilder().getNbp();
		//when
		nbpFactory.setNbp();
		//then
		assertEquals(nbp.getInfo(), nbpFactory.getInfo());
		assertEquals(nbp, nbpFactory.getNbp());
	}

	@Test
	public void shuoldReturnNullNbpBuilderObject_whenJsonParserThrowsIOException() throws IOException {
		//given
		when(jsonToObjectParser.parse(any())).thenThrow(IOException.class);
		nbp = new NbpNullBuilder().getNbp();
		//when
		nbpFactory.setNbp();
		//then
		assertEquals(nbp.getInfo(), nbpFactory.getInfo());
		assertEquals(nbp, nbpFactory.getNbp());
	}

	@Test//(expected = NullPointerException.class)
	public void shuoldThrowNullPointer_whenNbpObjectIsNull() throws IOException {
		//given
		when(jsonToObjectParser.parse(any())).thenReturn(null);
		//when
		nbpFactory.setNbp();
		//then
		assertNull(nbpFactory.getNbp());
	}
}
