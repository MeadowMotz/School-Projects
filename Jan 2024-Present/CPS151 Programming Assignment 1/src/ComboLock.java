
//ComboLock.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 1: ComboLock
*
* @author Meadow Motz
* 
* Description: 
* 	Models a MasterLock comination lock, which can:
* - Turn its dial left & right to a given number
* - Reset the dial to 0
* - Store the 3 latest number entries
* - Open if the entered numbers are equal to the lock's code
*/
import java.util.ArrayList;
import java.util.Arrays;

public class ComboLock {
	private final int[] code;
	private ArrayList<Boolean> turns;
	private final boolean[] correctTurns;
	private ArrayList<Integer> entries;
	private int[] dial;
	private final int dialSize = 40;
	
	/*
	 * @param first number of lock code
	 * @param second number of lock code
	 * @param third number of lock code
	 * 
	 * initializes all data fields (dial numbers/size, code, turn identity)
	 */
	public ComboLock(int num1, int num2, int num3) {
		code = new int[]{num1, num2, num3};
		turns = new ArrayList<Boolean>();
		entries = new ArrayList<Integer>();
		dial = new int[dialSize];
		fillDial();

		correctTurns = new boolean[] {true, false, true};
	} // end constructor ComboLock
	
	/*
	 * resets dial to 0 
	 * 	& clears user input history
	 */
	public void reset() {
		turns.clear();
		entries.clear();
		fillDial();
	} // end reset
	
	/*
	 * @param number of ticks ("how far") to rotate the dial
	 * 
	 * moves the dial array forward or backwards a given number of ticks and records the final position
	 */
	public void turn(int ticks) {
		if (ticks==0||ticks<-41||ticks>41) throw new IllegalArgumentException("Please enter a non-zero integer (-41 < x < 41)");
		
		int[] temp1 =  Arrays.copyOfRange(dial, 0, 
			  ticks<0 ? dial.length-Math.abs(ticks) : Math.abs(ticks)); // copy first section
		int[] temp2 = Arrays.copyOfRange(dial, 
			  ticks<0 ? dial.length-Math.abs(ticks) : Math.abs(ticks), dial.length); // copy second section
		// flip-flop
		for (int cc = 0, i = 0; i<temp2.length; cc++, i++) dial[cc] = temp2[i];
		for (int cc = temp2.length, i = 0; i<temp1.length; cc++, i++) dial[cc] = temp1[i]; 
		
		track(ticks);
	} // end turn
	
	/*
	 * @return if user input history equals the lock code
	 */
	public boolean isOpen() {
		if (Arrays.equals(asBArray(turns), correctTurns) && Arrays.equals(code, asIArray(entries)))
			return true;
		else 
			return false;
	} // end isOpen
	
	/*
	 * @return visual representation of the dial (String)
	 */
	public String showDial() {
		return Arrays.toString(dial);
	} // end showDial
	
	/*
	 * @param number of ticks by which the dial rotated
	 * 
	 * stores the given rotation and current number of the dial
	 * if dial is turned the same direction more than once, 
	 * 		consolidates the rotation to once in the given direction 
	 * 		and the dial number to the most recent/current number (equivalent to adding the ticks rotated)
	 */
	private void track(int ticks) {
		if (ticks<0) turns.add(false);
		else turns.add(true);
		entries.add(dial[0]);
		
		boolean merge = false;
		if (turns.size()>2 && entries.size()>2 && turns.get(turns.size()-1)==turns.get(turns.size()-2))	merge = true;
		if (merge) {
			turns.remove(turns.size()-1);
			entries.remove(entries.size()-2); }
		
		if (turns.size()>3) turns.remove(0);
		if (entries.size()>3) entries.remove(0);
	} // end track
	
	/*
	 * set the dial array to numbers 0-39, increasing 
	 */
	private void fillDial() {
		for (int cc = 0; cc<dialSize; cc++) dial[cc] = cc;
	} // end fillDial
	
	/*
	 * @param ArrayList to be converted
	 * @return array copy of the contents of the given ArrayList
	 */
	private boolean[] asBArray(ArrayList<Boolean> list) {
		boolean[] arr = new boolean[list.size()];
		for (int cc = 0; cc<list.size(); cc++) arr[cc] = list.get(cc);
		return arr;
	} // end asBArray
	
	/*
	 * @param ArrayList to be converted
	 * @return array copy of the contents of the given ArrayList
	 */
	private int[] asIArray(ArrayList<Integer> list) {
		int[] arr = new int[list.size()];
		for (int cc = 0; cc<list.size(); cc++) arr[cc] = list.get(cc);
		return arr;
	} // end asIArray
} // end class ComboLock
