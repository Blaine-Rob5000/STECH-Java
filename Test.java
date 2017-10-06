//STECH Java programming class
//Test
//created by Robin G. Blaine

//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test extends Application {
	@Override
	public void start(Stage primaryStage) {
		HBox pane = new HBox(5);
		Image usIcon = new Image("http://www.cs.armstrong.edu/liang/image/usIcon.gif");
		Button bt1 = new Button("Button 1", new ImageView(usIcon));
		Button bt2 = new Button("Button 2", new ImageView(usIcon));
		pane.getChildren().addAll(bt1, bt2);
		
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	//end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
}	//end Test
