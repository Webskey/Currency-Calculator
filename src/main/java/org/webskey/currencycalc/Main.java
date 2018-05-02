package org.webskey.currencycalc;

import org.webskey.currencycalc.view.CurrencyComboBox;
import org.webskey.currencycalc.view.CurrencyDatePicker;
import org.webskey.currencycalc.view.Layout;

import javafx.application.Application;
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
			Label infoDate = new Label("Date:");
			Label infoBuy = new Label("Buy:");
			Label infoSell = new Label("Sell:");

			Label buy = new Label("5.5874");			
			Label sell = new Label("4.8763");

			Button button = new Button("Button");
			TextField buyTextField = new TextField();
			TextField sellTextField = new TextField();
			
			DatePicker datePicker = new CurrencyDatePicker();
					
			ComboBox<Object> comboBox = new CurrencyComboBox<Object>();			

			GridPane gridPane = new Layout(primaryStage, infoName, infoCurrency, infoDate, comboBox, datePicker, infoBuy, infoSell, buy, sell,
					buyTextField, sellTextField, button);
			

			Scene scene = new Scene(gridPane);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
