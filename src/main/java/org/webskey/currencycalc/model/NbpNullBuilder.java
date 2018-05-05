package org.webskey.currencycalc.model;

import java.util.ArrayList;
import java.util.List;

public class NbpNullBuilder {
	
	private Nbp nbp;
	
	public NbpNullBuilder() {
		nbp = new Nbp();
		nbp.setTable("");
		nbp.setCurrency("");
		nbp.setCode("");
		NbpArray nbpArray = new NbpArray();
		nbpArray.setAsk(0);
		nbpArray.setBid(0);
		nbpArray.setNo("");
		nbpArray.setEffectiveDate("");
		List<NbpArray> array = new ArrayList<>();
		array.add(nbpArray);
		nbp.setRates(array);
	}
	
	public Nbp getNbp() {
		return nbp;
	}
}
