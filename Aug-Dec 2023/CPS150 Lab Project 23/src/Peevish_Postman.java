// Peevish_Postman.java

import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: The Peevish Postman Problem (Java Boolean Arrays)
 * 
 * Name: Meadow Motz
 */

public class Peevish_Postman
{
  public static void main(String[] args)
  {
    boolean[] doors;
    final int NODOORS = 101;    // We will not use door[0]
    final boolean OPEN = true;
    final boolean CLOSED = false;
    // Initialize the doors
    doors = new boolean[NODOORS];
    for (int i = 0;  i < NODOORS; i++)
    {
      doors[i] = CLOSED;
    }
    // Print the initial state of each door (only doors 1-100)
    for (int i = 1; i < doors.length; i++)
    {
      System.out.print("Door " + i + " is ");
      if (doors[i]) { System.out.println("open."); }
      else { System.out.println("closed."); }
    }
    
    // ADD YOUR CODE BETWEEN THIS LINE ...
    for (int x = 1; x<=100; x++) { // loop for each pass (100 passes)
    				/*
    				 * loop for printing array for each pass (for debugging)
    				 * 
    				 * row*10+col converts from 2-dimensional to 1-dimension
    				 * 
    				 * loops structured for 2-dimensional in order to print 2-dimensional
    				 
    				for (int row = 0; row<10; row++) { 
    					for (int col = 1; col<=10; col++) { 
    						if (doors[row*10+col]) System.out.print("  ");
    						else System.out.print("- ");
    					}
    					System.out.println();
    				}
    				System.out.println("____________________"); // separate each pass 
    				*/
    	for (int y = 1; y<=100; y++) { // traversal loop for boxes
    		if ((y%x)==0) {
    			doors[y] = !doors[y];
    		}
    	}
    }
    				/*for (int row = 0; row<10; row++) { 
    					for (int col = 1; col<=10; col++) { 
    						if (doors[row*10+col]) System.out.print("  ");
    						else System.out.print("- ");
    					}
    					System.out.println();
    				}*/
// Final state of doors (after 100 passes) is represented by the last output from the loop above
    
    // ... AND THIS LINE
    
    // Print the final state of each door (only doors 1-100)
    for (int i = 1; i < doors.length; i++)
    {
      System.out.print("Door " + i + " is ");
      if (doors[i]) { System.out.println("open."); }
      else { System.out.println("closed."); }
    }
  } // end main method
} // end class Peevish_Postman
