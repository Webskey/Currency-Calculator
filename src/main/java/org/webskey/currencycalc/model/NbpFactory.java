package org.webskey.currencycalc.model;

import java.io.IOException;

public class NbpFactory {

	private Nbp nbp;
	private JsonToObjectParser json = new JsonToObjectParser();

	/*public NbpFactory() {
		try {
			nbp = json.parse(UrlReader.readURL());
		} catch (IOException e) {
			NbpNullBuilder builder = new NbpNullBuilder();
			nbp = builder.getNbp();
		}
	}*/

	public void setNbp() {
		try {
			this.nbp = json.parse(UrlReader.readURL());			
		} catch (IOException e) {
			NbpNullBuilder builder = new NbpNullBuilder();
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
}
