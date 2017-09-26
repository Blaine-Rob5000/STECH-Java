//STECH Java programming class
//Exercise_14_16:  JavaFXGrid
//created by Robin G. Blaine on 9/25/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

14.16 (Display a grid) Write a program that displays a grid, as shown in Figure  14.47c. Use red color for vertical lines and blue for horizontals. The lines are automatically resized when the window is resized.

 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;


public class JavaFXGrid extends Application {
	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		//Create a scene and place it on the stage
		Scene scene = new Scene(new LinePane(), 200, 200);
		primaryStage.setTitle("Exercise14_16");	// Set the stage title
		primaryStage.setScene(scene);			// Place the scene in the stage
		primaryStage.show();					// Display the stage
		
	}	// end start
	
	public static void main(String[] args) {
		Application.launch(args);
	}	// end main
	
}	// end MyBarChart

class LinePane extends Pane {
	public LinePane () {
		Line leftVerticalLine = new Line(0, 0, 0, 0);
		leftVerticalLine.startXProperty().bind(widthProperty().multiply(.33));
		leftVerticalLine.endXProperty().bind(widthProperty().multiply(.33));
		leftVerticalLine.endYProperty().bind(heightProperty());
		leftVerticalLine.setStrokeWidth(5);
		leftVerticalLine.setStroke(Color.RED);
		getChildren().add(leftVerticalLine);
		
		Line rightVerticalLine = new Line(0, 0, 0, 0);
		rightVerticalLine.startXProperty().bind(widthProperty().multiply(.67));
		rightVerticalLine.endXProperty().bind(widthProperty().multiply(.67));
		rightVerticalLine.endYProperty().bind(heightProperty());
		rightVerticalLine.setStrokeWidth(5);
		rightVerticalLine.setStroke(Color.RED);		
		getChildren().add(rightVerticalLine);
		
		Line upperHorizontalLine = new Line(0, 0, 0, 0);
		upperHorizontalLine.startYProperty().bind(heightProperty().multiply(.33));
		upperHorizontalLine.endXProperty().bind(widthProperty());
		upperHorizontalLine.endYProperty().bind(heightProperty().multiply(.33));
		upperHorizontalLine.setStrokeWidth(5);
		upperHorizontalLine.setStroke(Color.BLUE);
		getChildren().add(upperHorizontalLine);
		
		Line lowerHorizontalLine = new Line(0, 0, 0, 0);
		lowerHorizontalLine.startYProperty().bind(heightProperty().multiply(.67));
		lowerHorizontalLine.endXProperty().bind(widthProperty());
		lowerHorizontalLine.endYProperty().bind(heightProperty().multiply(.67));
		lowerHorizontalLine.setStrokeWidth(5);
		lowerHorizontalLine.setStroke(Color.BLUE);
		getChildren().add(lowerHorizontalLine);
		
	}	// end LinePane default constructor
}	// end LinePane class


