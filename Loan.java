// STECH Java Programming Class
// LoanCalculator.java
// from Introduction to JAVA programming, Brief Version (10th Edition)
//		Listing 10.2, pages 368-369
// input/revised by Robin G. Blaine on 9/27/17

/*
	
	Create a loan object.
	
*/


public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	// Default constructor
	public Loan() {
		this(2.5, 1, 1000);
	}	// end default constructor
	
	// Construct a specified loan
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}	// end specified constructor
	
	// Return annualInterestRate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}	// end getAnnualInterestRate
	
	// Set a new annualInterestRate
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}	// end setAnnualInterestRate
	
	// Return numberOfYears
	public int getNumberOfYears() {
		return numberOfYears;
	}	// end getNumberOfYears
	
	// Set a new numberOfYears
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}	// end setNumberOfYears
	
	// Return loanAmount
	public double getLoanAmount() {
		return loanAmount;
	}	// end getLoandAmount
	
	// Set a new loanAmount
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}	// end setLoanAmount
	
	// Find monthly payment
	public double getMonthlyPayment () {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}	// end getMonthlyPayment
	
	// Find total payment
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}	// end getTotalPayment
	
	// Return loan date
	public java.util.Date getLoanDate() {
		return loanDate;
	}	// end getLoanDate
}	// end Loan