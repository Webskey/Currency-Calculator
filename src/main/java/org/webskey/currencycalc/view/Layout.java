package org.webskey.currencycalc.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Layout extends GridPane {

	public Layout(Stage scene, Node... args) {
		ColumnConstraints column0 = new ColumnConstraints();
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		column0.setMaxWidth(150);
		column0.setMinWidth(100);
		column2.setMaxWidth(150);
		column2.setMinWidth(100);
		//columnConstraints.setPercentWidth(50);
		getColumnConstraints().addAll(column0, column1, column2);
		setMinSize(800, 640); 
		setPadding(new Insets(10, 10, 10, 10)); 

		setVgap(10); 
		setHgap(10);       

		setAlignment(Pos.CENTER); 
		//Logo
		add(args[0], 0, 0, 3, 1); 
		GridPane.setHalignment(args[0], HPos.CENTER);
		//"Currency:" label
		add(args[1], 0, 2);  
		//"Date:" label
		add(args[2], 2, 2);  
		//currency ComboBox
		add(args[3], 0, 3);  
		GridPane.setHalignment(args[3], HPos.CENTER);
		// DatePicker
		add(args[4], 2, 3); 
		GridPane.setHalignment(args[4], HPos.CENTER);
		//"Buy:" label
		add(args[5], 0, 4);  
		GridPane.setMargin(args[5], new Insets(20, 0, 0, 0));
		//"Sell:" label
		add(args[6], 2, 4); 
		GridPane.setMargin(args[6], new Insets(20, 0, 0, 0));
		//buy price
		add(args[7], 0, 5);  
		GridPane.setHalignment(args[7], HPos.CENTER);
		//sell price
		add(args[8], 2, 5);
		GridPane.setHalignment(args[8], HPos.CENTER);
		//buy textfield
		add(args[9], 0, 6);  
		GridPane.setHalignment(args[9], HPos.CENTER);
		//sell textfield
		add(args[10], 2, 6);
		GridPane.setHalignment(args[10], HPos.CENTER);
		//button
		add(args[11], 1, 7);       
	}
}
