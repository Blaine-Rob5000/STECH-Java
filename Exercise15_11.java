// STECH Java Programming Class
// Excercise15_11.java
// created/modified by Robin G. Blaine on 9/29/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	15.11 (Move a circle using keys) Write a program that moves a circle up, down, left, or right using the arrow keys.
	Hint: Use selection statements such as "e.getCode() == KeyCode.UP" to move the circle a few pixels at a time
	
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Exercise15_11 extends Application {	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane to hold the circle
		Pane pane = new Pane();
		
		int w = 800, h = 800;
		
		// Create a circle and set its properties
		Circle circle = new Circle(w / 2, h / 2, Math.min(h, w) / 20);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		pane.getChildren().add(circle);
		
		// Key handler to move circle
		circle.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN:  circle.setCenterY(circle.getCenterY() + 10); break;
				case UP:    circle.setCenterY(circle.getCenterY() - 10); break;
				case LEFT:  circle.setCenterX(circle.getCenterX() - 10); break;
				case RIGHT: circle.setCenterX(circle.getCenterX() + 10); break;
			}	// end switch
			System.out.println(e.getCode());
		});	// end key handler
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, w, h);
		primaryStage.setTitle("Exercise15_11");		// Set the stage title
		primaryStage.setScene(scene);				// Place the scene on the stage
		primaryStage.show();						// Display the stage
		
		circle.requestFocus();						// text is focused to recieve key input
	}	// end start
}	// end Exercise15_11