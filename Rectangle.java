//STECH Java programming class
//Exercise 9-1
//created by Robin G. Blaine on 8/29/2017
//design the Rectangle class containing:
//	* two double data fields (width, height) ... default values 1
//	* no-arg constructor that creates a default rectangle
//	* method getArea() that returns the area
//	* method getPerimeter() that returns the perimeter [circumference]


public class Rectangle {
	
	//main method
	
	public static void main(String[] args) {
		
		//create a rectangle with width 1 and height 1
		Rectangle rectangle1 = new Rectangle(1, 1);
		System.out.println("Rectangle 1");
		System.out.println("  Width x Height: " + rectangle1.width + " x " + rectangle1.height);
		System.out.println("    Area:         " + rectangle1.getArea());
		System.out.println("    Perimeter:    " + rectangle1.getPerimeter());
		System.out.println("");
		
		//create a rectangle with width 5 and height 10
		Rectangle rectangle2 = new Rectangle(5, 10);
		System.out.println("Rectangle 2");
		System.out.println("  Width x Height: " + rectangle2.width + " x " + rectangle2.height);
		System.out.println("    Area:         " + rectangle2.getArea());
		System.out.println("    Perimeter:    " + rectangle2.getPerimeter());
		System.out.println("");
		
		//create a rectangle with width 25 and height 35
		Rectangle rectangle3 = new Rectangle(25, 35);
		System.out.println("Rectangle 3");
		System.out.println("  Width x Height: " + rectangle3.width + " x " + rectangle3.height);
		System.out.println("    Area:         " + rectangle3.getArea());
		System.out.println("    Perimeter:    " + rectangle3.getPerimeter());
		System.out.println("");
		
		//modify rectangle2 to have width 67.67 and height 98.33
		rectangle2.width  = 67.67;
		rectangle2.height = 98.33;
		System.out.println("Rectangle 2 (new stats)");
		System.out.println("  Width x Height: " + rectangle2.width + " x " + rectangle2.height);
		System.out.println("    Area:         " + rectangle2.getArea());
		System.out.println("    Perimeter:    " + rectangle2.getPerimeter());
		System.out.println("");
		
	}	//end main
	
	double width;
	double height;	
	
	//construct a rectangle with width 1 and height 1
	Rectangle() {
		width  = 1.0;
		height = 1.0;
	}	//end Rectangle
	
	//construct a rectangle with specified width and height
	Rectangle(double newWidth, double newHeight) {
		width  = newWidth;
		height = newHeight;
	}	//end Rectangle
	
	//return the area of the rectangle
	double getArea() {
		return width * height;
	}	//end getArea
	
	//return the perimeter of the rectangle
	double getPerimeter() {
		return 2 * width + 2 * height;
	}	//end getPerimeter
	
	//set new width for circle
	void setWidth(double newWidth) {
		width = newWidth;
	}	//end setWidth
	
	//set new height for circle
	void setHeight(double newHeight) {
		height = newHeight;
	}	//end setHeight
	
}	//end Exercise_9_1