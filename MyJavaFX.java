// STECH Java programming class
// MyJavaFX
//   from Introduction to Java Programming, Brief Version, 10th edition
//			Chapter 14, listing 14.1, pgs 536-537


// entered by Robin G. Blaine, 09/25/2017


// imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MyJavaFX extends Application {
	
	@Override	// Overide the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 200, 250);
		primaryStage.setTitle("MyJavaFX");	// Set the stage and title
		primaryStage.setScene(scene);		// Place the scene in the stage
		primaryStage.show();				// Display the stage
		
			
	}	//end start
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * The main method is only needed for the IDE with limited		 *
	 * JavaFX support. Not needed for running from the command line. *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public static void main (String[] args) {
		Application.launch(args);
	}
	
}	//end MyJavaFX




