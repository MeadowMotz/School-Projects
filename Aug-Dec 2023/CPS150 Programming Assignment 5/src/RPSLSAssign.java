/*
 * CPS150_RPSLSAssign.java
 */
import static java.lang.Math.*; // so you can call Math methods without the 'Math.' prefix

import java.io.*;
import java.util.*;

/**
 * CPS 150
 * Algorithms & Programming I
 * 
 * Programming Assignment: Rock Paper Scissors Lizard Spock
 *
 * Name: Meadow Motz
 * 
 * Description:
 * 		This program plays the game Rock, Paper, Scissors, Lizard, Spock with the user and computer.
 * 		First, it gets, validates, and converts the user's choice for the program to use.
 * 		Next, the computer chooses a random choice.
 * 		Then, the program compares the choices and determines the winner, according to the rules.
 * 		And lastly, it prompts the user to play again, terminating the program if "no."
 */
public class RPSLSAssign
{
    // global input/output variables
    public static Scanner scan = new Scanner(System.in);
    public static PrintStream output = System.out;

    // global named constants for game choices
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static final int LIZARD = 4;
    public static final int SPOCK = 5;
    
    // global names constants for game outcomes
    public static final int PLAYER1_WINS = 11;
    public static final int PLAYER2_WINS = 12;
    public static final int DRAW = 13;
    
    // global strings for game rules
    public static final String rule1 = "Scissors cuts paper";
    public static final String rule2 = "Paper covers rock";
    public static final String rule3 = "Rock crushes lizard";
    public static final String rule4 = "Lizard poisons Spock";
    public static final String rule5 = "Spock smashes scissors";
    public static final String rule6 = "Scissors decapitates lizard";
    public static final String rule7 = "Lizard eats paper";
    public static final String rule8 = "Paper disproves Spock";
    public static final String rule9 = "Spock vaporizes rock";
    public static final String rule10 = "Rock crushes scissors";

    /**
     * 1. Get human player's choice
     * 2. Get computer player's (random) choice
     * 3. Check human player's choice
     * 4. Check computer player's choice
     * 5. Announce winner
     */
    public static void main(String[] args)
    {
    	// player choice variables
        int player1 = 0;
        int player2 = 0;
        // input buffer variable
        String input = ""; 
        boolean again = true;
        
        output.println("Welcome to the game of Rock Paper Scissors Lizard Spock\n");
        output.println("Here are the rules:");
        output.println("\t"+rule1);
        output.println("\t"+rule2);
        output.println("\t"+rule3);
        output.println("\t"+rule4);
        output.println("\t"+rule5);
        output.println("\t"+rule6);
        output.println("\t"+rule7);
        output.println("\t"+rule8);
        output.println("\t"+rule9);
        output.println("\t(and as it always has) "+rule10);
        output.println("\nReady? Then let's begin!\n");
        
        // start "play again?" loop
    	while (again) { 
    		try 
    		{
    				// get player 1 input (RPSLS)
    				output.print("Player 1, enter your choice ( rock, paper, scissors, lizard, Spock ): ");
    				if (scan.hasNext()) { input = scan.next(); }
    				else { throw new IllegalArgumentException("[ERROR]: No Input Detected"); }
    				
    				// assign, validate, & echo human player's choice
    				player1 = textToNumber(input);
        
    				// assign player2 random int between 1 & 3
    				Random rand = new Random();
    				player2 = rand.nextInt(5) + 1;
    				
    				// echo
    				output.print("Player 2 (computer) chooses ");
    				p2echo(player2);
                
    				
    				// compare player1 input against player2 choice (determine who wins)
    				int outcome = compare(player1, player2);
               
    				// output the outcome/winnter
    				printWin(outcome);
    				
    				// play again?
    				again = playAgain();
    				
    		} // end try
    		catch (IllegalArgumentException ex) {
    			output.println(ex.getMessage());
    			again = playAgain();
    		} // end catch
        } // end "play again?" loop   
    } // end main
    
