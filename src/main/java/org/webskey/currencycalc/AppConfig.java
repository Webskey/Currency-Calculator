package org.webskey.currencycalc;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.webskey.currencycalc.gui.ChartWindow;
import org.webskey.currencycalc.gui.CurrencyComboBox;
import org.webskey.currencycalc.gui.CurrencyDatePicker;
import org.webskey.currencycalc.service.JsonToObjectParser;
import org.webskey.currencycalc.service.NbpFactory;
import org.webskey.currencycalc.service.Observer;
import org.webskey.currencycalc.service.UrlReader;

@Configuration
public class AppConfig {
	ChartWindow cw;
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

	@Bean
	public Observer getObserver() {
		return new Observer();
	}

	@Bean
	public JsonToObjectParser jsonToObjectParser() {
		return new JsonToObjectParser();
	}
}
