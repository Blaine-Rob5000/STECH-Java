//STECH Java programming class
//Exercise 13-11
//main method
//created by Robin G. Blaine on 9/19/2017


/*
13.11 (The Octagon class) Write a class named Octagon that extends GeometricObject and implements the Comparable and Cloneable interfaces. Assume that all eight sides of the octagon are of equal length. The area can be computed using the following formula:

area=(2+4/√2)U side U side
Draw the UML diagram that involves Octagon , GeometricObject , Comparable , and Cloneable . Write a test program that creates an Octagon object with side value 5 and displays its area and perimeter. Create a new object using the clone method and compare the two objects using the compareTo method.

Refer to pages 514-515 for an example of clone()
*/


//imports
import java.util.*;


public class Exercise_13_11 {
	
	public static void main(String[] args) {
				
		//create octogon1
		Octogon octogon1 = new Octogon("blue", true, 5.0);
		
		//display properties of octogon1
		System.out.println("octogon1");
		System.out.println(octogon1.toString());
		System.out.println("");
		
		//create octogon2
		System.out.println("Cloning octogon1...");
		Octogon octogon2 = new Octogon();
		octogon2 = (Octogon)octogon1.clone();
		System.out.println("");
		
		//display properties of octogon2
		System.out.println("octogon2");
		System.out.println(octogon2.toString());
		System.out.println("");
		
		//compare the two objects
		System.out.print("octogon1's area is ");
		if (octogon1.compareTo(octogon2) == 1)
			System.out.println("greater than octogon2's area.");
		else if (octogon1.compareTo(octogon2) == -1)
			System.out.println("less than octogon2's area.");
		else
			System.out.println("equal to octogon2's area.");
		
	}	//end main
	
}	//end Exercise_13_11
