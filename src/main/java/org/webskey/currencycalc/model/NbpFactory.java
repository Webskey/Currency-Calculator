package org.webskey.currencycalc.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NbpFactory {

	@Autowired
	private UrlReader urlReader;

	private Nbp nbp;
	
	private JsonToObjectParser json;

	public void setNbp() {
		json = new JsonToObjectParser();
		try {
			this.nbp = json.parse(urlReader.readURL());
			nbp.setInfo("");
		} catch (IOException e) {
			NbpNullBuilder builder = new NbpNullBuilder();
			nbp = builder.getNbp();
			nbp.setInfo("Wrong date!");
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
