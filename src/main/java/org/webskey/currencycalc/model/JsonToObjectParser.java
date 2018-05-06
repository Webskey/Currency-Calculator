package org.webskey.currencycalc.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectParser {
	
	private Nbp nbp;
	private ObjectMapper mapper;

	public Nbp parse(String json) throws IOException {
		mapper = new ObjectMapper();		
		nbp  = mapper.readValue(json, Nbp.class);
		
		return nbp;
	}
}
