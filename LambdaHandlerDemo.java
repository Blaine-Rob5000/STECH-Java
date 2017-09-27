// STECH Java Programming Class
// LambdaHandlerDemo.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.5, pages 598-599
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	Handle 4 buttons using lambda handlers.
	
*/


//imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LambdaHandlerDemo extends Application {
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		//Hold 4 buttons in an HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btNew   = new Button("New");
		Button btOpen  = new Button("Open");
		Button btSave  = new Button("Save");
		Button btPrint = new Button("Print");
		hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);
		
		//Create and register the handlers
		btNew.setOnAction((ActionEvent e)   -> {System.out.println("Process New");});
		btOpen.setOnAction((ActionEvent e)  -> {System.out.println("Process Open");});
		btSave.setOnAction((ActionEvent e)  -> {System.out.println("Process Save");});
		btPrint.setOnAction((ActionEvent e) -> {System.out.println("Process Print");});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(hBox, 300, 50);
		primaryStage.setTitle("AnonymousHandlerDemo");		// Set the title
		primaryStage.setScene(scene);						// Place the scene in the stage
		primaryStage.show();								// Display the stage
		
	}	// end start
}	// end AnonymousHandlerDemo