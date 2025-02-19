//AccountDriver2.java
/**
* CPS 151; Algorithms & Programming II
* 
* Programming Assignment 2: Bank Account
*
* @author Meadow Motz
* 
* Description: 
* 	tester class for BankAccount and its children
*/
public class AccountDriver2 {

	public static void main(String[] args) {
		//create a basic BankAccount
		BankAccount acct01 = new BankAccount("Homer Simpson", "DA-00001", 20.0);
		
		//deposit some money
		acct01.deposit(10000.05);
		
		//withdraw some money
		acct01.withdraw(100.05);
		
		System.out.println(acct01);
		
		//create a second BankAccount using the copy constructor
		BankAccount acct02 = new BankAccount(acct01);
		
		//set a new balance
		acct02.setBalance(132.44);
		
		System.out.println(acct02);
		
		//create a CheckingAccount
		CheckingAccount acct03 = new CheckingAccount("Bart Simpson", "CH-00001", 100.0);
		
		//withdraw some money
		acct03.withdraw(40.0);
		
		System.out.println(acct03);
		
		//create a SavingsAccount
		SavingsAccount acct04 = new SavingsAccount("Marge Simpson", "MO-00001", 100000.00, 0.10);
		
		//deposit some money
		acct04.deposit(20.0);
		
		//add interest to the account
		acct04.postInterest();
		
		System.out.println(acct04);
		
		//Create a second SavingsAccount with the copy constructor
		SavingsAccount acct05 = new SavingsAccount(acct04);
		
		//reset the balance to a new value
		acct05.setBalance(2000.20);
		
		//reset the account number to a new string
		acct05.setAccountNumber("MO-00002");
		
		//add interest to the account for a period of 5 years
		for (int cc=0; cc<5; cc++) acct05.postInterest();
		
		System.out.println(acct05);
	} // end main

} // end AccountDriver2.java
