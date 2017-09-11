//define superclass Person
public class Person {
	
	//define variables
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String emailAddress;
	
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
