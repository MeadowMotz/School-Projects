// Array_Spinner.java

import java.io.*;
import java.util.*;

/*
 * CPS 150
 * Algorithms & Programming I
 * 
 * Lab Project: Rotating Java Arrays
 * 
 * Name: Meadow Motz
 */

public class Array_Spinner
{
  // Complete the rotate method implementation here:
  public static double[] rotate(double[] values, int rotation)
  {
	  double[] temp1 =  Arrays.copyOfRange(values, 0, 
			  rotation<0 ? Math.abs(rotation) : values.length-Math.abs(rotation)); // copy first section
	  double[] temp2 = Arrays.copyOfRange(values, 
			  rotation<0 ? Math.abs(rotation) : values.length-Math.abs(rotation), values.length); // copy second section
	  double[] result = Arrays.copyOf(temp2, values.length);
	  for (int cc = temp2.length, i = 0; cc<values.length; cc++, i++) {
		  result[cc] = temp1[i]; // flip-flop 
	  }
	  return result;
  } // end rotate method
  
  public static void main(String[] args)
  {
    double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
    
    System.out.println("Before rotation:  ==============================");
    
    for (int i = 0; i < x.length; i++)
    {
      System.out.println("x[" + i + "]:  " + x[i]);
    }
    
    x = rotate(x, 3);
    
    System.out.println("\nAfter rotation:  ==============================");   
       
    for (int i = 0; i < x.length; i++)
    {
      System.out.println("x[" + i + "]:  " + x[i]);
    }
  } // end main method
  
} // end class Array_Spinner
