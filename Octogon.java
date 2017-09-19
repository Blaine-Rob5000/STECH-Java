//STECH Java programming class
//Exercise 13-11
//Octogon subclass
//created by Robin G. Blaine on 9/19/2017


/*
13.11 (The Octagon class) Write a class named Octagon that extends GeometricObject and implements the Comparable and Cloneable interfaces. Assume that all eight sides of the octagon are of equal length. The area can be computed using the following formula:

area=(2+4/√2)U side U side

Draw the UML diagram that involves Octagon , GeometricObject , Comparable , and Cloneable . Write a test program that creates an Octagon object with side value 5 and displays its area and perimeter. Create a new object using the clone method and compare the two objects using the compareTo method.

Refer to pages 514-515 for an example of clone()
*/


public class Octogon extends GeometricObject2 implements Cloneable, Comparable<Octogon> {
	
	protected double side = 1.0;
	protected double area;
	
	//default constructor
	public Octogon() {
		super();
	}	//end default constructor
	
	//specified constructor
	public Octogon(String color, boolean filled, double side) {
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
		area = (2 + 4 / Math.sqrt(2.0)) * side * side * 100;
		area = (int)(area + .5);
		area /= 100;
		return area;
	}	//end getArea
	
	//get perimeter
	public double getPerimeter() {
		return side * 8;
	}	//end getPerimeter
	
	//create a clone of the Octogon
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			System.out.println("Clone failed! Error: " + ex);
			return null;
		}	//end try
	}	//end clone (override)
	
	//compareTo method
	@Override
	public int compareTo(Octogon o) {
		if (area > o.area)
			return 1;
		else if (area < o.area)
			return -1;
		else
			return 0;
	}	//end compareTo (override)
	
	//return string description (override)
	@Override
	public String toString() {
		return ("  Created on: " + dateCreated +
			  "\n       Color: " + color +
			  "\n      Filled: " + filled + 
			  "\n        Side: " + side +
			  "\n        Area: " + this.getArea() +
			  "\n   Perimeter: " + this.getPerimeter());
	}	//end toString (override)
	
}	//end Octogon subclass