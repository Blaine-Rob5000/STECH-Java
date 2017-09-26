//STECH Java programming class
//Exercise_14_12:  MyBarChart
//created by Robin G. Blaine on 9/25/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

14.12 (Display a bar chart) Write a program that uses a bar chart to display the percentages of the overall grade represented by projects, quizzes, midterm exams, and the final exam, as shown in Figure  14.46b. Suppose that projects take 20 percent and are displayed in red, quizzes take 10 percent and are displayed in blue, midterm exams take 30 percent and are displayed in green, and the final exam takes 40 percent and is displayed in orange. Use the Rectangle class to display the bars. Interested readers may explore the JavaFX BarChart class for further study.

 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;


public class MyBarChart extends Application {
	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		// Create a pane and set properties
		Pane pane = new Pane();
		
		// set weight for project, quiz, midterm, and final
		double projectWeight = .2;
		double quizWeight    = .1;
		double midtermWeight = .3;
		double finalWeight   = .4;
		
		// set strings for bar labels
		String projectText = "Project -- " + (int)(projectWeight * 100) + "%";
		String quizText    = "Quiz -- "    + (int)(quizWeight    * 100) + "%";
		String midtermText = "Midterm -- " + (int)(midtermWeight * 100) + "%";
		String finalText   = "Final -- "   + (int)(finalWeight   * 100) + "%";		
		
		//add labels for bars
		pane.getChildren().add(new Text(5,   140, projectText));
		pane.getChildren().add(new Text(210, 160, quizText));
		pane.getChildren().add(new Text(415, 120, midtermText));
		pane.getChildren().add(new Text(620, 100, finalText));
		
		// Create projectBar and add to the pane
		Rectangle projectBar = new Rectangle(5, 160, 200, 40);
		projectBar.setStroke(Color.RED);
		projectBar.setFill(Color.RED);
		pane.getChildren().add(projectBar);
		
		// Create quizBar and add to the pane
		Rectangle quizBar = new Rectangle(210, 180, 200, 20);
		quizBar.setStroke(Color.BLUE);
		quizBar.setFill(Color.BLUE);
		pane.getChildren().add(quizBar);
		
		//create midtermBar and add to the pane
		Rectangle midtermBar = new Rectangle(415, 140, 200, 60);
		midtermBar.setStroke(Color.GREEN);
		midtermBar.setFill(Color.GREEN);
		pane.getChildren().add(midtermBar);
		
		//create finalBar and add to the pane
		Rectangle finalBar = new Rectangle(620, 120, 200, 80);
		finalBar.setStroke(Color.ORANGE);
		finalBar.setFill(Color.ORANGE);
		pane.getChildren().add(finalBar);
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(pane, 825, 210);
		primaryStage.setTitle("Exercise14_12");	// Set the stage title
		primaryStage.setScene(scene);			// Place the scene in the stage
		primaryStage.show();					// Display the stage
		
	}	// end start
	
	public static void main(String[] args) {
		
		Application.launch(args);
		
	}	//end main
	
}	//end MyBarChart




