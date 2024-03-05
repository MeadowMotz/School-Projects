//SavingsAccount.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 2: Bank Account
*
* @author Meadow Motz
* 
* Description: 
* 	Child of BankAccount that can:
* - accrue interest on balance at a certain rate
*/
public class SavingsAccount extends BankAccount {
	private double rate;
// ------------------------
	/*
	 * @param name of account owner
	 * @param account number
	 * @param account balance
	 * 
	 * initializes data fields
	 */
	public SavingsAccount(String name, String num, double bal, double r) {
		super(name, num, bal);
		rate = r;
	} // end main constructor
	
	/*
	 * @param BankAccount object to be copied
	 * 
	 * copy constructor
	 */
	public SavingsAccount(SavingsAccount other) {
		super(other);
		rate = other.getRate();
	} // end copy constructor
// ------------------------
	/*
	 * @return interest rate
	 * 
	 * rate getter
	 */
	public double getRate() {
		return rate;
	} // end getRate
	
	/*
	 * calculates interest = balance * rate,
	 * 	shows it to the user,
	 * 	and adds it to the balance
	 */
	public void postInterest() {
		double interest = getBalance() * rate;
		deposit(interest);
		System.out.printf("$%.2f was added to your account as interest!\n", interest);		
	} // end postInterest
	
	/*
	 * <<override (BankAccount)(Object)>>
	 * @return string representation 
	 * 
	 * gets a string representation of savings account object data fields
	 */
	public String toString() {
		return super.toString() + ", Rate: " + rate;
	} // end toString
	
} // end SavingsAccount.java
