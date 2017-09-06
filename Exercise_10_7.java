//STECH Java programming class
//Exercise 10-7
//created by Robin G. Blaine on 9/6/2017
//use the Account Class to simulate an ATM
//create 10 accounts in an array with id 0, 1, 2, ..., 9 and initial balance $100.00
//prompt the user to enter an id (if invalid, prompt the user to enter a valid id)
//Main menu:
//  1) check balance
//  2) withdraw
//  3) deposit
//  4) exit
//upon exiting, the system starts over (asks for id)


//imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;


public class Exercise_10_7 {
		
	public static void main(String[] args) {
		
		//create Scanner
		Scanner input = new Scanner(System.in);
		
		
		//declare array
		ArrayList<Account> account = new ArrayList<>();
		
		
		//set account balances to $100
		for (int count = 0; count < 10; count++)
			account.add(new Account(count, 100.00));
		
		
		//delcare variables
		int userId = -1;
		double depositAmount = -1.0;
		double withdrawalAmount = -1.0;
		int menuSelection = -1;
		
		//Main Menu
		while (true) {
			
			userId = -1;
			menuSelection = -1;
			
			System.out.println("");
			System.out.println("");
			System.out.println("* * * Welcome to the ATM! * * *");
			System.out.println("");
			System.out.println("");
			
			//enter id and verify it is valid
			while ((userId < 0) || (userId > 9)) {
				System.out.print("Enter an account number from 0 to 9: ");
				userId = input.nextInt();
				
				if ((userId < 0) || (userId > 9)) {
					System.out.println("");
					System.out.println("Invalid account number!");
					System.out.println("");
				}	//end if
			}	//end while
			
			//display main menu, select and validate option
			while ((menuSelection != 4)) {	
				System.out.println("Main menu");
				System.out.println("  1) check balance");
				System.out.println("  2) withdraw");
				System.out.println("  3) deposit");
				System.out.println("  4) exit");
				System.out.println("");
				System.out.print("Enter menu selection: ");
				menuSelection = input.nextInt();
				
				if ((menuSelection < 1) || (menuSelection > 4)) {
					System.out.println("");
					System.out.println("Invalid menu selection!");
					System.out.println("");
				}
				else if (menuSelection == 1) {
					System.out.println("");
					System.out.printf("The account balance is: $%,.2f%n", account.get(userId).balance());
					System.out.println("");
				}
				else if (menuSelection == 2) {
					do {
						System.out.println("");
						System.out.print("Enter the amount to withdraw: $");
						withdrawalAmount = input.nextDouble();
						
						if (withdrawalAmount < 0) {
							System.out.println("");
							System.out.println("Invalid withdrawal... please enter a positive amount!");
							System.out.println("");
						}
						else if (withdrawalAmount > account.get(userId).balance()) {
							System.out.println("");
							System.out.println("Insufficient funds!");
							System.out.println("");
						}
						else {
							account.get(userId).withdraw(withdrawalAmount);
							System.out.println("");
							System.out.printf("$%,.2f", withdrawalAmount);
							System.out.println(" withdrawn.");
							System.out.println("");
							withdrawalAmount = -1.0;
						}	//end if
					} while (withdrawalAmount != -1.0);	//end do (withdrawal)
				}
				else if (menuSelection == 3) {
					do {
						System.out.println("");
						System.out.print("Enter the amount to deposit: $");
						depositAmount = input.nextDouble();
						
						if (depositAmount < 0) {
							System.out.println("");
							System.out.println("Invalid deposit... please enter a positive amount!");
						}
						else {
							account.get(userId).deposit(depositAmount);
							System.out.println("");
							System.out.printf("$%,.2f", depositAmount);
							System.out.println(" deposited.");
							System.out.println("");
							depositAmount = -1.0;
						}	//end if
						
					} while (depositAmount != -1.0);	//end while (deposit)
					
				}	//end while (menu selection)
				
			}	//end While (main menu)
			
		}	//end While (id selection)
		
	}	//end main
		
}	//end Exercise_10_7


//define the Account class
class Account {
	
	//define class variables
	private int id;
	private double balance;
	private double annualInterestRate = 0.0;
	private java.util.Date dateCreated = new java.util.Date();
	
	
	//default constructor
	public Account() {
		this(0, 0.0);
		this.dateCreated = new Date();
	}	//end Account default constructor
	
	
	//constructor with specified id and balance
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated = new Date();
	}	//end Account specified constructor
	
	
	//accessor: id
	public int id() {
		return this.id;
	}	//end id
	
	
	//accessor: balance
	public double balance() {
		return this.balance;
	}	//end balance
	
	
	//accessor: annualInterestRate
	public double annualInterestRate() {
		return annualInterestRate;
	}	//end getAnnualInterestRate
	
	
	//mutator: id
	public void setId (int id) {
		this.id = id;
	}	//end setId
	
	
	//mutator: balance
	public void setBalance (double balance) {
		this.balance = balance;
	}	//end balance
	
	
	//mutator: annualInterestRate
	public void setAnnualInterestRate (double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	
	
	//accessor: dateCreated
	public java.util.Date dateCreated () {
		return this.dateCreated;
	}	//end dateCreated
	
	
	//return the monthly interest rate
	public double getMonthlyInterestRate () {
		return annualInterestRate / 12;
	}	//end getMontlhyInterestRate
	
	
	//return the monthly interest amount
	public double getMonthlyInterest () {
		return this.balance * annualInterestRate / 12 / 100;
	}	//end getMonthlyInterest
	
		
	//make a withdrawal
	public void withdraw (double amount) {
		this.balance -= amount;
	}	//end withdraw
	
	
	//make a deposit
	public void deposit (double amount) {
		this.balance += amount;
	}	//end deposit
	
	
}	//end Account class

