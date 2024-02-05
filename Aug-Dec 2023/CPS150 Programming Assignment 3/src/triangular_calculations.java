/*
 * CPS 150, Algorithms & Programming I
 *
 * Programming Assignment 3: Triangular Calculations
 * 
 * This program calculates the side lengths, angles, perimeter and area
	of a triangle, given the x- and y-coordinates of its corner points.
 * 
 * Name: Meadow Motz
 */

import java.util.Scanner;

class triangular_calculations {
	static Scanner in = new Scanner(System.in);
	
//	displays the passed prompt String to the user, and returns the user input (int)
	public static int getCoordinate(String prompt) {
		System.out.print(prompt);
		return in.nextInt();
	}
	
// 	calculates the length of a triangle side, given the x- and 
//	y-coordinates of 2 triangle corner points (x1,y1) and (x2,y2), using the distance formula
	public static double calcSideLength(int x1, int y1, int x2, int y2) {
		double result = Math.sqrt( Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2) );
		return result;
	}
	
//	calculate the alpha angle of a triangle given the lengths of its three sides (a, b and c)
	public static double calcAlphaAngle(double a, double b, double c) {
		double result = Math.acos((b*b + c*c - a*a)/(2*b*c));
		return result;
	}
	
//	calculate the beta angle of a triangle given the lengths of its three sides (a, b and c)
	public static double calcBetaAngle(double a, double b, double c) {
		double result = Math.acos((a*a + c*c - b*b)/(2*a*c));
		return result;
	}
	
//	calculate the gamma angle of a triangle given the lengths of its three sides (a, b and c)
	public static double calcGammaAngle(double a, double b, double c) { 
		double result = Math.acos((b*b + a*a - c*c)/(2*b*a));
		return result;
	}
	
//	calculates the perimeter of a triangle given the lengths of its three sides
	public static double calcPerimeter(double side1, double side2, double side3) {
		double result = side1 + side2 + side3;
		return result;
	}
	
//	calculates the area of a triangle given the lengths of its three sides a, b and c, according to the equation
	public static double calcArea(double a, double b, double c) {
		double s = (a+b+c)/2;
		double result = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
		return result;
	}
	
	public static void main(String[] args) {
		System.out.print("This program calculates the side lengths, angles, perimeter, and area of a triangle, ");
		System.out.println("given the x- and y-coordinates of its corner points.\n");
		
		// Input coords
		String prompt = "Enter the x-coordinate of the first corner point: ";
		int x1 = getCoordinate(prompt);
		
		prompt = "Enter the y-coordinate of the first corner point: ";
		int y1 = getCoordinate(prompt);
		
		prompt = "Enter the x-coordinate of the second corner point: ";
		int x2 = getCoordinate(prompt);
		
		prompt = "Enter the y-coordinate of the second corner point: ";
		int y2 = getCoordinate(prompt);
		
		prompt = "Enter the x-coordinate of the third corner point: ";
		int x3 = getCoordinate(prompt);
		
		prompt = "Enter the y-coordinate of the third corner point: ";
		int y3 = getCoordinate(prompt);
		System.out.println();
		
		// Calculations
		double side1 = calcSideLength(x1, y1, x2, y2);
		double side2 = calcSideLength(x1, y1, x3, y3);
		double side3 = calcSideLength(x2, y2, x3, y3);
		
		double alpha = Math.toDegrees(calcAlphaAngle(side1, side2, side3));
		double beta = Math.toDegrees(calcBetaAngle(side1, side2, side3));
		double gamma = Math.toDegrees(calcGammaAngle(side1, side2, side3));
		
		double area = calcArea(side1, side2, side3);
		double perim = calcPerimeter(side1, side2, side3);
		
		// Output
		System.out.printf("The lengths of the three sides of the triangle are %.1f, %.1f, and %.1f\n\n",  side1, side2, side3);
		System.out.printf("The three angles of the triangle are %.1f degrees, %.1f degrees, and %.1f degrees\n\n",  alpha, beta, gamma);
		System.out.printf("The perimeter of the triangle is %.1f, and the area of the triangle is %.1f\n\n", perim, area);
	}
}