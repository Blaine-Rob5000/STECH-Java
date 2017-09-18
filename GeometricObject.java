//STECH Java programming class
//Exercise 13-7:  GeometricObject (abstract superclass)
//created by Robin G. Blaine on 9/18/2017


/*

13.7 (The Colorable interface) Design an interface named Colorable with a void method named howToColor() . Every class of a colorable object must implement the Colorableinterface. Design a class named Square that extends GeometricObject and implements Colorable . Implement howToColor to display the message Color all four sides .

Draw a UML diagram that involves Colorable , Square , and GeometricObject . Write a test program that creates an array of five GeometricObject s. For each object in the array, display its area and invoke its howToColor method if it is colorable.

*/



public abstract class GeometricObject {
	
	protected String color = "white";
	protected boolean filled = false;
	protected java.util.Date dateCreated;
	
	//default constructor
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}	//end default constructor
	
	//specified constructor (color, filled)
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}	//end specified constructor
	
	//return color
	public String getColor() {
		return color;
	}	//end getColor
	
	//set new color
	public void setColor(String color) {
		this.color = color;
	}	//end setColor
	
	//return filled
	public boolean isFilled() {
		return filled;
	}	//end isFilled
	
	//set new filled
	public void setFilled(boolean filled) {
		this.filled = filled;
	}	//end setFilled
	
	//return date created
	public java.util.Date getDateCreated() {
		return dateCreated;
	}	//end getDateCreated
	
	//return a string description
	@Override
	public String toString() {
		return ("Created on: " + dateCreated +
				"\n     Color: " + color +
				"\n    Filled: " + filled);
	}	//end toString (override)
	
	//getArea (abstract)
	public abstract double getArea();
	
	//getPerimeter (abstract)
	public abstract double getPerimeter();
	
}	//end GeometricObject superclass