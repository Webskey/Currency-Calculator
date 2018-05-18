package org.webskey.currencycalc.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.Nbp;

@Component
public class NbpFactory {

	@Autowired
	private UrlReader urlReader;
	
	@Autowired
	private JsonToObjectParser json;

	private Nbp nbp;
	private NbpNullBuilder builder;	

	public void setNbp() {
		try {
			this.nbp = json.parse(urlReader.readURL());
		} catch (IOException e) {
			builder = new NbpNullBuilder();
			nbp = builder.getNbp();
		}
	}

	public Nbp getNbp() {
		return nbp;
	}

	public String getBid() {
		return String.valueOf(nbp.getRates().get(0).getBid());
	}

	public String getAsk() {		
		return String.valueOf(nbp.getRates().get(0).getAsk());
	}
	
	public String getInfo() {
		return nbp.getInfo();
	}
}
