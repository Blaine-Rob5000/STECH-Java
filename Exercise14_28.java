//STECH Java Programming Class
//Exercise14_28
//created by Robin G. Blaine on 9/26/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

14.28 (Random time) Modify the ClockPane class with three new Boolean properties— hourHandVisible , minuteHandVisible , and secondHandVisible —and their associated accessor and mutator methods. You can use the set methods to make a hand visible or invisible. Write a test program that displays only the hour and minute hands. The hour and minute values are randomly generated. The hour is between 0 and 11 , and the minute is either 0 or 30 , as shown in Figure  14.52b.

 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// java.util imports
import java.util.Random;

// javafx imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Exercise14_28 extends Application {
	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		// create a random ClockPane
		Random rand = new Random();
		
		ClockPane randomClock = new ClockPane();
		randomClock.setMinute(rand.nextInt(2) * 30);
		randomClock.setHour(rand.nextInt(12));
		randomClock.setSecondVisible(false);
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(randomClock, randomClock.getW(), randomClock.getH());
		primaryStage.setTitle("Exercise14_28");	// Set the stage title
		primaryStage.setScene(scene);			// Place the scene in the stage
		primaryStage.show();					// Display the stage
		
	}	// end start
	
	public static void main(String[] args) {
		Application.launch(args);
	}	// end main
	
}	// end Exercise14_28