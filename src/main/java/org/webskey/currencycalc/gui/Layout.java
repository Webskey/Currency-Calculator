package org.webskey.currencycalc.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Layout extends GridPane {

	public Layout(Stage scene, Node... args) {
		ColumnConstraints column0 = new ColumnConstraints();
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		column0.setMaxWidth(150);
		column0.setMinWidth(100);
		column1.setMaxWidth(100);
		column1.setMinWidth(70);
		column2.setMaxWidth(150);
		column2.setMinWidth(100);

		getColumnConstraints().addAll(column0, column1, column2);

		setPadding(new Insets(50, 50, 50, 50)); 

		setVgap(10); 
		setHgap(10);       

		setAlignment(Pos.CENTER); 
		//Logo
		add(args[0], 0, 0, 3, 1); 
		GridPane.setHalignment(args[0], HPos.CENTER);
		GridPane.setMargin(args[0], new Insets(0, 0, 20, 0));
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
		//buyInfoTextField label
		GridPane.setMargin(args[9], new Insets(20, 0, 0, 0));
		add(args[9], 0, 6);  
		//sellInfoTextField label
		GridPane.setMargin(args[10], new Insets(20, 0, 0, 0));
		add(args[10], 2, 6);
		//buy textfield
		add(args[11], 0, 7);  
		GridPane.setHalignment(args[11], HPos.CENTER);
		//sell textfield
		add(args[12], 2, 7);
		GridPane.setHalignment(args[12], HPos.CENTER);
		//buyCostInfo Label
		add(args[13], 0, 8);
		GridPane.setHalignment(args[13], HPos.CENTER);
		//sellCostInfo Label
		add(args[14], 2, 8);
		GridPane.setHalignment(args[14], HPos.CENTER);
		//info
		add(args[15], 1, 5);
		GridPane.setHalignment(args[15], HPos.CENTER);
	}
}
