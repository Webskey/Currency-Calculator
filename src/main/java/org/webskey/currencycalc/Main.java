package org.webskey.currencycalc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.gui.BuyTextField;
import org.webskey.currencycalc.gui.ChartWindow;
import org.webskey.currencycalc.gui.CurrencyComboBox;
import org.webskey.currencycalc.gui.CurrencyDatePicker;
import org.webskey.currencycalc.gui.Layout;
import org.webskey.currencycalc.gui.SellTextField;
import org.webskey.currencycalc.service.NbpFactory;
import org.webskey.currencycalc.service.Observer;
import org.webskey.currencycalc.service.UrlReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@Component
public class Main extends Application {

	private static AbstractApplicationContext context;

	@Override
	public void start(Stage primaryStage) {
		try {
			//Beans
			NbpFactory factory = context.getBean(NbpFactory.class);
			Observer observer = context.getBean(Observer.class);
			UrlReader urlReader = context.getBean(UrlReader.class);

			//Logo
			Text infoName = new Text("Currency Calculator");
			infoName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
			infoName.setFill(Color.ROYALBLUE);
			//Currency
			Label infoCurrency = new Label("Currency:");
			infoCurrency.setStyle("-fx-font-weight: bold;");
			ComboBox<?> currencyComboBox = context.getBean(CurrencyComboBox.class);
			//Date
			Label infoDate = new Label("Date:");
			infoDate.setStyle("-fx-font-weight: bold;");
			DatePicker datePicker = context.getBean(CurrencyDatePicker.class);
			//Buy info
			Label infoBuy = new Label("Buy:");
			infoBuy.setStyle("-fx-font-weight: bold;");
			Label buy = new Label();
			//Sell info
			Label infoSell = new Label("Sell:");
			infoSell.setStyle("-fx-font-weight: bold;");
			Label sell = new Label();
			//Buy calc
			Label infoAmountToBuy = new Label("Enter amount to buy:");
			infoAmountToBuy.setStyle("-fx-font-weight: bold;");			
			Label buyCost = new Label();
			TextField buyTextField = new BuyTextField(buyCost, factory);
			//Sell calc
			Label infoAmountToSell = new Label("Enter amount to sell:");
			infoAmountToSell.setStyle("-fx-font-weight: bold;");
			Label sellCost = new Label();
			TextField sellTextField = new SellTextField(sellCost, factory);			
			//Error info label
			Label info = new Label();	
			info.setTextFill(Color.RED);
			//Observer
			observer.setLabels(buy, sell, info, (BuyTextField)buyTextField, (SellTextField)sellTextField);
			observer.update();	
			//ChartWindow
			ChartWindow chartWindow = new ChartWindow(factory, urlReader);
			//ChartButton
			Button chartButton = new Button("Schow chart");
			chartButton.setOnAction((event) -> {										
				chartWindow.show();
			});			
			//Layout					
			GridPane gridPane = new Layout(primaryStage, infoName, infoCurrency, infoDate, currencyComboBox, datePicker, infoBuy, infoSell, buy, sell,
					infoAmountToBuy, infoAmountToSell, buyTextField, sellTextField, buyCost, sellCost, info, chartButton);

			Scene scene = new Scene(gridPane);

			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Currency Calculator");
			primaryStage.getIcons().add(new Image("/icon.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {	
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		launch(args);			
	}
}
