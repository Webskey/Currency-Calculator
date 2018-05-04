package org.webskey.currencycalc.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectParser {

	public Nbp parse(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();		
		Nbp nbp  = mapper.readValue(json, Nbp.class);
		System.out.println(nbp);
		List<NbpArray> myObjects = nbp.getRates();
		for(NbpArray obj: myObjects) {
			System.out.println(obj.toString());
		}
		return nbp;
	}
}
