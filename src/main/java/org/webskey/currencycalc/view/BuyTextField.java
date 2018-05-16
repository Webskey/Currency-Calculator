package org.webskey.currencycalc.view;

import org.webskey.currencycalc.model.NbpFactory;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BuyTextField  extends TextField {
	private NbpFactory nbpFactory;
	private Label buyCost;

	public BuyTextField(Label buyCost, NbpFactory nbpFactory) {
		this.buyCost = buyCost;
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
				double buyA = Math.round((Double.valueOf(nbpFactory.getAsk()) * Double.valueOf(this.getText())) * 100);
				buyCost.setText("= " + buyA/100 + " PLN");
				buyCost.setTextFill(Color.BLACK);
			}
		} catch (NumberFormatException e) {
			buyCost.setText("Incorrect input!");
			buyCost.setTextFill(Color.RED);
		}
	}
}