//STECH Java programming class
//Exercise 13-7
//created by Robin G. Blaine on 9/18/2017


/*
13.7 (The Colorable interface) Design an interface named Colorable with a void method named howToColor() . Every class of a colorable object must implement the Colorableinterface. Design a class named Square that extends GeometricObject and implements Colorable . Implement howToColor to display the message Color all four sides .
Draw a UML diagram that involves Colorable , Square , and GeometricObject . Write a test program that creates an array of five GeometricObject s. For each object in the array, display its area and invoke its howToColor method if it is colorable.
*/


//imports
import java.util.*;


public class Exercise_13_7 {
	
	
	
	
	
	public static void main(String[] args) {
		
		//create array of geometric objects
		ArrayList<GeometricObject> testObject = new ArrayList<GeometricObject>();
		
		//declare variables
		String color;
		boolean filled;
		double side;
		double randomNumber;
		
		//populate array
		for (int count = 0; count < 5; count++) {
			
			//generate random color
			randomNumber = (int)(Math.random() * 7);
			if (randomNumber == 0)
				color = "Red";
			else if (randomNumber == 1)
				color = "Orange";
			else if (randomNumber == 2)
				color = "Yellow";			
			else if (randomNumber == 3)
				color = "Green";
			else if (randomNumber == 4)
				color = "Blue";	
			else if (randomNumber == 5)
				color = "Indigo";
			else
				color = "Violet";		
			
			//generate random filled
			randomNumber = (int)(Math.random() * 2);
			if (randomNumber == 0)
				filled = false;
			else
				filled = true;
			
			//generate random side from .1 to 10
			side = (int)(Math.random() * 100) + 1;
			side /= 10;
			
			//add a square with the randomly generated properties to the array list
			testObject.add(new Square(color, filled, side));
						
			//display the testObject's string
			System.out.println("\nSquare #" + count + "\n" + testObject.get(count).toString());
			System.out.print("How to Color: ");
			testObject.get(count).howToColor();
			System.out.println("");
			
		}	//end for
		
		
		
	}	//end main
	
	
	
	
	
}	//end Exercise_13_7