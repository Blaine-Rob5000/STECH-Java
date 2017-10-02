// STECH Java programming class
// Module 7 Quiz, Question 4
// created by Robin G. Blaine

// imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class Quiz7_Question4 extends Application {
	@Override
	public void start(Stage primaryStage){
		HBox pane = new HBox(5);
		Circle circle = new Circle(50, 200, 200);
		pane.getChildren().addAll(circle);
		
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		pane.getChildren().addAll(circle);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Quiz7_Question4");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}