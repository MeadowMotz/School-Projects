//CheckingAccount.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 2: Bank Account
*
* @author Meadow Motz
* 
* Description: 
* 	Child of BankAccount that can:
* - withdraw money with a fee
*/
public class CheckingAccount extends BankAccount {
	private final double FEE = 0.15;
// -------------------------
	/*
	 * @param name of account owner
	 * @param account number
	 * @param account balance
	 * 
	 * initializes data fields
	 */
	public CheckingAccount(String name, String num, double bal) {
		super(name, num, bal);
	} // end main constructor
// -------------------------
	/*
	 * @param amount to be withrawn
	 * @return success
	 * 
	 * withdraws given amount + fee from balance
	 */
	public boolean withdraw(double amount) {
		return super.withdraw(amount*(1+FEE));
	} // end withdraw
	
	/*
	 * <<override (BankAccount)(Object)>>
	 * @return string representation 
	 * 
	 * gets a string representation of checking account object data fields
	 */
	public String toString() {
		return super.toString();
	} // end toString
	
} // end CheckingAccount.java
