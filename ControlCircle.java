// STECH Java Programming Class
// ControlCircle.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 15.3, pages 592-593
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	Draw a circle and enlarge or shrink it using two buttons.
	
*/


//imports
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
	private CirclePane circlePane = new CirclePane();
	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Hold the buttons in an HBox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink  = new Button("Shrink");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);
		
		// Create and register the handler
		btEnlarge.setOnAction(new EnlargeHandler());
		btShrink.setOnAction(new ShrinkHandler());
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		borderPane.setAlignment(hBox, Pos.CENTER);
		
		// Create a scene and place it in the stage
		int w = 200, h = 150;
		Scene scene = new Scene(borderPane, w, h);
		primaryStage.setTitle("ControlCircle");		// Set the stage title
		primaryStage.setScene(scene);				// Place the scene on the stage
		primaryStage.show();						// Display the stage
	}	// end start
	
	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override	// Override the handle method
		public void handle(ActionEvent e) {
			circlePane.enlarge();
		}	// end handle override
	}	// end EnlargeHandler
	
	class ShrinkHandler implements EventHandler<ActionEvent> {
		@Override	// Override the handle method
		public void handle(ActionEvent e) {
			circlePane.shrink();
		}	// end handle override
	}	// end ShrinkHandler
}	// end ControlCircle

class CirclePane extends StackPane {
	private Circle circle = new Circle(50);
	
	public CirclePane() {
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
	}	// end CirclePane default constructor
	
	public void enlarge() {
		double maxRadius = Math.min(this.getWidth(), this.getHeight()) * .45;
		circle.setRadius(circle.getRadius() < maxRadius ?
			circle.getRadius() + 2 : circle.getRadius());
		System.out.println(circle.getRadius());
	}	// end enlarge method
	
	public void shrink() {
		circle.setRadius(circle.getRadius() > 2 ?
			circle.getRadius() - 2 : circle.getRadius());
			System.out.println(circle.getRadius());
	}	// end shrink method
}	// end CirclePane class
