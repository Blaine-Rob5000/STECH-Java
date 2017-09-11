//define MyDate class

//imports
import java.util.GregorianCalendar;

public class MyDate {
	
	//define class variables
	protected int year;
	protected int month;
	protected int day;
	protected GregorianCalendar date = new GregorianCalendar();
	
	
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
	
	//convert to String
	@Override
	public String toString() {
		return (this.month + "/" + this.day + "/" + this.year);
	}
	
}	//end MyDate class