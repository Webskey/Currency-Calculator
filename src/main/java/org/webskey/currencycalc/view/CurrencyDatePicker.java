package org.webskey.currencycalc.view;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.UrlReader;
import org.webskey.currencycalc.service.Observer;

import javafx.scene.control.DatePicker;

@Component
public class CurrencyDatePicker extends DatePicker {

	@Autowired
	private UrlReader urlReader;
	
	@Autowired
	private Observer observer;
	
	public CurrencyDatePicker() {
		
		setValue(LocalDate.now());		
	    
		setOnAction(e -> {
			LocalDate date = getValue();
			urlReader.setDate(date.toString());
			observer.update();
		});
	}
}
