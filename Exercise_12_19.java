//STECH Java programming class
//Exercise 12-19
//created by Robin G. Blaine on 9/14/2017

/*
12.19 (Count words) Write a program that counts the number of words in President Abraham Lincoln’s Gettysburg address from http://cs.armstrong.edu/liang/data/Lincoln.txt.



Four score and seven years ago our fathers brought forth on this continent, a new nation, 
conceived in Liberty, and dedicated to the proposition that all men are created equal.

Now we are engaged in a great civil war, testing whether that nation, or any nation so 
conceived and dedicated, can long endure. We are met on a great battle-field of that war. 
We have come to dedicate a portion of that field, as a final resting place for those who here gave their 
lives that that nation might live. It is altogether fitting and proper that we should do this.

But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow -- this ground. 
The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. 
The world will little note, nor long remember what we say here, but it can never forget what they did here. 
It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus 
far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us -- that from these 
honored dead we take increased devotion to that cause for which they gave the last full measure of devotion -- that 
we here highly resolve that these dead shall not have died in vain -- that this nation, under God, shall have a new 
birth of freedom -- and that government of the people, by the people, for the people, shall not perish from the earth.



Refer to page 483 for an example in Listing 12.17

Remember that words are considered text that is separated by whitespace
*/

//imports
import java.util.*;
import java.net.*;
import java.nio.charset.*;


public class Exercise_12_19 {
	

	public static void main(String[] args) {
		
//		int lineNumber = 1;
				
		//create URL object
		try {
			java.net.URL url = new java.net.URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			int wordCount = 0;
			Scanner input = new Scanner(url.openStream());
			while (input.hasNext()) {
				String line = input.nextLine();
				wordCount += CountWords(line);
				
//				System.out.printf("line #%-2d", lineNumber);
//				System.out.printf(" has %2d", CountWords(line));
//				System.out.println(" words.");
//				lineNumber++;
				
			}	//end while
			System.out.println("");
			System.out.println("President Abraham Lincoln’s Gettysburg address contains " + wordCount + " words.");
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}	//end try
		
	}	//end main
	
	//method: count the words in a string
	public static int CountWords(String string) {
		int wordCounter = 0;
		int lastCharacter = string.length() - 1;
		boolean isWord = false;
		
		for (int x = 0; x < string.length(); x++) {
			if (Character.isLetter(string.charAt(x)) && x != lastCharacter)
				isWord = true;				//check for letter; set word flag to true if found
			else if (!Character.isLetter(string.charAt(x)) && isWord) {
				wordCounter++;
				isWord = false;				//check for non-letter (end of word) and advance word count if found
			}
			else if (Character.isLetter(string.charAt(x)) && x == lastCharacter)
				wordCounter++;				//ensure last word on line is counted
				//end if
		}	//end for
		
		return wordCounter;
	}	//end countWords
	
	
	
}	//end Exercise_12_19