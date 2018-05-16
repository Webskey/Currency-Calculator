package org.webskey.currencycalc.view;

import org.webskey.currencycalc.model.NbpFactory;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SellTextField extends TextField {
	private NbpFactory nbpFactory;
	private Label sellCost;
	
	public SellTextField(Label sellCost, NbpFactory nbpFactory) {
		this.sellCost = sellCost;
		this.nbpFactory = nbpFactory;
		
		textProperty().addListener((observable, oldValue, newValue) -> {
			count();
		});
		
		setOnAction((event) -> {
			count();
		});
	}
	
	public void count() {
		try {
			if(!this.getText().isEmpty()) {
				double buyA = Math.round((Double.valueOf(nbpFactory.getBid()) * Double.valueOf(this.getText())) * 100);
				sellCost.setText("= " + buyA/100 + " PLN");
				sellCost.setTextFill(Color.BLACK);
			}
		} catch (NumberFormatException e) {
			sellCost.setText("Incorrect input!");
			sellCost.setTextFill(Color.RED);
		}
	}
}
