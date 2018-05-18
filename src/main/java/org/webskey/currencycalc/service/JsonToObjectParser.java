package org.webskey.currencycalc.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.webskey.currencycalc.model.Nbp;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonToObjectParser {
	
	private Nbp nbp;
	private ObjectMapper mapper;

	public Nbp parse(String json) throws IOException {
		mapper = new ObjectMapper();		
		nbp  = mapper.readValue(json, Nbp.class);
		
		return nbp;
	}
}
