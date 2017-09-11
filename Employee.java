//define subclass Employee
public class Employee
	extends Person {
	
	//define variables
	protected String office;
	protected double salary;
	protected MyDate dateHired = new MyDate();
	
	//default constructor
	Employee() {
		super();
		this.office = "";
		this.salary = 0.00;
		this.dateHired = new MyDate();
	}	//end Employee default constructor
	
	//specified constructor
	Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired) {
		super(name, address, phoneNumber, emailAddress);
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
				"Date Hired: " + MyDate(this.dateHired).toString());
	}	//end toString Override
	
}	//end subclass Employee => Person
