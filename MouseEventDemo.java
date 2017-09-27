// STECH Java Programming Class
// MouseEventDemo.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.7, pages 602-603
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	Example of a mouse event handler.
	
*/


//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MouseEventDemo extends Application {
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Programming is fun!");
		pane.getChildren().addAll(text);
		text.setOnMouseDragged(e -> {
			text.setX(e.getX());
			text.setY(e.getY());
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("MouseEventDemo");		// Set the stage title
		primaryStage.setScene(scene);					// Place the scene in the stage
		primaryStage.show();							// Display the stage
	}	// end start
}	// end MouseEventDemo