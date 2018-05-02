package org.webskey.currencycalc.view;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

public class CurrencyComboBox<T> extends ComboBox<Object> {

	public CurrencyComboBox() {
		getItems().add("CHF");
		getItems().add("EUR");
		getItems().add("GBP");
		getItems().add("RUB");
		getItems().add("USD");
	
		getSelectionModel().select(2);
		
		setWidth(100);
		
		valueProperty().addListener((ObservableValue<?> ov, Object previousValue, Object currentValue) -> {     
			System.out.println(currentValue);
		});
	}
}
