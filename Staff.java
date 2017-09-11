//define subclass Staff
public class Staff
	extends Employee {
	
	//define variables
	protected String title;
		
	//default constructor
	Staff() {
		super();
		this.title = "";
	}	//end Staff default constructor
	
	//specified constructor
	Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title) {
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
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
				"Date Hired: " + this.dateHired.toString() + "\n" +
				"Title: " + this.title);
	}	//end toString Override
	
}	//end subsubclass Staff => Employee => Person