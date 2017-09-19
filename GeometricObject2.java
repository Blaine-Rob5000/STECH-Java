//STECH Java programming class
//Exercise 13-11
//GeometricObject superclass
//created by Robin G. Blaine on 9/19/2017


/*
13.11 (The Octagon class) Write a class named Octagon that extends GeometricObject and implements the Comparable and Cloneable interfaces. Assume that all eight sides of the octagon are of equal length. The area can be computed using the following formula:

area=(2+4/√2)U side U side

Draw the UML diagram that involves Octagon , GeometricObject , Comparable , and Cloneable . Write a test program that creates an Octagon object with side value 5 and displays its area and perimeter. Create a new object using the clone method and compare the two objects using the compareTo method.

Refer to pages 514-515 for an example of clone()
*/


public abstract class GeometricObject2 {
	
	protected String color = "white";
	protected boolean filled = false;
	protected java.util.Date dateCreated;
	
	//default constructor
	public GeometricObject2() {
		dateCreated = new java.util.Date();
	}	//end default constructor
	
	//specified constructor (color, filled)
	public GeometricObject2(String color, boolean filled) {
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
		
}	//end GeometricObject2 superclass
