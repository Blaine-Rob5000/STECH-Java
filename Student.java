//define subclass Student
public class Student
	extends Person {
	
	//define constants
	final String CLASS_STATUS;
	
	//default constructor
	Student() {
		super();
		CLASS_STATUS = "";
	}	//end Student default constructor
	
	//specified constructor
	Student(String name, String address, String phoneNumber, String emailAddress, String classStatus) {
		super(name, address, phoneNumber, emailAddress);
		CLASS_STATUS = classStatus;
	}	//end Student specified constructor
	
	//getter: CLASS_STATUS
	public String getClassStatus() {
		return this.CLASS_STATUS;
	}	//end getClassStatus
	

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
