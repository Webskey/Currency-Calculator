package org.webskey.currencycalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webskey.currencycalc.model.NbpFactory;
import org.webskey.currencycalc.view.BuyTextField;
import org.webskey.currencycalc.view.SellTextField;

import javafx.scene.control.Label;

@Service
public class Observer {
	
	private Label buy;
	private Label sell;
	private Label info;
	private BuyTextField buyTextField;
	private SellTextField sellTextField;
	
	@Autowired
	private NbpFactory nbpFactory;
	
	public void setLabels(Label buy, Label sell, Label info, BuyTextField buyTextField, SellTextField sellTextField) {
		this.buy = buy;
		this.sell = sell;
		this.info = info;
		this.buyTextField = buyTextField;
		this.sellTextField = sellTextField;
	}
	
	public void update() {
		nbpFactory.setNbp();
		buy.setText(nbpFactory.getAsk());
		sell.setText(nbpFactory.getBid());
		info.setText(nbpFactory.getInfo());	
		buyTextField.count();
		sellTextField.count();
	}
}
