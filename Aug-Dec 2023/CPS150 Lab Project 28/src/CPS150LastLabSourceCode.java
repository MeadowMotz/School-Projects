import java.util.Arrays;

/*
 * CPS150LastLabSourceCode.java
 */

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * The Last CPS 150 Lab Project
 *
 * Name: Meadow Motz
 */

public class CPS150LastLabSourceCode
{
   /*
    * sameElements(int[], int[]) -> boolean
    * 
    * method is passed two arrays of integers
    * method returns:
    *  true if the arrays have the same elements,
    *   regardless of order
    *  false otherwise
    * 
    * see the lab project page for more details
    * 
    * *** ADD METHOD IMPLEMENTATION AFTER NEXT LINE ***
    */
	public static boolean sameElements(int[] a, int[] b) {
		boolean same = false;
		if (a.length==b.length) {
			for (int cc=0; cc<=a.length && !same; cc++) 
				if (Arrays.equals(a,rotate(b,cc))) same = true;
		}
		return same;
	}
	/*
	 * rotate(int[], int) -> int[]
	 * 
	 * shifts all the elements in the array forward/backward (index) by the given amount
	 * 
	 * (copied from lab 24)
	 */
	public static int[] rotate(int[] values, int rotation) {
		  int[] temp1 =  Arrays.copyOfRange(values, 0, 
				  rotation<0 ? Math.abs(rotation) : values.length-Math.abs(rotation));
		  int[] temp2 = Arrays.copyOfRange(values, 
				  rotation<0 ? Math.abs(rotation) : values.length-Math.abs(rotation), values.length); 
		  int[] result = Arrays.copyOf(temp2, values.length);
		  for (int cc = temp2.length, i = 0; cc<values.length; cc++, i++) {
			  result[cc] = temp1[i]; }
		  return result;
	} 
	
   /*
    * DO NOT MODIFY THE MAIN METHOD BELOW!
    */
 public static void main(String[] args)
 {
  int[] a = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
  int[] b = { 11, 1, 4, 9, 16, 9, 7, 4, 9 };
  int[] c = { 11, 11, 7, 9, 16, 4, 1, 4, 9 };

  System.out.print("The arrays a and b ");

  if (!sameElements(a, b))
  {
   System.out.print("do not ");
  }

  System.out.println("have the same elements.");

  System.out.print("The arrays a and c ");

  if (!sameElements(a, c))
  {
   System.out.print("do not ");
  }

  System.out.println("have the same elements.");
 } // end main method
} // end class