    /**
     * rockChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER, SCISSORS, LIZARD, or SPOCK),
     *   assuming the human player has chosen ROCK
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     */
    public static int rockChoice(int choice)
    {
    	int result = 0;
    	if (choice == ROCK) {
    		result = DRAW; 
    	}
    	else if (choice == PAPER) {	
    		result = PLAYER2_WINS; 
    		output.print("\t"+rule2 + "; ");
    	}
    	else if (choice == SCISSORS) {
    		result = PLAYER1_WINS; 
    		output.print("\t"+rule10 + "; ");
    	}
    	else if (choice == LIZARD) {
    		result = PLAYER1_WINS;
    		output.print("\t"+rule3 + "; ");
    	}
    	else if (choice == SPOCK) {
    		result = PLAYER2_WINS;
    		output.print("\t"+rule9 + "; ");
    	}
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
        return result; 
    } // end rockChoice
    
    /**
     * paperChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER, SCISSORS, LIZARD, or SPOCK),
     *   assuming the human player has chosen PAPER
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     */
    public static int paperChoice(int choice)
    {
    	int result = 0;
    	if (choice == PAPER) {
    		result = DRAW; 
    	}
    	else if (choice == SCISSORS) {
    		result = PLAYER2_WINS; 
    		output.print("\t"+rule1 + "; ");
    	}
    	else if (choice == ROCK) {
    		result = PLAYER1_WINS; 
    		output.print("\t"+rule2 + "; ");
    	}
    	else if (choice == LIZARD) {
    		result = PLAYER2_WINS;
    		output.print("\t"+rule7 + "; ");
    	}
    	else if (choice == SPOCK) {
    		result = PLAYER1_WINS;
    		output.print("\t"+rule8 + "; ");
    	}
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
        return result; 
    } // end paperChoice
    
    /**
     * scissorsChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER, SCISSORS, LIZARD, or SPOCK),
     *   assuming the human player has chosen SCISSORS
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     */
    public static int scissorsChoice(int choice)
    {
    	int result = 0;
    	if (choice == SCISSORS) {
    		result = DRAW; 
    	}
    	else if (choice == ROCK) {	
    		result = PLAYER2_WINS; 
    		output.print("\t"+rule10 + "; ");
    	}
    	else if (choice == PAPER) {	
    		result = PLAYER1_WINS; 
    		output.print("\t"+rule1 + "; ");
    	}
    	else if (choice == LIZARD) {
    		result = PLAYER1_WINS;
    		output.print("\t"+rule6 + "; ");
    	}
    	else if (choice == SPOCK) {
    		result = PLAYER2_WINS;
    		output.print("\t"+rule5 + "; ");
    	}
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
        return result; 
    } // end scissorsChoice
    
    /**
     * lizardChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER, SCISSORS, LIZARD, or SPOCK),
     *   assuming the human player has chosen LIZARD
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     */
    public static int lizardChoice(int choice)
    {
    	int result = 0;
    	if (choice == LIZARD) {
    		result = DRAW; 
    	}
    	else if (choice == ROCK) {	
    		result = PLAYER2_WINS; 
    		output.print("\t"+rule3 + "; ");
    	}
    	else if (choice == PAPER) {	
    		result = PLAYER1_WINS; 
    		output.print("\t"+rule7 + "; ");
    	}
    	else if (choice == SCISSORS) {
    		result = PLAYER2_WINS;
    		output.print("\t"+rule6 + "; ");
    	}
    	else if (choice == SPOCK) {
    		result = PLAYER1_WINS;
    		output.print("\t"+rule4 + "; ");
    	}
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
        return result; 
    } // end lizardChoice
    
    /**
     * SpockChoice(int) -> int
     * 
     * method consumes the computer player's choice (ROCK, PAPER, SCISSORS, LIZARD, or SPOCK),
     *   assuming the human player has chosen SPOCK
     * method produces game outcome (PLAYER1_WINS, PLAYER2_WINS, or DRAW)
     * 
     */
    public static int SpockChoice(int choice)
    {
    	int result = 0;
    	if (choice == SPOCK) {
    		result = DRAW; 
    	}
    	else if (choice == ROCK) {	
    		result = PLAYER1_WINS; 
    		output.print("\t"+rule9 + "; ");
    	}
    	else if (choice == PAPER) {	
    		result = PLAYER2_WINS; 
    		output.print("\t"+rule8 + "; ");
    	}
    	else if (choice == SCISSORS) {
    		result = PLAYER1_WINS;
    		output.print("\t"+rule5 + "; ");
    	}
    	else if (choice == LIZARD) {
    		result = PLAYER2_WINS;
    		output.print("\t"+rule4 + "; ");
    	}
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
        return result; 
    } // end SpockChoice
    
