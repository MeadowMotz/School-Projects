import java.io.PrintStream;
import java.util.Scanner;

//LockTester.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 1: ComboLock
*
* @author Meadow Motz
* 
* Description: 
* 	tester class for object class ComboLock
*/
public class LockTester {

	public static void main(String[] args) {
		PrintStream out = new PrintStream(System.out);
		Scanner in = new Scanner(System.in);
		ComboLock Lock = new ComboLock(11,32,5);
		String input = "";
		boolean success = false;
		
		out.println("This program models a Master Lock with numbers 0-39."
				+ "\n- To open the lock, one must turn the dial to the right, left, then right, ending on each of the 3 numbers in the code."
				+ "\n- The first number in the list represents the number to which the dial points."
				+ "\n\t*You may turn the same direction twice; this will accept the most recent entry."
				+ "\nCommands: \"open\", \"reset\", \"leave\", \"turn x\" (where x is a nonzero integer between 0-39; negative implies turning left)"
				+ "\n----------------------------------------------------------------------------------------------------------------------------------\n");
		while (!success) {
			try {
				out.print(Lock.showDial() + "\n\t-> ");
				input = in.next();
				
				if (input.equalsIgnoreCase("open")) { // open
					if (Lock.isOpen()) {
						out.println("Lock opened!");
						success = true;	
						continue; } // exits loop
					else out.println("Unsuccessful\n");	
				}
				else if (input.equalsIgnoreCase("reset")) { // reset
					Lock.reset();
					out.println("Lock reset\n"); 
				}
				else if (input.equalsIgnoreCase("leave")) { // leave
					out.println("Process terminated.");
					System.exit(0); 
				}
				else if (input.equalsIgnoreCase("turn")) { // turn
					if (in.hasNextInt()) {
						Lock.turn(in.nextInt());
						out.println();	}
					else throw new IllegalArgumentException("Invalid command");
				}
				else throw new IllegalArgumentException("Invalid command");
			}
			catch (IllegalArgumentException ex) {
				out.println("[!]: " + ex.getMessage() + "\n");
			}
		} // end loop
		in.close();
	} // end main
} // end class LockTester
