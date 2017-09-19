//STECH Java programming class
//Exercise 13-11
//Comparable interface
//created by Robin G. Blaine on 9/19/2017


/*
13.11 (The Octagon class) Write a class named Octagon that extends GeometricObject and implements the Comparable and Cloneable interfaces. Assume that all eight sides of the octagon are of equal length. The area can be computed using the following formula:

area=(2+4/√2)U side U side

Draw the UML diagram that involves Octagon , GeometricObject , Comparable , and Cloneable . Write a test program that creates an Octagon object with side value 5 and displays its area and perimeter. Create a new object using the clone method and compare the two objects using the compareTo method.

Refer to pages 514-515 for an example of clone()
*/


public interface Comparable<GeometricObject2> {
	
	public int compareTo(GeometricObject2 o);
	
}	//end Comparable interface