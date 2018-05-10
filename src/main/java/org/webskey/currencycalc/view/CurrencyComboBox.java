package org.webskey.currencycalc.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.UrlReader;
import org.webskey.currencycalc.service.Observer;

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
