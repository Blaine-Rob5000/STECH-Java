// STECH Java programming class
// ScrollBarDemo
// from textbook Introduction to Java Programming, Brief Version, 10th edition
// input/modified by Robin G. Blaine

// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class ScrollBarDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		Text text = new Text(20, 20, "JavaFX Programming");
		
		ScrollBar sbHorizontal = new ScrollBar();
		ScrollBar sbVertical   = new ScrollBar();
		sbVertical.setOrientation(Orientation.VERTICAL);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(sbHorizontal);
		pane.setRight(sbVertical);
		
		sbHorizontal.valueProperty().addListener( ov ->
			text.setX(sbHorizontal.getValue() * paneForText.getWidth() / sbHorizontal.getMax())
		);
		
		sbVertical.valueProperty().addListener(ov ->
			text.setY(sbVertical.getValue() * paneForText.getHeight() / sbVertical.getMax())
		);
				
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setTitle("ListViewDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main
	
}	// end ScrollBarDemo
