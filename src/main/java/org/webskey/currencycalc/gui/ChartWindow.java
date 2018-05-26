package org.webskey.currencycalc.gui;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.NbpRates;
import org.webskey.currencycalc.service.NbpFactory;
import org.webskey.currencycalc.service.UrlReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@Component
public class ChartWindow extends Stage {
	
	private	VBox vBox;
	
	public ChartWindow() {	
		this.vBox = new VBox();
		vBox.setSpacing(10);		
		setTitle("Currency Chart");
		setScene(new Scene(vBox, 500, 500));
		setAlwaysOnTop(true);
		getIcons().add(new Image("/icon.jpg"));
		setResizable(false);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })	
	public void createChart(NbpFactory factory, UrlReader urlReader) {
		//Date interval
		String[] endDateSplit = urlReader.getDate().split("/");
		String endDate = endDateSplit[endDateSplit.length - 1];
		String startDate = LocalDate.parse(endDate).minusDays(30).toString();
		urlReader.setDate(startDate + "/" + endDate);
		factory.setNbp();		
		List<NbpRates> dataSet = factory.getNbp().getRates();
		//xAxis
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Date"); 
		//yAxis  
		double maxY = factory.getNbp().getRates().get(0).getAsk() + 0.25;
		double minY = factory.getNbp().getRates().get(0).getAsk() - 0.25;
		NumberAxis yAxis = new NumberAxis(minY, maxY, 0.10);
		yAxis.setLabel("Price in PLN"); 	
		//LineChart 
		LineChart lineChart = new LineChart(xAxis, yAxis);  
		lineChart.setTitle("Last month prices of " + factory.getNbp().getCurrency());		
		// XYChart.Series
		XYChart.Series series = new XYChart.Series((plot(dataSet)));
		series.setName("Price on current day");
		
		lineChart.getData().add(series); 		
		
		ObservableList<Node> list = vBox.getChildren(); 
		list.clear();
		list.addAll(lineChart);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ObservableList<XYChart.Data<String, Integer>> plot(List<NbpRates> list) {
		final ObservableList<XYChart.Data<String, Integer>> dataset = FXCollections.observableArrayList();
		for(NbpRates nbp : list) {
			final XYChart.Data data = new XYChart.Data(nbp.getEffectiveDate(), nbp.getAsk());
			data.setNode(new HoveredThresholdNode(nbp.getAsk()));
			dataset.add(data);
		}
		return dataset;
	}

	class HoveredThresholdNode extends StackPane {
		HoveredThresholdNode(double value) {
			setPrefSize(15, 15);

			final Label label = createDataThresholdLabel(value);

			setOnMouseEntered(event  -> {
					getChildren().setAll(label);
					setCursor(Cursor.NONE);
					toFront();					
			});
			
			setOnMouseExited(event -> {
					getChildren().clear();
					setCursor(Cursor.CROSSHAIR);				
			});
		}

		private Label createDataThresholdLabel(double value) {
			final Label label = new Label(value + "");
			label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
			label.setStyle("-fx-font-size: 10;");
			label.setTextFill(Color.FORESTGREEN);
			label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);	
			label.toFront();
			return label;
		}
	}
}
