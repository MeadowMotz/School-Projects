/*
 * PenneysGame.java
 * 
 * CPS 150
 * Algorithms & Programming I
 * 
 * Programming Assignment: Penney's Game
 *
 * Name: Meadow Motz
 * 
 * Description:
 *		User enters the number of coins they wish to predict/choose and their sequence of choices,
		then the computer randomly chooses its sequence of predictions,
		and finally, the system will flip a coin until one of the players' sequences comes up and that player wins
 * 
 * Bug Report:
 * 		None Found
 */
import java.util.*;
import java.io.*;

public class PenneysGame {
	public static Scanner in = new Scanner(System.in);
	public static PrintStream out = new PrintStream(System.out);
	public static PrintStream err = new PrintStream(System.err);
	
	public static void main(String[] args) {
		out.println("Penney's Game:");
		out.println("\tA) Enter the number of coins you & computer get to choose");
		out.println("\tB) Then, enter your coin choices");
		out.println("\tC) Then, we'll keep flipping the coin until one of our sequences comes up, and that player wins.\n");
		
		int n = coins();
		boolean[] user = getUser(n);
		boolean[] comp = getComp(n, user);
		out.print("Your choices: "); echo(user);
		out.print("Computer's choices: "); echo(comp);
		flip(user, comp);
	} // end main
	
	
	/*
	 * coins() -> int
	 * 
	 * Get the number of coins in the player sequence n as user input; reject any user input that is not a positive integer
	 */
	public static int coins() {
		int result = -1;
		while (result<=0) {
			out.print("Enter the number of coins (> 0): ");
			if (in.hasNextInt()) {
				result = in.nextInt();
				if (result==0) {
					result = -1; err.println("\tInvalid Input. Please try again (> 0)");
				}
			}
			else {err.println("\tInvalid input. Please try again (> 0)"); in.next(); }
		}
		return result;
	} // end coins
	
	
	/*
	 * getUser(int) -> boolean[]
	 * 
	 * get's user's choice(s) for the coin flips as String input; reject any input that isn't H (heads) or T (tails) (ignore case)
	 */
	public static boolean[] getUser(int n) {
		boolean[] user = new boolean[n];
		String input = "";
		for (int cc = 0; cc<user.length; ) {
			out.print("Enter coin " + (cc+1) + ": ");
			if (in.hasNext()) {
				input = in.next();
				// if heads=true, tails=false; else, error & retry
				if (input.equalsIgnoreCase("h")||input.equalsIgnoreCase("t")) {
					user[cc] = input.equalsIgnoreCase("h")?true:false; cc++; }
				else err.println("\tInvalid input. Please enter 'H' or 'T'");
			} else err.println("\tInvalid input. Please enter 'H' or 'T'");
		}
		return user;
	} // end getUser
	
	
	/*
	 * getComp(int, boolean[]) -> boolean[]
	 * 
	 * randomly returns computer's choice(s) for coin flips (50/50 probability)
	 * tries again until its choices are different from the user's
	 */
	public static boolean[] getComp(int n, boolean[] user) {
		boolean[] comp = new boolean[n];
		boolean good = false;
		while (!good) {
			for (int cc = 0; cc<comp.length; cc++) {
				comp[cc] = Math.random()>0.5 ? true : false;
			}
			if (!Arrays.equals(comp, user)) good = true;
		}
		return comp;
	} // end getComp
	
	
	/*
	 * flip(boolean[], boolean[]) ->
	 * 
	 * consumes user & computer coin choices;
	 * randomly flips coin (50/50 probability) until 
	  	a sequence of flips is equivalent to one of the players' series of choices.
	  	declares winner based on whose series of choices appeared first
	 */
	public static void flip(boolean[] user, boolean[] comp) {
		boolean winner = false, who = false;
		int toss = 0, n = user.length;
		boolean[] flips = new boolean[10000];
		while (!winner && toss<10000) {
			flips[toss] = Math.random()>0.5 ? true : false;
			toss++;
			if (toss>=n) {
				if (Arrays.equals(Arrays.copyOfRange(flips, toss-n, toss), user)) {
					winner = true;
					who = true; }
				else if (Arrays.equals(Arrays.copyOfRange(flips, toss-n, toss), comp)) {
					winner = true;
					who = false; }
			}
		} // end while
		out.print("Flips: "); echo(Arrays.copyOfRange(flips, 0, toss));
		if (who) out.println("You won! Good job!");
		else out.println("You lost! Better luck next time!");
	} // end flip
	
	
	/*
	 * echo(boolean[]) ->
	 * 
	 * consumes sequence of choices & echoes the choices to the user
	 */
	public static void echo(boolean[] seq) {
		String temp = "";
		out.print("[");
		for (int cc = 0; cc<seq.length-1; cc++) { 
			temp = seq[cc] ? "H" : "T";
			out.print(temp + ", ");
		}
		temp = seq[seq.length-1] ? "H" : "T";
		out.println(temp + "]");
	}
} // end PenneysGame
