package org.webskey.currencycalc;

import org.webskey.currencycalc.model.NbpFactory;
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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text infoName = new Text("Currency Calculator");
			infoName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
			infoName.setFill(Color.ROYALBLUE);

			Label infoCurrency = new Label("Currency:");
			infoCurrency.setStyle("-fx-font-weight: bold;");
			ComboBox<Object> currencyComboBox = new CurrencyComboBox<Object>();

			Label infoDate = new Label("Date:");
			infoDate.setStyle("-fx-font-weight: bold;");
			DatePicker datePicker = new CurrencyDatePicker();

			Label infoBuy = new Label("Buy:");
			infoBuy.setStyle("-fx-font-weight: bold;");
			Label infoSell = new Label("Sell:");
			infoSell.setStyle("-fx-font-weight: bold;");

			Label infoAmountToBuy = new Label("Enter amount to buy:");
			infoAmountToBuy.setStyle("-fx-font-weight: bold;");
			TextField buyTextField = new TextField();

			Label infoAmountToSell = new Label("Enter amount to sell:");
			infoAmountToSell.setStyle("-fx-font-weight: bold;");
			TextField sellTextField = new TextField();

			Label buyCost = new Label();
			Label sellCost = new Label();

			NbpFactory factory = new NbpFactory();
			factory.setNbp();
			Label buy = new Label(factory.getAsk());			
			Label sell = new Label(factory.getBid());
			Label info = new Label(factory.getNbp().getInfo());
			info.setTextFill(Color.RED);

			Button button = new Button("Calculate");
			Button buttonC = new Button("GET");
			buttonC.setOnAction((ActionEvent event) -> {
				factory.setNbp();
				buy.setText(factory.getAsk());
				sell.setText(factory.getBid());	
				info.setText(factory.getNbp().getInfo());			
			});			

			button.setOnAction((ActionEvent event) -> {
				Omin(buyCost, buyTextField, factory);
				Omin(sellCost, sellTextField, factory);
			});						

			GridPane gridPane = new Layout(primaryStage, infoName, infoCurrency, infoDate, currencyComboBox, datePicker, infoBuy, infoSell, buy, sell,
					infoAmountToBuy, infoAmountToSell, buyTextField, sellTextField, buyCost, button, sellCost, buttonC, info);

			Scene scene = new Scene(gridPane);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void Omin(Label label, TextField tx, NbpFactory fc) {
		try {
			if(!tx.getText().isEmpty()) {
				double buyA = Math.round((Double.valueOf(fc.getAsk()) * Double.valueOf(tx.getText())) * 100);
				label.setText("= " + buyA/100 + " PLN");
				label.setTextFill(Color.BLACK);
			}
		} catch (NumberFormatException e) {
			label.setText("Please enter a number");
			label.setTextFill(Color.RED);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
