package org.webskey.currencycalc;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.webskey.currencycalc.model.NbpFactory;
import org.webskey.currencycalc.model.UrlReader;
import org.webskey.currencycalc.view.CurrencyComboBox;
import org.webskey.currencycalc.view.CurrencyDatePicker;

@Configuration
public class AppConfig {

	@Bean
	public UrlReader getUrlReader() throws IOException {
		return new UrlReader();
	}

	@Bean
	public CurrencyComboBox<Object> getCurrencyComboBox() {
		return new CurrencyComboBox<Object>();
	}

	@Bean
	public CurrencyDatePicker getCurrencyDatePicker() {
		return new CurrencyDatePicker();
	}

	@Bean
	public NbpFactory getNbpFactory() {
		return new NbpFactory();
	}
}
