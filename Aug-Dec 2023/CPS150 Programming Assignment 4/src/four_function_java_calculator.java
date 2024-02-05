// four_function_java_calculator.java

import java.util.Scanner;

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Programming Assignment: A Four-Function Java Calculator
 *
 * Name: Meadow Motz
 * 
 * Description: Program gets user's math operation choice as int (checks for 1 >= choice >= 4).
	 * Next, it gets two numbers from the user as doubles (checks that input is number).
	 * Lastly, it calls the math operation method corresponding to the user's choice
	 * 	which performs the chosen operation and outputs the result to the user (checks for divide by 0).
 * 
 * Bug Report:
 * 		None found
 */

public class four_function_java_calculator {
	public static Scanner in = new Scanner(System.in);

	/* 
	 * getOption() -> int
	 * 
	 * Displays menu, prompts user for menu choice and ,returns the users choice as an int
	 * Terminates program if user input is not 1, 2, 3, or 4.
	 */
	public static int getOption() {
		// Menu & input directions
		System.out.println("Enter the number of the operation you which to perform:");
		// Menu
		System.out.println("************************");
		System.out.println("1. Addition (+)");
		System.out.println("2. Subtraction (-)");
		System.out.println("3. Multiplication (*)");
		System.out.println("4. Division (/)");
		System.out.println("************************");
		// Input prompt
		System.out.print(" -> ");
		int choice = 0;
		if (in.hasNextInt()) {
			choice = in.nextInt();
			System.out.println();
			
			if (choice < 1 || choice > 4) { // Invalid choice error
				System.out.println("ERROR: Invalid Choice");
				System.exit(0);
			}		
		}
		else
		{
			System.out.println("\nERROR: Invalid Choice");
			System.exit(0);
		}
		return choice;
	} // End getOption
	
	/*
	 * getOperand(String) -> double
	 * 
	 * Displays prompt to user and returns user input as a double 
	 * 
	 * Terminates program if user input is not a number
	 */
	public static double getOperand(String prompt) {
		System.out.print(prompt);
		double input = 0;
		if (in.hasNextDouble()) {
			input = in.nextDouble();
			if (Double.isNaN(input)) 
			{
				System.out.println("ERROR: Invalid input; not a number.");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("\nERROR: Invalid Input");
			System.exit(0);
		}
		return input;
	}
	
	/*
	 * add(double, double) -> void
	 * 
	 * Adds two double values and displays the result to the user
	 */
	public static void add(double a, double b) {
		System.out.printf("%,.1f + %,.1f = %,.1f", a, b, a + b);
	}
	
	/*
	 * subtract(double, double) -> void
	 * 
	 * Subtracts two double values and displays the result to the user
	 */
	public static void subtract(double a, double b) {
		System.out.printf("%,.1f - %,.1f = %,.1f", a, b, a - b);
	}
	
	/*
	 * multiply(double, double) -> void
	 * 
	 * Multiplies two double values and displays the result to the user
	 */
	public static void multiply(double a, double b) {
		System.out.printf("%,.1f * %,.1f = %,.1f", a, b, a * b);
	}
	
	/*
	 * divide(double, double) -> void
	 * 
	 * If second param is not 0, divides two double values and displays the result to the user
	 */
	public static void divide(double a, double b) {
		if (b != 0)
		{
			System.out.printf("%,.1f / %,.1f = %,.1f", a, b, a / b);
		}
		else
		{
			System.out.println("ERROR: Divide by 0");
			System.exit(0);
		}
	}
	
	/*
	 * Program gets user's math operation choice as int (checks for 1 >= choice >= 4).
	 * Next, it gets two numbers from the user as doubles (checks that input is number).
	 * Lastly, it calls the math operation method corresponding to the user's choice
	 * 	which performs the chosen operation and outputs the result to the user (checks for divide by 0).
	 */
	public static void main(String[] args) {
		int choice = getOption();
		
		String prompt = "Enter the first value: ";
		double a = getOperand(prompt);
		prompt = "Enter the second value: ";
		double b = getOperand(prompt);
		System.out.println();
		
		/*
		 * Perform math operation method depending on which choice was made
		 * 1: add operands
		 * 2: subtract operands
		 * 3: multiply operands
		 * 4: divide operands
		 */
		switch (choice) {
		case 1: {
			add(a, b);
			break;
		}
		case 2: {
			subtract(a, b);
			break;
		}
		case 3: {
			multiply(a, b);
			break;
		}
		case 4: {
			divide(a ,b);
		}
		} // End choice switch
	} // End main method
} // End four_function_java_calculator class
