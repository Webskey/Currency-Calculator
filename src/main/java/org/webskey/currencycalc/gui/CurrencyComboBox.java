package org.webskey.currencycalc.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.service.Observer;
import org.webskey.currencycalc.service.UrlReader;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

@Component
public class CurrencyComboBox<T> extends ComboBox<Object> {

	@Autowired
	public UrlReader urlReader;
	
	@Autowired
	private Observer observer;
	
	public CurrencyComboBox() {
		getItems().add("CHF");
		getItems().add("EUR");
		getItems().add("GBP");
		getItems().add("JPY");
		getItems().add("USD");
	
		getSelectionModel().select(2);
		
		setWidth(100);
		
		valueProperty().addListener((ObservableValue<?> ov, Object previousValue, Object currentValue) -> {    
			urlReader.setCurrency((String)currentValue);
			observer.update();
		});
	}
}
