package org.webskey.currencycalc.gui;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.NbpRates;
import org.webskey.currencycalc.service.NbpFactory;
import org.webskey.currencycalc.service.UrlReader;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class ChartWindow extends Stage {

	public ChartWindow(NbpFactory factory, UrlReader urlReader) {

		NumberAxis xAxis = new NumberAxis(0, 30, 1); 
		xAxis.setLabel("Date"); 

		//Defining the y axis   
		NumberAxis yAxis = new NumberAxis(factory.getNbp().getRates().get(0).getAsk()-0.25, factory.getNbp().getRates().get(0).getAsk()+0.25, 0.10); 
		yAxis.setLabel("Price"); 

		//Creating the line chart 
		LineChart linechart = new LineChart(xAxis, yAxis);  

		//Prepare XYChart.Series objects by setting data 
		XYChart.Series series = new XYChart.Series(); 
		series.setName("No of schools in an year"); 

		linechart.getData().add(series); 

		String endDate = factory.getNbp().getRates().get(0).getEffectiveDate();
		String startDate = LocalDate.parse(endDate).minusDays(30).toString();
		urlReader.setDate(startDate + "/" + endDate);
		factory.setNbp();
		int day = 0;
		System.out.println(factory.getNbp().getRates().size());
		for(NbpRates nbp : factory.getNbp().getRates()) {
			series.getData().add(new XYChart.Data(day, nbp.getAsk())); 
			day++;
		}

		VBox vBox = new VBox();
		vBox.setSpacing(10);

		ObservableList<Node> list = vBox.getChildren(); 
		list.addAll(linechart);

		setTitle("Currency Chart");
		setScene(new Scene(vBox, 500, 500));
		setAlwaysOnTop(true);
		getIcons().add(new Image("/icon.jpg"));
		setResizable(false);
	}
}