    /*
     * playAgain() -> boolean
     * 
     * method prompts user to play again and returns 
     *		false if no
     *	and	true if yes
     */
    public static boolean playAgain() {
    	output.print("Play again (yes/no)? ");
    	String input = "";
    	if (scan.hasNext()) { input = scan.next(); }
    	else { /*throw*/ }
    	
    	boolean result = false;
    	if (input.equals("yes")) { result = true; }
    	else if (input.equals("no")) { result = false; }
    	else { throw new IllegalArgumentException("[ERROR]: Invalid Input"); }
    	
    	return result;
    } // end playAgain
    
    /*
     * printWin(int) ->
     * 
     * consumes the int outcome and outputs who wins
     */
    public static void printWin(int outcome) {
    	if (outcome == PLAYER1_WINS) { 		output.println("Player 1 wins"); }
		else if (outcome == PLAYER2_WINS) {	output.println("Player 2 wins"); }
		else if (outcome == DRAW) {			output.println("\tIt's a draw"); }
		else { throw new IllegalArgumentException("[ERROR]: Invalid Outcome"); }
    	return;
    }
    
    /*
     * p2echo(int) ->
     * 
     * consumes computer choice and echoes it back to the user
     */
    public static void p2echo(int player2) {
    	if (player2 == ROCK) {       	output.println("rock"); }
		else if (player2 == PAPER) { 	output.println("paper"); }
		else if (player2 == SCISSORS) {	output.println("scissors"); }
		else if (player2 == LIZARD) {	output.println("lizard"); }
		else if (player2 == SPOCK) {	output.println("Spock"); }
		else { throw new IllegalArgumentException("[ERROR]: Invalid Player 2 Choice"); }
    	return;
    }
    
    /*
     * textToNumber(String) -> int
     * 
     * consumes user's text input (rock, paper, scissors, lizard, Spock),
     * 	echoes it, and returns the global int value corresponding to the 
     * 	user's choice.
     */
    public static int textToNumber(String input) {
    	int result = 0;
    	String str = "";
    	if (input.equalsIgnoreCase("rock")) {      		
			str = "rock";
			result = ROCK; 
		}
		else if (input.equalsIgnoreCase("paper")) { 		
			str = "paper"; 
			result = PAPER; 
		}
		else if (input.equalsIgnoreCase("scissors")) {	
			str = "scissors";
			result = SCISSORS; 
		}
		else if (input.equalsIgnoreCase("lizard")) {		
			str = "lizard";
			result = LIZARD; 
		}
		else if (input.equalsIgnoreCase("Spock")) {		
			str = "Spock"; 
			result = SPOCK; 
		}
		else { 
			throw new IllegalArgumentException("[ERROR]: Invalid Input");
		}
    	
    	output.println("OK, you chose " + str);
    	
    	return result;
    }
    
    /*
     * compare(int, int) -> int
     * 
     * consumes user choice and computer choice and returns the outcome as an int
     */
    public static int compare(int player1, int player2) {
    	int outcome = 0;
    	if (player1 == ROCK) {			outcome = rockChoice(player2); }
		else if (player1 == PAPER) {	outcome = paperChoice(player2); }
		else if (player1 == SCISSORS) {	outcome = scissorsChoice(player2); }
		else if (player1 == LIZARD) {	outcome = lizardChoice(player2); }
		else if (player1 == SPOCK) {	outcome = SpockChoice(player2); }
		else { 	throw new IllegalArgumentException("[ERROR]: Invalid Input for Player 1"); }
    	return outcome;
    }
} // end class RPSLSAssign
