// STECH Java Programming Class
// HandleEvent.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.1, page 587
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	A simple event handler example
	
*/


//imports
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleEvent extends Application {
	@Override									// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);
		
		Button btOK = new Button("OK");
		OKHandlerClass handler1 = new OKHandlerClass();
		btOK.setOnAction(handler1);
		
		Button btCancel = new Button("Cancel");
		CancelHandlerClass handler2 = new CancelHandlerClass();
		btCancel.setOnAction(handler2);
		
		pane.getChildren().addAll(btOK, btCancel);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("HandleEvent");	// Set the stage title
		primaryStage.setScene(scene);			// Place the scene in the stage
		primaryStage.show();					// Display the stage
	}	// end start
}	// end HandleEvent

class OKHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("OK button clicked");
	}	// end handle
}	// end OKHandlerClass

class CancelHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Cancel button clicked");
	}	// end handle
}	// end CancelHandlerClass



