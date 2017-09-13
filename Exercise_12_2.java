//STECH Java programming class
//Exercise 12-2
//created by Robin G. Blaine on 9/13/2017

/*

( InputMismatchException ) Write a program that prompts the user to enter two integers and displays their sum. Your program should prompt the user to read the number again if the input is incorrect.

*/

//imports
import java.util.Scanner;
import java.util.*;


public class Exercise_12_2 {
	
	
	
	
	
	public static void main(String[] args) {
		
		//create Scanner
		Scanner input = new Scanner(System.in);
		
		//declare variables
		int number1 = 0;
		int number2 = 0;
		boolean keepGoing = false;
		
		//enter integer number1
		do {
			try {
				System.out.print("Enter the first integer: ");
				number1 = input.nextInt();
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
		
		keepGoing = false;
		//enter integer number2
		do {
			try {
				System.out.print("Enter the second integer: ");
				number2 = input.nextInt();
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
		
		System.out.println("The sum of " + number1 + " + " + number2 + " = " + (number1 + number2));
		
	}	//end main
	
	
	
	
	
}	//end Exercise_12_2




