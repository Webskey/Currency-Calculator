package org.webskey.currencycalc;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.model.NbpRates;
import org.webskey.currencycalc.service.NbpNullBuilder;

public class NbpNullBuilderTest {
	
	private NbpNullBuilder nbpNullBuilder;
	private Nbp nbp;
	private NbpRates nbpRates;
	
	@Test
	public void shuoldReturnNbpObject_whenMethodGetObjectCalled() {
		//given
		nbpNullBuilder = new NbpNullBuilder();
		//when
		nbp = nbpNullBuilder.getNbp();
		//then
		assertEquals(nbp.getCode(), "");
		assertEquals(nbp.getCurrency(), "");
		assertEquals(nbp.getInfo(), "Wrong date!");
		assertEquals(nbp.getTable(), "");
		
		List<NbpRates> nbpRatesList = nbp.getRates();
		nbpRates = nbpRatesList.get(0);
		
		assertEquals(nbpRates.getNo(), "");
		assertEquals(nbpRates.getEffectiveDate(), "");
		assertEquals(nbpRates.getAsk(), 0.0, 0);
		assertEquals(nbpRates.getBid(), 0.0, 0);
	}
}
