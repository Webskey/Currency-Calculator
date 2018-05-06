package org.webskey.currencycalc.view;

import org.webskey.currencycalc.model.UrlReader;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

public class CurrencyComboBox<T> extends ComboBox<Object> {

	public CurrencyComboBox() {
		getItems().add("CHF");
		getItems().add("EUR");
		getItems().add("GBP");
		getItems().add("JPY");
		getItems().add("USD");
	
		getSelectionModel().select(2);
		
		setWidth(100);
		
		UrlReader.setCurrency("gbp");
		valueProperty().addListener((ObservableValue<?> ov, Object previousValue, Object currentValue) -> {    
			UrlReader.setCurrency((String)currentValue);
		});
	}
}
