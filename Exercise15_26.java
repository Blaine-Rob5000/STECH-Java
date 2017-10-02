// STECH Java Programming Class
// Excercise15_26.java
// created/modified by Robin G. Blaine on 9/29/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	15.26 (Change opacity) Rewrite Programming Exercise 15.24 so that the ball’s opacity is changed as it swings.
	Hint: Use the object "FadeTransition" with a duration of 3000 milliseconds varying from 1.0 to .1 fading
		
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exercise15_26 extends Application {
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		// Create a circle
		Circle circle = new Circle(250, 225, 25);
		circle.setFill(Color.ORANGE);
		
		// Create an arc
		Arc arc = new Arc(250, 150, 125, 75, 210, 120);
		arc.setStroke(Color.BLACK);
		arc.setFill(Color.WHITE);
		
		// Add arc and circle to the pane
		pane.getChildren().add(arc);
		pane.getChildren().add(circle);
		
		// Apply a fade transition to the circle
		FadeTransition ft = new FadeTransition(Duration.millis(3000), circle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();										// Start animation
		
		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(3000));
		pt.setPath(arc);
		pt.setNode(circle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();										// Start animation
		
		circle.setOnMousePressed(e -> pt.pause());
		circle.setOnMouseReleased(e -> pt.play());
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Exercise15_26");	// Set the stage's title
		primaryStage.setScene(scene);					// Place the scene in the stage
		primaryStage.show();							// Display the stage
	}	// end start
	
	// Main method
	public static void main(String[] args) {
		Application.launch(args);
	}	// end main 
}	// end Exercise15_26
