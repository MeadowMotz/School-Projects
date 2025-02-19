//BankAccount.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 2: Bank Account
*
* @author Meadow Motz
* 
* Description: 
* 	Models a bank account that can:
* - deposit money
* - withdraw money
* - display its information
* 	and can be identified with:
* - money balance
* - account owner
* - account number/ID
*/
public class BankAccount {
	private double balance;
	private String owner;
	private String accountNumber;
	protected static int numberOfAccounts;
// -----------------------------------
	/*
	 * @param name of account owner
	 * @param account number
	 * @param account balance
	 * 
	 * initializes data fields
	 */
	public BankAccount(String name, String num, double bal) {
		owner = name;
		setAccountNumber(num);
		setBalance(bal);
		numberOfAccounts++;
	} // end main constructor
	
	/*
	 * @param BankAccount object to be copied
	 * 
	 * copy constructor
	 */
	public BankAccount(BankAccount other) {
		setBalance(other.getBalance());
		owner = other.getOwner();
		setAccountNumber(other.getAccountNumber());
		numberOfAccounts++;
	} // end copy constructor
	
// --------------------------------
	/*
	 * @param amount to be deposited
	 * 
	 * adds deposit amount to account balance
	 */
	public void deposit(double amount) {
		if (amount>0) balance+= amount;
	} // end deposit
	
	/*
	 * @param amount to be withrawn
	 * @return success
	 * 
	 * withdraws given amount from balance
	 */
	public boolean withdraw(double amount) {
		if (amount<=balance) {
			balance -= amount;
			return true; }
		else return false;
	} // end withdraw
	
	/*
	 * @return account balance
	 * 
	 * balance getter
	 */
	public double getBalance() {
		return balance;
	} // end getBalance
	
	/*
	 * @return account owner name
	 * 
	 * owner getter
	 */
	public String getOwner() {
		return owner;
	} // end getOwner
	
	/*
	 * @return account number
	 * 
	 * accountNumber getter
	 */
	public String getAccountNumber() {
		return accountNumber;
	} // end getAccountNumber
	
	/*
	 * @param new balance
	 * 
	 * balance setter
	 */
	public void setBalance(double amount) {
		if (amount >= 0) balance = amount;
	} // end setBalance
	
	/*
	 * @param account number
	 * 
	 * accountNumber setter
	 */
	public void setAccountNumber(String acc) {
		if (acc.length()==8 
			&& Character.isLetter(acc.charAt(0))
			&& acc.substring(2,3).equals("-"))
				accountNumber = acc;
	} // end setAccountNumber
	
	/*
	 * <<override (Object)>>
	 * @return string representation 
	 * 
	 * gets a string representation of bank account object data fields
	 */
	public String toString() {
		return "Account number: " + accountNumber
			+ ", Account owner: " + owner
			+ ", Balance: " + String.format("%.2f", balance);
	} // end toString
	
	/*
	 * @param amount to be converted
	 * @return converted amount
	 * 
	 * converts USD to GBP
	 */
	public double convertToBritishPound(double amount) {
		return amount * 0.79;
	} // end convertToBritishPound
	
} // end BankAccount.java
