// STECH Java Programming Class
// ClockAnimation.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.16, pages 610-611
// input/revised by Robin G. Blaine on 9/29/17

/*
	
	Animate ClockPane
	
*/


// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;

public class ClockAnimation extends Application {
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		ClockPane clock = new ClockPane();			// Create a clock
		
		// Create a handler for the animation
		EventHandler<ActionEvent> eventHandler = e -> {clock.setCurrentTime();};
		
		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();							// Start animation
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(clock, 250, 250);
		primaryStage.setTitle("ClockAnimation");	// Set the title for the stage
		primaryStage.setScene(scene);				// Place the scene in the stage
		primaryStage.show();						// Display the stage
	}	// end start
}	// end ClockAnimation



