package org.webskey.currencycalc.service;

import java.util.ArrayList;
import java.util.List;

import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.model.NbpRates;

public class NbpNullBuilder {
	
	private Nbp nbp;
	
	public NbpNullBuilder() {
		nbp = new Nbp();
		nbp.setTable("");
		nbp.setCurrency("");
		nbp.setCode("");
		nbp.setInfo("Wrong date!");
		
		NbpRates nbpRates = new NbpRates();
		nbpRates.setAsk(0);
		nbpRates.setBid(0);
		nbpRates.setNo("");
		nbpRates.setEffectiveDate("");
		
		List<NbpRates> array = new ArrayList<>();
		array.add(nbpRates);
		nbp.setRates(array);
	}
	
	public Nbp getNbp() {
		return nbp;
	}
}
