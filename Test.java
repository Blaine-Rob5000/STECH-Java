// STECH Java programming class
// Test
// created by Robin G. Blaine

//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Test extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.requestFocus();
		
		pane.setOnKeyPressed(e ->
			System.out.print("Key pressed " + e.getCode() + " "));
		pane.setOnKeyTyped(e ->
			System.out.println("Key typed " + e.getCode()));	
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main
	
}	// end Test
