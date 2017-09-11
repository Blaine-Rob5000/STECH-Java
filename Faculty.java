//define subclass Faculty
public class Faculty
	extends Employee {
	
	//define variables
	protected String officeHours;
	protected String rank;
		
	//default constructor
	Faculty() {
		super();
		this.officeHours = "";
		this.rank = "";
	}	//end Faculty default constructor
	
	//specified constructor
	Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String officeHours, String rank) {
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
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
				"Date Hired: " + this.dateHired.toString() + "\n" +
				"Office Hours: " + this.officeHours + "\n" +
				"Rank: " + this.rank);
	}	//end toString Override
	
}	//end subsubclass Faculty => Employee => Person