//STECH Java Programming Class
//Exercise15_4.java
//created by Robin G. Blaine on 9/29/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

15.4 (Create a simple calculator) Write a program to perform addition, subtraction, multiplication, and division, as shown in Figure  15.25a.

Hint: be sure to declare your class as public, codeRunner will doesn't define this automatically
 
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise15_4 extends Application {
	private TextField tfNumber1 = new TextField();
	private TextField tfNumber2 = new TextField();
	private TextField tfResult  = new TextField();
	
	private Button btAdd      = new Button("Add");
	private Button btSubtract = new Button("Subtract");
	private Button btMultiply = new Button("Multiply");
	private Button btDivide   = new Button("Divide");
	
	
	@Override	// Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("        Number 1:"), 0, 0);
		gridPane.add(tfNumber1,                      1, 0);
		gridPane.add(new Label("        Number 2:"), 2, 0);
		gridPane.add(tfNumber2,                      3, 0);
		gridPane.add(new Label("          Result:"), 4, 0);
		gridPane.add(tfResult,                       5, 0);
		gridPane.add(btAdd,                          1, 1);
		gridPane.add(btSubtract,                     2, 1);
		gridPane.add(btMultiply,                     3, 1);
		gridPane.add(btDivide,                       4, 1);
		
		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		tfNumber1.setAlignment(Pos.CENTER_RIGHT);
		tfNumber2.setAlignment(Pos.CENTER_RIGHT);
		tfResult.setAlignment(Pos.CENTER_RIGHT);
		tfResult.setEditable(false);
		GridPane.setHalignment(btAdd,      HPos.CENTER);
		GridPane.setHalignment(btSubtract, HPos.CENTER);
		GridPane.setHalignment(btMultiply, HPos.CENTER);
		GridPane.setHalignment(btDivide,   HPos.CENTER);

		// Process events
		btAdd.setOnAction(e -> addNumbers());
		btSubtract.setOnAction(e -> subtractNumbers());
		btMultiply.setOnAction(e -> multiplyNumbers());
		btDivide.setOnAction(e -> divideNumbers());
		
		// Create a scene and place it on the stage
		Scene scene = new Scene(gridPane, 900, 100);
		primaryStage.setTitle("Exercise15_4");			// Set title
		primaryStage.setScene(scene);					// Place the scene on the stage
		primaryStage.show();							// Display the stage
	}	// end start
	
	private void addNumbers() {
		// Get values from text fields
		double number1 = Double.parseDouble(tfNumber1.getText());
		double number2 = Double.parseDouble(tfNumber2.getText());
				
		// add the numbers and display the result
		tfResult.setText(String.format("%,.2f", number1 + number2));
	}	// end addNumbers
	
	private void subtractNumbers() {
		// Get values from text fields
		double number1 = Double.parseDouble(tfNumber1.getText());
		double number2 = Double.parseDouble(tfNumber2.getText());
		tfResult.setText(String.format("%,.2f", number1 - number2));
	}	// end subtractNumbers

	private void multiplyNumbers() {
		// Get values from text fields
		double number1 = Double.parseDouble(tfNumber1.getText());
		double number2 = Double.parseDouble(tfNumber2.getText());
		tfResult.setText(String.format("%,.2f", number1 * number2));
	}	// end multiplyNumbers

	private void divideNumbers() {
		// Get values from text fields
		double number1 = Double.parseDouble(tfNumber1.getText());
		double number2 = Double.parseDouble(tfNumber2.getText());
		tfResult.setText(String.format("%,.2f", number1 / number2));
	}	// end divideNumbers
}	// end Exercise15_4