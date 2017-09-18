//STECH Java programming class
//Exercise 13-7:  Colorable (interface)
//created by Robin G. Blaine on 9/18/2017


/*

13.7 (The Colorable interface) Design an interface named Colorable with a void method named howToColor() . Every class of a colorable object must implement the Colorableinterface. Design a class named Square that extends GeometricObject and implements Colorable . Implement howToColor to display the message Color all four sides .

Draw a UML diagram that involves Colorable , Square , and GeometricObject . Write a test program that creates an array of five GeometricObject s. For each object in the array, display its area and invoke its howToColor method if it is colorable.

*/



public interface Colorable {
	
	public String howToColor ();
	
}	//end Colorable interface