//STECH Java programming class
//Exercise 13-8
//created by Robin G. Blaine on 9/19/2017


/*

13.8 (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the list field.

*/


//imports
import java.util.*;


public class MyStack implements Cloneable {
	
	//declare array
	private ArrayList<Object> list = new ArrayList<>();
	
	//check to see if the stack is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}	//end isEmpty
	
	//check size of stack
	public int getSize() {
		return list.size();
	}	//end getSize
	
	//look at top object on stack
	public Object peek() {
		return list.get(getSize() - 1);
	}	//end peek
	
	//remove and return top object on stack
	public Object pop() {
		Object o = list.get(getSize() -1);
		list.remove(getSize() - 1);
		return o;
	}	//end pop
	
	//put a new object on top of stack
	public void push(Object o) {
		list.add(o);
	}	//end push
	
	//create a deep copy of list field
	@Override
	public Object clone() {
		try {
			//shallow copy
			MyStack stackClone = (MyStack)super.clone();
			//deep copy of list
			stackClone.list = (ArrayList)(list.clone());
			return stackClone;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}	//end try
	}	//end clone (override)
	
	//toString method (override)
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}	//end toString (override)
	
}	//end MyStack class




