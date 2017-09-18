//STECH Java programming class
//Exercise 13-7: Square (concrete subclass, extends GeometricObject)
//created by Robin G. Blaine on 9/18/2017


/*

13.7 (The Colorable interface) Design an interface named Colorable with a void method named howToColor() . Every class of a colorable object must implement the Colorableinterface. Design a class named Square that extends GeometricObject and implements Colorable . Implement howToColor to display the message Color all four sides .

Draw a UML diagram that involves Colorable , Square , and GeometricObject . Write a test program that creates an array of five GeometricObject s. For each object in the array, display its area and invoke its howToColor method if it is colorable.

*/


public class Square extends GeometricObject {
	
	protected double side = 1.0;
	protected double area;
	
	//default constructor
	public Square() {
		super();
	}	//end default constructor
	
	//specified constructor
	public Square(String color, boolean filled, double side) {
		super(color, filled);
		this.side = side;
	}	//end specified constructor
	
	//get side
	public double getSide() {
		return this.side;
	}	//end getSide	
	
	//set new side
	public void setSide(double side) {
		this.side = side;
	}	//end setSide
	
	//get area
	public double getArea() {
		area = side * side * 100;
		area = (int)(area + .5);
		area /= 100;
		return area;
	}	//end getArea
	
	//get perimeter
	public double getPerimeter() {
		return side*4;
	}	//end getPerimeter
	
	//return howToColor
	public String howToColor() {
		return "Color all four sides.";
	}
	
	//return string description (override)
	@Override
	public String toString() {
		return ("  Created on: " + dateCreated +
				"\n       Color: " + color +
				"\n      Filled: " + filled + 
				"\n        Side: " + side +
				"\n        Area: " + this.getArea() +
				"\n   Perimeter: " + this.getPerimeter() +
				"\nHow to Color: " + this.howToColor());
	}	//end toString (override)
	
}	//end Square subclass