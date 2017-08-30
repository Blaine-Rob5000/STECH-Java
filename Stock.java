//STECH Java programming class
//Exercise 9-2
//created by Robin G. Blaine on 8/30/2017
//design the Stock class containing:
//	* string data field:  symbol
//	* string data field:  name
//	* double data field:  previousClosingPrice
//	* double data field:  currentPrice
//  * constructor that creates a stock with specified symbol and name
//  * method:  getChangePercent() that returns the percentage changed from
//               previousClosingPrice to currentPrice
//
//Draw the UML diagram for the class then implement it.
//Write a test program to creates a Stock object with
//                  symbol:  ORCL
//                    name:  Oracle Corporation
//    previousClosingPrice:  34.5
//            currentPrice:  34.35
//and display the price-change percentage


public class Stock {
	
	//main method
	
	public static void main(String[] args) {
		
		//create a Stock: ORCL, Oracle, 34.5, 34.35
		Stock myStock = new Stock("ORCL", "Oracle", 34.5, 34.35);
		System.out.println("Stock name: " + myStock.name);
		System.out.println("    Symbol: " + myStock.symbol);
		System.out.println("");
		System.out.printf("  Previous closing price: $%,.2f%n", myStock.previousClosingPrice);
		System.out.printf("           Current price: $%,.2f%n", myStock.currentPrice);
		System.out.println("");
		System.out.printf("Change: %+.2f", myStock.getChangePercent());
		System.out.println("%");
		
	}	//end main
	
	//variables
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
		
	//construct a stock with specified symbol and name
	Stock(String newSymbol,
	      String newName,
	      double newPreviousClosingPrice,
	      double newCurrentPrice) {
		symbol               = newSymbol;
		name                 = newName;
		previousClosingPrice = newPreviousClosingPrice;
		currentPrice         = newCurrentPrice;
	}	//end Stock
	
	//return the percentage of change from previousClosingPrice to newCurrentPrice
	double getChangePercent() {
		return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
	}	//end getChangePercent
	
}	//end Exercise_9_2