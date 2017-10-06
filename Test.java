//STECH Java programming class
//Test
//created by Robin G. Blaine

//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Button bt1 = new Button("Java");
		Button bt2 = new Button("Java");
		Button bt3 = new Button("Java");
		Button bt4 = new Button("Java");
		pane.getChildren().addAll(bt1, bt2, bt3, bt4);
		
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	//end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
}	//end Test
