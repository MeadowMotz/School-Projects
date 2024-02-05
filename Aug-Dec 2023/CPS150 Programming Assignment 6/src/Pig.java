/*
 * Pig.java
 * 
 * CPS 150
 * Algorithms & Programming I
 * 
 * Programming Assignment: The Game of Pig
 *
 * Name: Meadow Motz
 * 
 * Description:
 * 		The first player to reach 100 or more points wins. 
 * 		The human user and the computer take turns. On each turn, a player rolls a six-sided die:
			If the player rolls a 1, then the player gets no new points and it becomes the other player’s turn.
 			If the player rolls 2 through 6, then they can either ROLL AGAIN or
			HOLD/STOP.  At this point, the sum of all rolls is added to the player’s score and it becomes the other player’s turn.
		Additionally, the computer plays under these additional rules:
		- Keep rolling until it has accumulated 20 or more points, then hold. 
			If a 1 is rolled, then the computer's turn ends immediately.
		- Allow the human to roll first.
		
 * Bug Report:
 * 		None found
 */
import java.util.Scanner;
import java.util.Random;

public class Pig {
	public static Scanner in = new Scanner(System.in);
	public static Random dice = new Random();

	public static void main(String[] args) {
		int p1 = 0;
		int p2 = 0;
		String rules = "\n\tThe first player to reach 100 or more points wins. Players take turns. On each turn, a player rolls a six-sided die:"
				+ "\n\tIf the player rolls a 1, then the player gets no new points and it becomes the other player’s turn."
				+ "\n\tIf the player rolls 2 through 6, then they can either ROLL AGAIN or HOLD/STOP"
				+ "\n\tAt this point, the sum of all rolls is added to the player’s score and it becomes the other player’s turn.\n";
		
		System.out.println("Welcome to the game of Pig! You are P1." + rules + "Enter any key to continue . . .");
		String cont = in.next();
		System.out.println();
		while (p1<100 && p2<100) {
			System.out.println("P1: " + p1 + "\nP2: " + p2);
			p1 += turn1(); // user takes their turn
			if (p1<100)
				p2 += turn2(); // computer takes its turn
		} // end while loop
		System.out.println("P1: " + p1 + "\nP2: " + p2);
		win(p1, p2); // announce winner
	} // end main
	
	/*
	 * turn1() -> int
	 * 
	 * player rolls a (digital) dice and adds that number to their turn score 
	 * 	until they roll a 1 or choose to HOLD, in which case, 
	 * 	they will add their turn score to their game score and end their turn
	 * if the player rolls a 1, their turn will end immediately with no addition
	 * 	to their game score
	 */
	public static int turn1() {
		int result = 0;
		int roll = 0;
		boolean again = true;
		String temp = "";
		
		do {
			roll = dice.nextInt(6) + 1;
			System.out.print("You rolled a " + roll);
			if (roll==1) { // if 1, end turn
				System.out.println(", turn lost!");
				again = false;
				result = 0;
				continue;
			}
			else
				System.out.println();
			result += roll;
			System.out.print("[" + result + "]\tRoll again (y/n)? ");
			temp = in.next();
			if (temp.equals("Y") || temp.equals("y"))  // if y, continue turn, otherwise hold
				again = true;
			else if (temp.equals("N") || temp.equals("n")) {
				again = false;
				System.out.println("Holding . . .");
			}
			else {
				System.out.println("Invalid input. Defaulting to \"n\"");
				again = false;
				System.out.println("Holding . . .");
			}
		} while (again);
		System.out.println();
		return result;
	}
	
	/*
	 * turn2() -> int
	 * 
	 * computer rolls a dice and adds that number to its turn score 
	 * 	until it rolls a 1 or its turn score exceeds 19 (>=20),
	 * 	in which case, it will hold and add its turn score to its game score
	 * if it rolls a 1, its turn will end immediately with no addition
	 * 	to its game score
	 */
	public static int turn2() {
		int result = 0;
		int roll = 0;
		boolean again = true;
		
		do {
			roll = dice.nextInt(6) + 1;
			System.out.print("P2 rolled a " + roll);
			if (roll==1) { // if 1, end turn
				System.out.println(", turn lost!");
				again = false;
				result = 0;
				continue;
			}
			else
				System.out.println();
			result += roll;
			if (result>=20) { // if turn points 20+, hold
				again = false;
				System.out.println("(>=20) Holding . . .");
			}
		} while (again);
		System.out.println();
		return result;
	} // end turn2
	
	/*
	 * win(int,int) ->
	 * 
	 * consumes the two players' scores and determines the winner
	 * 	based on who has achieved 100+ points
	 */
	public static void win(int p1, int p2) {
		if (p1>=100)
			System.out.println("P1 wins!");
		else if (p2>=100)
			System.out.println("P2 wins!");
		else
			System.out.println("Error.");
	} // end win
} // end Pig
