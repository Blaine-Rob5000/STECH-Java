//STECH Java programming class
//Exercise 12-3
//created by Robin G. Blaine on 9/13/2017

/*

12.3 ( ArrayIndexOutOfBoundsException ) Write a program that meets the following requirements:

	* Creates an array with 100 randomly chosen integers.

	* Prompts the user to enter the index of the array, then displays the corresponding element value. If the specified index is out of bounds, display the message Out of Bounds.

*/

//imports
import java.util.*;


public class Exercise_12_3 {
	
	
	
	
	
	public static void main(String[] args) {
		
		//create Scanner
		Scanner input = new Scanner(System.in);
		
		//declare array
		int randomArray[] = new int[100];
		
		//populate array with random integers
		for (int count = 0; count < 100; count++)
			randomArray[count] = (int)(Math.random() * 100);
		
		//declare variables
		int elementIndex = 0;
		boolean keepGoing = false;
		
		
		//enter array index value
		do {
			try {
				System.out.print("Enter an integer from 0 to 99: ");
				elementIndex = input.nextInt();
				keepGoing = true;
			}
			catch (InputMismatchException ex) {
				System.out.println("Error! Integers only...");
				keepGoing = false;
			}
			finally {
				input.nextLine();
			}
		} while (!keepGoing);
		
		//reset flag
		keepGoing = false;
		
		//display the chosen element
		try {
			System.out.println("Element number " + elementIndex + "'s value is: " + randomArray[elementIndex]);
			keepGoing = true;
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds!");
			keepGoing = false;
		}
		
		
		
		
		
	}	//end main
	
	
	

}	//end Exercise_12_3