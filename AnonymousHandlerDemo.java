// STECH Java Programming Class
// AnonymousHandlerDemo.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.4, pages 595-596
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	Handle 4 buttons using anonymous handlers.
	
*/


//imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousHandlerDemo extends Application {
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
		
		// Create and register the handlers
		btNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override	// Override the handle method
			public void handle(ActionEvent e) {
				System.out.println("Process New");
			}
		});	// end btNew handler
		
		btOpen.setOnAction(new EventHandler<ActionEvent>() {
			@Override	// Override the handle method
			public void handle(ActionEvent e) {
				System.out.println("Process Open");
			}
		});	// end btOpen handler
		
		btSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override	// Override the handle method
			public void handle(ActionEvent e) {
				System.out.println("Process Save");
			}
		});	// end btSave handler
		
		btPrint.setOnAction(new EventHandler<ActionEvent>() {
			@Override	// Override the handle method
			public void handle(ActionEvent e) {
				System.out.println("Process Print");
			}
		});	// end btPrint handler
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(hBox, 300, 50);
		primaryStage.setTitle("AnonymousHandlerDemo");		// Set the title
		primaryStage.setScene(scene);						// Place the scene in the stage
		primaryStage.show();								// Display the stage
		
	}	// end start
}	// end AnonymousHandlerDemo