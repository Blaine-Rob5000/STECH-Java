// STECH Java programming class
// TicTacToe
// from textbook Introduction to Java Programming, Brief Version, 10th edition
// input/modified by Robin G. Blaine

// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;


public class TicTacToe extends Application {
	
	// Indicate whose turn it is
	private char whoseTurn = 'X';
	
	// Create and intialize cell
	private Cell[][] cell = new Cell[3][3];
	
	// Create and initialize status label
	private Label lblStatus = new Label("X's turn to play");
	
	@Override
	public void start(Stage primaryStage) {
		// Pane to hold cells
		GridPane pane = new GridPane();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pane.add(cell[i][j] = new Cell(), i, j);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 450, 170);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	// end start
	
	// Determine if the cells are all occupied
	public boolean isFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (cell[i][j].getToken() == ' ')
					return false;	// if any cell is empty, return false
					
		return true;				// otherwise, return true
	}	// end isFull
	
	// Determine if the player with the specified token has won
	public boolean isWon(char token) {
		// Check rows
		for (int i = 0; i < 3; i++)
			if (cell[i][0].getToken() == token
					&& cell[i][1].getToken() == token
					&& cell[i][2].getToken() == token) {
				return true;		// if any row is filled with the current player's token, return true
			}	// end for (Check rows)
		
		// Check columns
		for (int j = 0; j < 3; j++)
			if (cell[0][j].getToken() == token
					&& cell[1][j].getToken() == token
					&& cell[2][j].getToken() == token) {
				return true;		// if any column is filled with the current player's token, return true
			}	// end for (Check columns)
		
		// Check top left to bottom right diagonal
		if (cell[0][0].getToken() == token
				&& cell[1][1].getToken() == token
				&& cell[2][2].getToken() == token) {
			return true;		// diagonal is filled with the current player's token, return true
		}	// end for (Check top left to bottom right diagonal)
		
		// Check top right to bottom left diagonal
		if (cell[0][2].getToken() == token
				&& cell[1][1].getToken() == token
				&& cell[2][0].getToken() == token) {
			return true;		// diagonal is filled with the current player's token, return true
		}	// end for (Check top right to bottom left diagonal)
		
		return false;			// otherwise, return false		
	}	// end isWon
	
	// Inner class for a cell
	public class Cell extends Pane {
		// Token used for this cell
		private char token = ' ';
		
		// Default constructor
		public Cell () {
			setStyle("-fx-border-color: black");
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}	// end Cell default constructor
		
		// Return token
		public char getToken() {
			return token;
		}	// end getToken
		
		// Set a new token
		public void setToken(char c) {
			char token = c;
			
			// Draw an X or an O
			if (token == 'X') {
				Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
				
				this.getChildren().addAll(line1, line2);
			}	// end Draw an X
			else if (token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2,
					this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				
				getChildren().add(ellipse);
			}	// end Draw an O
		}	// end setToken
	}	// end inner class Cell
	
	// Handel a mouse click event
	private void handleMouseClick() {
		// If the cell is empty and game is not over
		if (token == ' ' && whoseTurn != ' ') {
			setToken(whoseTurn);
			
			// Check game status
			if (isWon(whoseTurn)) {
				lblStatus.setText(whoseTurn + " won!  The game is over");
				whoseTurn = ' ';
			}
			else if (isFull()) {
				lblStatus.setText("Draw!  The game is over");
				whoseTurn = ' ';
			}
			else {
				// Change the turn
				whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
				// Display whose turn
				lblStatus.setText(whoseTurn + "'s turn");
			}	// end if
		}	// end if
	}	// end handleMouseClick
	
	// main method
	public static void main(String[] args) {
		launch(args);
	}	// end main
}	// end TicTacToe



