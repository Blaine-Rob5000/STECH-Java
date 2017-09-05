//STECH Java programming class
//Exercise 9-8
//created by Robin G. Blaine on 9/5/2017
//design the Fan class containing:
//	* constants: SLOW = 1; MEDIUM = 2; FAST = 3;
//	* private int data field:     speed  (default is SLOW)
//	* private boolean data field: on     (default is false)
//	* private double data field:  radius (default is 5)
//  * string data field:          color  (default is blue)
//
//  * accessor and mutator methods for all four data field
//  * no-arg constructor that creates a default fan
//  * method: toString() that returns a string description for the fan
//                if the fan is on, returns speed, color, and radius as a combined string
//                if the fan is off, returns the color and radius plus "fan is off" as a combined string
//
//Draw the UML diagram for the class then implement it.
//Write a test program to create two fan objects with
//    fan1: max speed, radius 5, color yellow, turned on
//    fan2: medium speed, radius 5, color blue, turned off
//
//Display the objects by invoking the toString method

public class Fan {
	
	//main method
	
	public static void main(String[] args) {
		
		//create a Stock: ORCL, Oracle, 34.5, 34.35
		Fan fan1 = new Fan(FAST, true, 10, "yellow");
		Fan fan2 = new Fan();
		fan2.setSpeed(MEDIUM);
		
		System.out.println("Fan number 1: " + fan1.toString());
		System.out.println("");
		System.out.println("Fan number 2: " + fan2.toString());
		
	}	//end main
	
	//constants
	final static int SLOW   = 1;
	final static int MEDIUM = 2;
	final static int FAST   = 3;
	
	//variables
	private int     speed  = SLOW;
	private boolean on     = false;
	private double  radius = 5;
	        String  color  = "blue";
	
	//get fan speed
	int getSpeed() {
		return speed;
	}	//end getSpeed
	
	
	//determine if fan is on
	boolean isOn() {
		return on;
	}	//end isOn
	
	//get fan radius
	double getRadius() {
		return radius;
	}	//end getRadius
	
	//get fan color
	String getColor() {
		return color;
	}	//end getColor
	
	//turn on fan
	void turnOn() {
		on = true;
	}	//end turnOn
	
	//turn off fan
	void turnOff() {
		on = false;
	}	//end turnOff
	
	//set new speed for fan
	void setSpeed(int newSpeed) {
		speed = newSpeed;
	}	//end setSpeed
	
	//set new radius for fan
	void setRadius(double newRadius) {
		radius = newRadius;
	}	//end setRadius
	
	//set new color for fan
	void setColor (String newColor) {
		color = newColor;
	}	//end setColor
	
	//construct a default fan
	Fan() {
		speed  = SLOW;
		on     = false;
		radius = 5;
		color  = "blue";
	}	//end Fan
	
	//construct a fan with specified attributes
	Fan (int newSpeed, boolean newOn, double newRadius, String newColor) {
		speed  = newSpeed;
		on     = newOn;
		radius = newRadius;
		color  = newColor;
		
	}	//end Fan
	
	//return a string description
	public String toString() {
		//variables
		String fanStatus = "";
		
		//construct fanStatus string
		if (on)
			fanStatus = "Speed: " + speed + ", Color: " + color + ", Radius: " + radius;
		else
			fanStatus = "Color: " + color + ", Radius: " + radius + ", fan is off.";
		
		return fanStatus;
	}	//end toString
	
}	//end Fan