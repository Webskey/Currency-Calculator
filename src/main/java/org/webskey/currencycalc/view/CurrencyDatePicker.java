package org.webskey.currencycalc.view;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class CurrencyDatePicker extends DatePicker {

	public CurrencyDatePicker() {
		
		setValue(LocalDate.now());
	    
		setOnAction(e -> {
			LocalDate date = getValue();
			System.out.println(date);
		});
	}
}
