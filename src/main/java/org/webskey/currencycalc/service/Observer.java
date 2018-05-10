package org.webskey.currencycalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webskey.currencycalc.model.NbpFactory;

import javafx.scene.control.Label;

@Service
public class Observer {
	
	private Label buy;
	private Label sell;
	private Label info;
	
	@Autowired
	private NbpFactory nbpFactory;
	
	public void setLabels(Label buy, Label sell, Label info) {
		this.buy = buy;
		this.sell = sell;
		this.info = info;
	}
	
	public void update() {
		nbpFactory.setNbp();
		buy.setText(nbpFactory.getAsk());
		sell.setText(nbpFactory.getBid());
		info.setText(nbpFactory.getInfo());		
	}
}
