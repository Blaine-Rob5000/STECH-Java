//STECH Java programming class
//Exercise 10-14
//created by Robin G. Blaine on 9/8/2017

/*
Design a class named MyDate . The class contains:
 * The data fields year , month , and day that represent a date. month is 0-based, i.e., 0 is for January.
 * A no-arg constructor that creates a MyDate object for the current date.
 * A constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.
 * A constructor that constructs a MyDate object with the specified year, month, and day.
 * Three getter methods for the data fields year , month , and day , respectively.
 * A method named setDate(long elapsedTime) that sets a new date for the object using the elapsed time.

Write a test program that creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L) ) and displays their year, month, and day.
  Hint: The first two constructors will extract the year, month, and day from the elapsed time. For example, if the elapsed time is 561555550000 milliseconds, the year is 1987 , the month is 9 , and the day is 18 .
*/


//imports
import java.util.Date;
import java.util.GregorianCalendar;


public class Exercise_10_14 {
		
	public static void main(String[] args) {		
		
		//set and display date1
		MyDate date1 = new MyDate();
		System.out.println(" * * * date1 * * *");
		System.out.println("   Year: " + date1.getYear());
		System.out.println("  Month: " + date1.getMonth());
		System.out.println("    Day: " + date1.getDay());
		
		
		System.out.println("");
		
		
		//set and display date2
		MyDate date2 = new MyDate(34355555133101L);
		System.out.println(" * * * date2 * * *");
		System.out.println("   Year: " + date2.getYear());
		System.out.println("  Month: " + date2.getMonth());
		System.out.println("    Day: " + date2.getDay());
				
	}	//end main
		
}	//end Exercise_10_14


//define MyDate class
class MyDate {
	
	//define class variables
	private int year;
	private int month;
	private int day;
	private GregorianCalendar date = new GregorianCalendar();
	
	
	//default constructor
	public MyDate() {
		this.date = new GregorianCalendar();
		this.year = date.get(GregorianCalendar.YEAR);
		this.month = date.get(GregorianCalendar.MONTH);
		this.day = date.get(GregorianCalendar.DATE);
	}	//end MyDate default constructor
	
	
	//constructor with specified elapsed time since midnight, Jan 1, 1970, in milliseconds
	public MyDate(long elapsedTime) {
		this.date.setTimeInMillis(elapsedTime);
		this.year = date.get(GregorianCalendar.YEAR);
		this.month = date.get(GregorianCalendar.MONTH);
		this.day = date.get(GregorianCalendar.DATE);		
	}	//end MyDate constructor with specified elapsed time
	
	
	//constructor with specified year, month, and day
	public MyDate(int year, int month, int day) {
		this.date = new GregorianCalendar(year, month, day);
		this.year = date.get(GregorianCalendar.YEAR);
		this.month = date.get(GregorianCalendar.MONTH);
		this.day = date.get(GregorianCalendar.DATE);
	}	//end MyDate constructor with specified year, month, and day
	
	
	//getter: year
	public int getYear() {
		return this.year;
	}	//end getYear
	
	
	//getter: month
	public int getMonth() {
		return this.month;
	}	//end getMonth
	
	
	//getter: day
	public int getDay() {
		return this.day;
	}	//end getDay
	
	
	//mutator: set new date using specified elapsed time
	public void setDate (long elapsedTime) {
		date.setTimeInMillis(elapsedTime);
		this.year = date.get(GregorianCalendar.YEAR);
		this.month = date.get(GregorianCalendar.MONTH);
		this.day = date.get(GregorianCalendar.DATE);
	}	//end setDate
	
}	//end MyDate class
