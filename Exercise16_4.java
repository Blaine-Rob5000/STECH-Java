// STECH Java Programming Class
// Excercise16_4.java
// created/modified by Robin G. Blaine on 10/5/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	16.4 (Create a miles/kilometers converter) Write a program that converts miles and kilometers, as shown in Figure  16.37b. If you enter a value in the Mile text field and press the Enter key, the corresponding kilometer measurement is displayed in the Kilometer text field. Likewise, if you enter a value in the Kilometer text field and press the Enter key, the corresponding miles is displayed in the Mile text field.
			
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.lang.*;


public class Exercise16_4 extends Application {
	@Override
	public void start(Stage primaryStage) {		
		GridPane pane = new GridPane();
		
		TextField tfMiles = new TextField();
		tfMiles.setAlignment(Pos.BOTTOM_RIGHT);
		TextField tfKilometers = new TextField();
		tfKilometers.setAlignment(Pos.BOTTOM_RIGHT);
		
		pane.add(new Label("Miles"), 0, 0);
		pane.add(tfMiles, 1, 0);
		pane.add(new Label("Kilometers"), 0, 1);
		pane.add(tfKilometers, 1, 1);
		
		tfMiles.setOnAction(e -> {
			tfKilometers.setText(String.valueOf(Double.parseDouble(tfMiles.getText()) * 1.60934));
		});
		
		tfKilometers.setOnAction(e -> {
			tfMiles.setText(String.valueOf(Double.parseDouble(tfKilometers.getText()) / 1.60934));
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 60);
		primaryStage.setTitle("Exercise16_4");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
	
}	// end Exercise16_4
