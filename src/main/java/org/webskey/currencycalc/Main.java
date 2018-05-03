package org.webskey.currencycalc;

import org.webskey.currencycalc.model.JsonToObjectParser;
import org.webskey.currencycalc.model.Nbp;
import org.webskey.currencycalc.model.UrlReader;
import org.webskey.currencycalc.view.CurrencyComboBox;
import org.webskey.currencycalc.view.CurrencyDatePicker;
import org.webskey.currencycalc.view.Layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			JsonToObjectParser json = new JsonToObjectParser();
			
			
			Text infoName = new Text("Currency Calculator");
			infoName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
			infoName.setFill(Color.ROYALBLUE);

			Label infoCurrency = new Label("Currency:");
			ComboBox<Object> currencyComboBox = new CurrencyComboBox<Object>();
			
			Label infoDate = new Label("Date:");
			DatePicker datePicker = new CurrencyDatePicker();
			
			Label infoBuy = new Label("Buy:");
			Label infoSell = new Label("Sell:");
			
			Label infoAmountToBuy = new Label("Enter amount to buy:");
			TextField buyTextField = new TextField();
			
			Label infoAmountToSell = new Label("Enter amount to sell:");
			TextField sellTextField = new TextField();
			
			Label buyCost = new Label("= 50,32 PLN");
			Label sellCost = new Label("= 43,23 PLN");

			Nbp nbp = json.parse(UrlReader.readURL());
			Label buy = new Label(String.valueOf(nbp.getRates().get(0).getAsk()));			
			Label sell = new Label(String.valueOf(nbp.getRates().get(0).getBid()));

			Button button = new Button("Calculate");
			Button buttonC = new Button("GET");
			buttonC.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Nbp nbp = json.parse(UrlReader.readURL());
					System.out.println(UrlReader.readURL());
					buy.setText(String.valueOf(nbp.getRates().get(0).getAsk()));
					sell.setText(String.valueOf(nbp.getRates().get(0).getBid()));
				}
			});			
			
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Nbp nbp = json.parse(UrlReader.readURL());
					buyCost.setText("= " + String.valueOf(nbp.getRates().get(0).getAsk() * Double.valueOf(buyTextField.getText())));
					sellCost.setText("= " + String.valueOf(nbp.getRates().get(0).getBid() * Double.valueOf(sellTextField.getText())));
				}
			});						

			GridPane gridPane = new Layout(primaryStage, infoName, infoCurrency, infoDate, currencyComboBox, datePicker, infoBuy, infoSell, buy, sell,
					infoAmountToBuy, infoAmountToSell, buyTextField, sellTextField, buyCost, button, sellCost, buttonC);

			Scene scene = new Scene(gridPane);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userParser() {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
