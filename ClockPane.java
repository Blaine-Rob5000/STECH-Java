//STECH Java Programming Class
//Exercise14_28: ClockPane class
//created by Robin G. Blaine on 9/26/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

14.28 (Random time) Modify the ClockPane class with three new Boolean properties— hourHandVisible , minuteHandVisible , and secondHandVisible —and their associated accessor and mutator methods. You can use the set methods to make a hand visible or invisible. Write a test program that displays only the hour and minute hands. The hour and minute values are randomly generated. The hour is between 0 and 11 , and the minute is either 0 or 30 , as shown in Figure  14.52b.

 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// java.util imports
import java.util.Calendar;
import java.util.GregorianCalendar;

// javafx imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ClockPane extends Pane {
	// declare variables
	private int hour;
	private int minute;
	private int second;
	private boolean hourHandVisible   = true;
	private boolean minuteHandVisible = true;
	private boolean secondHandVisible = true;
	
	// Clock pane's width and height
	private double w = 250, h = 250;
	
	// Construct a default clock with the current time
	public ClockPane() {
		setCurrentTime();
	}	// end default constructor
	
	// Construct a clock with a specified hour, minute, and second
	public ClockPane(int hour, int minute, int second) {
		this.hour   = hour;
		this.minute = minute;
		this.second = second;
		paintClock();	// Repaint the clock
	}	// end specified constructor
	
	// Return the hour
	public int getHour() {
		return hour;
	}	// end getHour
	
	// Set a new hour
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();	// Repaint the clock
	}	// end setHour
	
	// Return the minute
	public int getMinute() {
		return minute;
	}	// end getMinute
	
	// Set a new minute
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();	// Repaint the clock
	}	// end setMinute
	
	// Return the second
	public int getSecond() {
		return second;
	}	// end getSecond
	
	// Set a new second
	public void setSecond(int second) {
		this.second = second;
		paintClock();	// Repaint the clock
	}	// end setSecond
	
	// Return the clock pane's width
	public double getW() {
		return w;
	}	// end getW
	
	// Set a new width for the clock pane
	public void setW(double w) {
		this.w = w;
		paintClock();	// Repaint the clock
	}	// end setW
	
	// Return the clock pane's height
	public double getH() {
		return h;
	}	// end getH
	
	// Set a new height for the clock pane
	public void setH(double h) {
		this.h = h;
		paintClock();	// Repaint the clock
	}	// end setH
	
	// Set the current time for the clock
	public void setCurrentTime() {
		// Construc a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
		
		// Set the current hour, minute, and second
		this.hour   = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		paintClock();	// Repaint the clock
	}	// end setCurrentTime
	
	// Return true if hour hand is visible, false if it is not
	public boolean isHourVisible() {
		return hourHandVisible;
	}	// end isHourVisible
	
	// Set visibility for hour hand
	public void setHourVisible(boolean hourHandVisible) {
		this.hourHandVisible = hourHandVisible;
		paintClock();	// Repaint the clock
	}	// end setHourVisible
	
	// Return true if minute hand is visible, false if it is not
	public boolean isMinuteVisible() {
		return minuteHandVisible;
	}	// end isMinuteVisible
	
	// Set visibility for minute hand
	public void setMinuteVisible(boolean minuteHandVisible) {
		this.minuteHandVisible = minuteHandVisible;
		paintClock();	// Repaint the clock
	}	// end setMinuteVisible
	
	// Return true if second hand is visible, false if it is not
	public boolean isSecondVisible() {
		return secondHandVisible;
	}	// end isSecondVisible
	
	// Set visibility for second hand
	public void setSecondVisible(boolean secondHandVisible) {
		this.secondHandVisible = secondHandVisible;
		paintClock();	// Repaint the clock
	}	// end setSecondVisible
	
	// Paint the clock
	protected void paintClock() {
		// Initialize the clock parameters
		double clockRadius = Math.min(w, h) * .8 * .5;
		double centerX = w / 2;
		double centerY = h / 2;
		
		// Draw a circle for the clock face
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5,                centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3,  centerY + 5,                 "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3,                 "3");
		Text t4 = new Text(centerX - 3,                centerY + clockRadius - 3,   "6");
		
		// Display digital time readout at the bottom center
		String hourString = "" + hour;
		if (hour < 10)
			hourString = "0" + hourString;
			// end if
		String minuteString = "" + minute;
		if (minute < 10)
			minuteString = "0" + minuteString;
			// end if
		String secondString = "" + second;
		if (second < 10)
			secondString = "0" + secondString;
			//end if
		String digitalTime = hourString + ":" + minuteString + ":" + secondString;
		Text t5 = new Text(centerX - 23,  h - 5, digitalTime);
		
		// Draw the second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		if (!secondHandVisible) {
			sLine.setStartX(0);
			sLine.setStartY(0);
			sLine.setEndX(0);
			sLine.setEndY(0);
			sLine.setStroke(Color.WHITE);
		}	// end if
		
		// Draw the minute hand
		double mLength = clockRadius * 0.65;
		double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
		mLine.setStroke(Color.BLUE);
		if (!minuteHandVisible) {
			mLine.setStartX(0);
			mLine.setStartY(0);
			mLine.setEndX(0);
			mLine.setEndY(0);
			mLine.setStroke(Color.WHITE);
		}	// end if
		
		// Draw the hour hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		if (!hourHandVisible) {
			hLine.setStartX(0);
			hLine.setStartY(0);
			hLine.setEndX(0);
			hLine.setEndY(0);
			hLine.setStroke(Color.WHITE);
		}	// end if
		
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4, t5, sLine, mLine, hLine);
	}	// end paintClock
}	// end ClockPane class


