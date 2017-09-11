//STECH Java programming class
//Exercise 11-2
//created by Robin G. Blaine on 9/11/2017

/*

(The Person , Student , Employee , Faculty , and Staff classes) Design a class named Person and its two subclasses named Student and Employee . Make Faculty and Staff subclasses of Employee .
		A person has a name, address, phone number, and email address.
		A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant.
		An employee has an office, salary, and date hired. Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired.
		A faculty member has office hours and a rank.
		A staff member has a title.
		
		Override the toString method in each class to display the class name and the person’s name.

Write a test program that creates a Person , Student , Employee , Faculty , and Staff , and invokes their toString()methods.

*/


//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;


public class Exercise_10_7 {
	
	public static void main(String[] args) {
		
		//create Scanner
		Scanner input = new Scanner(System.in);		
		
		
		
		
		
		
		
	}	//end main

}	//end Exercise_10_7


//define superclass Person
public class Person {
	
	//define variables
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	
	//default constructor
	public Person() {
		this.name = "";
		this.address = "";
		this.phoneNumber = "";
		this.emailAddress = "";
	}	//end Person default constructor
	
	//specified constructor
	public Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}	//end Person specified constructor
	
	//getter: name
	public String getName() {
		return this.name;
	}	//end getName
	
	//getter: address
	public String getAddress() {
		return this.address;
	}	//end getAddress
	
	//getter: phoneNumber
	public String getPhoneNumber() {
		return this.phoneNumber;
	}	//end getPhoneNumber
	
	//getter: emailAddress
	public String getEmailAddress() {
		return this.emailAddress;
	}	//end getEmailAddress
	
	//mutator: name
	public void setName(String name) {
		this.name = name;
	}	//end setName
	
	//mutator: address
	public void setAddress(String address) {
		this.address = address;
	}	//end setAddress
	
	//mutator phoneNumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	//end setPhoneNumber
	
	//mutator emailAddress
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}	//end setEmailAddress
	
	//convert to String
	@Override
	public String toString() {
		return ("Name: " + this.name + "\n" +
				"Address: " + this.address + "\n" +
				"Phone Number: " + this.phoneNumber + "\n" +
				"Email Address: " + this.emailAddress);
	}	//end toString Override
	
}	//end superclass Person


//define subclass Student
public class Student
	extends Person {
	
	//define variables
	private constant String CLASS_STATUS;
	
	//default constructor
	Student() {
		this = Person();
		this.CLASS_STATUS = "";
	}	//end Student default constructor
	
	//specified constructor
	Student(String name, String address, String phoneNumber, String emailAddress, String CLASS_STATUS) {
		this = Person(name, address, phoneNumber, emailAddress);
		this.CLASS_STATUS = CLASS_STATUS;
	}	//end Student specified constructor
	
	//getter: CLASS_STATUS
	public String getClassStatus() {
		return this.CLASS_STATUS;
	}	//end getClassStatus
	
	//mutator: CLASS_STATUS
	public void setClassStatus(String CLASS_STATUS) {
		this.CLASS_STATUS = CLASS_STATUS;
	}	//end setClassStatus
	
	//convert to String
	@Override
	public String toString() {
		return ("Name: " + this.name + "\n" +
				"Address: " + this.address + "\n" +
				"Phone Number: " + this.phoneNumber + "\n" +
				"Email Address: " + this.emailAddress + "\n" +
				"Class Status: " + this.CLASS_STATUS);
	}	//end toString Override

}	//end subclass Student => Person


//define subclass Employee
public Class Employee
	extends Person {
	
	//define variables
	private String office;
	private double salary;
	private MyDate dateHired = new MyDate();
	
	//default constructor
	Employee() {
		this = Person();
		this.office = "";
		this.salary = 0.00;
		this.dateHired = new MyDate();
	}	//end Employee default constructor
	
	//specified constructor
	Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired) {
		this = Person(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = new MyDate(dateHired);
	}	//end Employee specified constructor
	
	//getter: office
	public String getOffice() {
		return this.office;
	}	//end getOffice
	
	//getter: salary
	public double getSalary() {
		return this.salary;
	}
	
	//getter: dateHired
	public MyDate getDateHired() {
		return this.dateHired;
	}
	
	//mutator: office
	public void setOffice(String office) {
		this.office = office;
	}	//end setOffice
	
	//mutator: salary
	public void setSalary(double salary) {
		this.salary = salary;
	}	//end setSalary
	
	//mutator: dateHired
	public void setDateHired(MyDate dateHired) {
		this.dateHired = new MyDate(dateHired);
	}	//end setDateHired
	
	//convert to String
	@Override
	public String toString() {
		return ("Name: " + this.name + "\n" +
				"Address: " + this.address + "\n" +
				"Phone Number: " + this.phoneNumber + "\n" +
				"Email Address: " + this.emailAddress + "\n" +
				"Office: " + this.office + "\n" +
				"Salary: " + this.salary + "\n" +
				"Date Hired: " + this.dateHired);
	}	//end toString Override
	
}	//end subclass Employee => Person


//define subclass Faculty
public Class Faculty
	extends Employee {
	
	//define variables
	private String officeHours;
	private String rank;
		
	//default constructor
	Faculty() {
		this = Employee();
		this.officeHours = "";
		this.rank = "";
	}	//end Faculty default constructor
	
	//specified constructor
	Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String officeHours, String rank) {
		this = Employee(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}	//end Faculty specified constructor
	
	//getter: officeHours
	public String getOfficeHours() {
		return this.officeHours;
	}	//end getOfficeHours
	
	//getter: rank
	public String getRank() {
		return this.rank;
	}
		
	//mutator: officeHours
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}	//end setOfficeHours
	
	//mutator: rank
	public void setRank(String rank) {
		this.rank = rank;
	}	//end setRank
		
	//convert to String
	@Override
	public String toString() {
		return ("Name: " + this.name + "\n" +
				"Address: " + this.address + "\n" +
				"Phone Number: " + this.phoneNumber + "\n" +
				"Email Address: " + this.emailAddress + "\n" +
				"Office: " + this.office + "\n" +
				"Salary: " + this.salary + "\n" +
				"Date Hired: " + this.dateHired + "\n" +
				"Office Hours: " + this.officeHours + "\n" +
				"Rank: " + this.rank);
	}	//end toString Override
	
}	//end subsubclass Faculty => Employee => Person


//define subclass Staff
public Class Staff
	extends Employee {
	
	//define variables
	private String title;
		
	//default constructor
	Staff() {
		this = Employee();
		this.title = "";
	}	//end Staff default constructor
	
	//specified constructor
	Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title) {
		this = Employee(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.title = title;
	}	//end Staff specified constructor
	
	//getter: title
	public String getTitle() {
		return this.title;
	}	//end getTitle
			
	//mutator: title
	public void setTitle(String title) {
		this.title = title;
	}	//end setTitle
			
	//convert to String
	@Override
	public String toString() {
		return ("Name: " + this.name + "\n" +
				"Address: " + this.address + "\n" +
				"Phone Number: " + this.phoneNumber + "\n" +
				"Email Address: " + this.emailAddress + "\n" +
				"Office: " + this.office + "\n" +
				"Salary: " + this.salary + "\n" +
				"Date Hired: " + this.dateHired + "\n" +
				"Title: " + this.title);
	}	//end toString Override
	
}	//end subsubclass Staff => Employee => Person


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