// STECH Java Programming Class
// Excercise16_4.java
// created/modified by Robin G. Blaine on 10/5/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	16.4 (Create a miles/kilometers converter) Write a program that converts miles and kilometers, as shown in Figure  16.37b. If you enter a value in the Mile text field and press the Enter key, the corresponding kilometer measurement is displayed in the Kilometer text field. Likewise, if you enter a value in the Kilometer text field and press the Enter key, the corresponding miles is displayed in the Mile text field.
			
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class Exercise16_21 extends Application {
	// declare variables
	private int startTime;
	
	@Override
	public void start(Stage primaryStage) {
		Media music = new Media("http://cs.armstrong.edu/liang/common/audio/anthem/anthem6.mp3");
		MediaPlayer mp = new MediaPlayer(music);
					
		Pane pane = new Pane();
		
		TextField tfCountdown = new TextField();
		tfCountdown.setAlignment(Pos.CENTER);
		
		pane.getChildren().add(tfCountdown);
		
		EventHandler<ActionEvent> updateCountdown = e -> {
			if (Integer.parseInt(tfCountdown.getText()) > 0) {
				tfCountdown.setText(String.valueOf(Integer.parseInt(tfCountdown.getText()) - 1));
			}
			else {
				System.out.println("Playing music");
				mp.setCycleCount(MediaPlayer.INDEFINITE);
				mp.play();
			}
		};
		
		tfCountdown.setOnAction(e -> {
			if (isInteger(tfCountdown.getText())) {
				startTime = Integer.parseInt(tfCountdown.getText());
				if (startTime >= 1) {
					tfCountdown.setEditable(false);
					Timeline countdown = new Timeline(new KeyFrame(Duration.millis(1000), updateCountdown));
					countdown.setCycleCount(startTime + 1);
					countdown.play();
				}
				else {
					tfCountdown.setText("");
				}	// end if
			}
			else {
				tfCountdown.setText("");
			}
		});
				
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 60);
		primaryStage.setTitle("Exercise16_21");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	// end start

	
	public boolean isInteger(String text) {
		for (int index = 0; index < text.length(); index++) {
			if (!Character.isDigit(text.charAt(index))) {
				return false;		// if any character is a non-digit, return false
			} // end if
		}	// end for
		return true;				// else return true
	}	// end isInteger
	
	
	public static void main(String[] args) {
		launch(args);
	}	// end main
	
}	// end Exercise16_21
