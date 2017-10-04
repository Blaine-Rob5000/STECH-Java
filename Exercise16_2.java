// STECH Java Programming Class
// Excercise16_2.java
// created/modified by Robin G. Blaine on 10/4/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	16.2 (Select geometric figures) Write a program that draws various figures, as shown in Figure  16.36b. The user selects a figure from a radio button and uses a check box to specify whether it is filled.
		
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;


public class Exercise16_2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		HBox paneForControls = new HBox();
		paneForControls.setPadding(new Insets(5, 5, 5, 5));
		paneForControls.setStyle("-fx-border-color: green");
		paneForControls.setStyle("-fx-border-width: 2px; -fx-border-color: green");
		RadioButton rbCircle    = new RadioButton("Circle");
		RadioButton rbRectangle = new RadioButton("Rectangle");
		RadioButton rbEllipse   = new RadioButton("Ellipse");
		CheckBox    chkFill     = new CheckBox("Fill");
		paneForControls.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, chkFill);
		
		Pane paneForShapes = new Pane();
		Circle circle = new Circle(250, 150, 60);
		circle.setStroke(Color.BLACK);
		Rectangle rectangle = new Rectangle(160, 90, 200, 120);
		rectangle.setStroke(Color.BLACK);
		Ellipse ellipse = new Ellipse(250, 150, 100, 60);
		ellipse.setStroke(Color.BLACK);
		
		pane.setTop(paneForShapes);
		pane.setBottom(paneForControls);
		
		ToggleGroup group = new ToggleGroup();
		rbCircle.setToggleGroup(group);
		rbRectangle.setToggleGroup(group);
		rbEllipse.setToggleGroup(group);
		
		rbCircle.setOnAction(e -> {
			if (rbCircle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(circle);
				if (chkFill.isSelected()) {
					circle.setFill(Color.RED);
				}
				else {
					circle.setFill(Color.WHITE);
				}
			}
		});
		
		rbEllipse.setOnAction(e -> {
			if (rbEllipse.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(ellipse);
				if (chkFill.isSelected()) {
					ellipse.setFill(Color.RED);
				}
				else {
					ellipse.setFill(Color.WHITE);
				}
			}
		});
		
		rbRectangle.setOnAction(e -> {
			if (rbRectangle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(rectangle);
				if (chkFill.isSelected()) {
					rectangle.setFill(Color.RED);
				}
				else {
					rectangle.setFill(Color.WHITE);
				}
			}
		});
		
		chkFill.setOnAction(e ->{
			if (chkFill.isSelected()) {
				circle.setFill(Color.RED);
				ellipse.setFill(Color.RED);
				rectangle.setFill(Color.RED);
			}
			else {
				circle.setFill(Color.WHITE);
				ellipse.setFill(Color.WHITE);
				rectangle.setFill(Color.WHITE);			}
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 350);
		primaryStage.setTitle("Exercise16_2");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
	
}	// end Exercise16_2