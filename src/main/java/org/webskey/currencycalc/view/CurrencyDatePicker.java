package org.webskey.currencycalc.view;

import java.time.LocalDate;

import org.webskey.currencycalc.model.UrlReader;

import javafx.scene.control.DatePicker;

public class CurrencyDatePicker extends DatePicker {

	public CurrencyDatePicker() {
		
		setValue(LocalDate.now().plusDays(-1));		
	    
		UrlReader.setDate(LocalDate.now().plusDays(-1).toString());
		setOnAction(e -> {
			LocalDate date = getValue();
			UrlReader.setDate(date.toString());
			System.out.println(date.toString());
		});
	}
}
