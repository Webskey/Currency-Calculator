package org.webskey.currencycalc.model;

import java.util.List;

public class Nbp {
	
	private String table;
	private String currency;
	private String code;
	private List<NbpArray> rates;
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<NbpArray> getRates() {
		return rates;
	}
	public void setRates(List<NbpArray> rates) {
		this.rates = rates;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String toString() {
		return this.table+"  "+this.currency;
	}
}