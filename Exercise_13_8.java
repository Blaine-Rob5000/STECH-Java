//STECH Java programming class
//Exercise 13-8
//created by Robin G. Blaine on 9/19/2017


/*

13.8 (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the list field.

*/


//imports
import java.util.*;


public class Exercise_13_8 {
	
	public static void main(String[] args) {
		
		MyStack testStack = new MyStack();
		
		System.out.println("testStack is empty: " + testStack.isEmpty());
		System.out.println("\nPopulating testStack...");
		
		for (int count = 0; count < 10; count++) {
			int randomNumber = (int)(Math.random()*100)+1;
			testStack.push(randomNumber);
			System.out.printf("  added: %3d", randomNumber);
			System.out.println("");
		}
		
		System.out.println("\ntestStack is empty: " + testStack.isEmpty());
		
		System.out.println("\nCreating shallowCopy of testStack...");
		MyStack shallowCopy = testStack;
		System.out.println("  shallowCopy = testStack: " + (shallowCopy == testStack));
		
		
		System.out.println("\nCreating deepCopy of testStack...");
		MyStack deepCopy = (MyStack)testStack.clone();
		System.out.println("     deepCopy = testStack: " + (deepCopy == testStack));
		
		System.out.println("\nEmptying testStack and deepCopy...");
		
		for (int count = 0; count < 10; count++) {
			Object stackValue = testStack.pop();
			System.out.printf("  removed: %3d", stackValue);
			stackValue = deepCopy.pop();
			System.out.printf("          removed: %3d", stackValue);
			System.out.println("");
		}
		
		System.out.println("\ntestStack is empty: " + testStack.isEmpty());
		System.out.println(" deepCopy is empty: " + deepCopy.isEmpty());

				
	}	//end main
	
	
	
	
	
}	//end Exercise_13_8




