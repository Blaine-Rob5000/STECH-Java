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
import java.util.GregorianCalendar;


public class Exercise_11_2 {
	
	public static void main(String[] args) {
		
		//create a Person and display toString() method
		Person person = new Person("William Hartnell",
			"221-B Baker St, London, England 12345",
			"(555) 123-4567",
			"whoson1st@gmail.com");
		System.out.println("Person demo:");
		System.out.println(person.toString());
		System.out.println("");
		
		
		//create a Student and display toString() method
		Student student = new Student("Patrick Troughton",
			"667 Big Ben Plaza, London, England 23456",
			"(555) 234-5678",
			"twice_as_nice@yahoo.com",
			"sophomore");
		System.out.println("Student demo:");
		System.out.println(student.toString());
		System.out.println("");
		
		
		//create an Employee and display toString() method
		MyDate employeeHired = new MyDate(1970, 8, 1);
		Employee employee = new Employee("Jon Pertwee",
			"667 N Beast Ln, London, England 34567",
			"(555) 345-6789",
			"third_times_the_charm@aol.com",
			"SB 101",
			77777.77,
			employeeHired);
		System.out.println("Employee demo:");
		System.out.println(employee.toString());
		System.out.println("");		
		
		
		//create a Faculty and display toString() method
		MyDate facultyHired = new MyDate(1975, 3, 3);
		Faculty faculty = new Faculty("Tom Baker",
			"9001 Tardis Way, London, England 45678",
			"(555) 456-7890",
			"the_best_doctor@earthlink.net",
			"QM 299",
			157677.67,
			facultyHired,
			"11:00 AM to 1:00 PM, MWF",
			"Master");
		System.out.println("Faculty demo:");
		System.out.println(faculty.toString());
		System.out.println("");		
		
		
		//create a Staff and display toString() method
		MyDate staffHired = new MyDate(1980, 10, 10);
		Staff staff = new Staff("Peter Davidson",
			"1313 Celery Circle, London, England 56789",
			"(555) 567-8901",
			"i_tried_my_best@jerk.com",
			"Toilet Stall no. 72",
			1.51,
			staffHired,
			"Custodian");
		System.out.println("Staff demo:");
		System.out.println(staff.toString());
		System.out.println("");		
		
	}	//end main

}	//end Exercise_10_7