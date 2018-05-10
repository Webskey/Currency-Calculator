package org.webskey.currencycalc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.webskey.currencycalc.model.NbpFactory;
import org.webskey.currencycalc.service.Observer;
import org.webskey.currencycalc.view.CurrencyComboBox;
import org.webskey.currencycalc.view.CurrencyDatePicker;
import org.webskey.currencycalc.view.Layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
			TextField buyTextField = new TextField();
			Label buyCost = new Label();
			//Sell calc
			Label infoAmountToSell = new Label("Enter amount to sell:");
			infoAmountToSell.setStyle("-fx-font-weight: bold;");
			TextField sellTextField = new TextField();
			Label sellCost = new Label();
			//Calc button
			Button buttonCalculate = new Button("Calculate");
			buttonCalculate.setOnAction((ActionEvent event) -> {
				count(buyCost, buyTextField, factory);
				count(sellCost, sellTextField, factory);
			});	
			//Error info label
			Label info = new Label();	
			info.setTextFill(Color.RED);
			
			observer.setLabels(buy, sell, info);
			observer.update();	
			//Layout					
			GridPane gridPane = new Layout(primaryStage, infoName, infoCurrency, infoDate, currencyComboBox, datePicker, infoBuy, infoSell, buy, sell,
					infoAmountToBuy, infoAmountToSell, buyTextField, sellTextField, buyCost, buttonCalculate, sellCost, info);

			Scene scene = new Scene(gridPane);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void count(Label label, TextField textField, NbpFactory factory) {
		try {
			if(!textField.getText().isEmpty()) {
				double buyA = Math.round((Double.valueOf(factory.getAsk()) * Double.valueOf(textField.getText())) * 100);
				label.setText("= " + buyA/100 + " PLN");
				label.setTextFill(Color.BLACK);
			}
		} catch (NumberFormatException e) {
			label.setText("Please enter a number");
			label.setTextFill(Color.RED);
		}
	}

	public static void main(String[] args) {	
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		launch(args);		
	}
}
