// STECH Java Programming Class
// KeyEventDemo.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.8, pages 610-611
// input/revised by Robin G. Blaine on 9/29/17

/*
	
	Animation example
	
*/


// imports
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathTransitionDemo extends Application {
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		// Create a rectangle
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.ORANGE);
		
		// Create a circle
		Circle circle = new Circle(125, 100, 50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		// Add circle and rectangle to the pane
		pane.getChildren().add(circle);
		pane.getChildren().add(rectangle);
		
		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(circle);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();										// Start animation
		
		circle.setOnMousePressed(e -> pt.pause());
		circle.setOnMouseReleased(e -> pt.play());
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("PathTransitionDemo");	// Set the stage's title
		primaryStage.setScene(scene);					// Place the scene in the stage
		primaryStage.show();							// Display the stage
	}	// end start
}	// PathTransitionDemo