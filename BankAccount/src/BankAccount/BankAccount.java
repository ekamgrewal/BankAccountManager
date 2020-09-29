package BankAccount;

import java.util.Scanner;

public class BankAccount {
	
	String customerId;
	String customerName;
	double balance;
	double previousTransaction;
	
	public BankAccount(String customerId, String customerName, int balance){
		
		this.customerId=customerId;
		this.balance=balance;
		this.customerName=customerName;
	
	
	}
	 public void deposit(double amount){
		 
		 if(amount>0) {
			 
			 balance+=amount;
			 previousTransaction=amount;
					 
		 }
		 
	 }
	 
	 public void withdraw(double amount) throws InsufficientFundsException  {
		 
		 double negativeAmount= -amount;
		
		 
		 if(negativeAmount>balance) {
			 
			 throw new InsufficientFundsException("Insufficient funds in the account.");
		 }
		 else if (amount<0) {
			 
			 balance+=amount;
			 previousTransaction=amount;
		 }
		 
		 
	 }
	 
	 public void getPreviousTransaction(){
		 
		 if(previousTransaction>0) {
			 
			 System.out.println("deposited: $"+previousTransaction);
			 
		 }
		 else if(previousTransaction<0) {
			 
			 System.out.println("withdrawn: $"+previousTransaction);
			 
		 }
		 else {
			 
			 System.out.println("No transaction occured");
			 
		 }
		 
		 
	 }
	 
	 public void showMenu() throws InsufficientFundsException{
		 
		 char option='\0';
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Welcome "+customerName);
		 System.out.println("Your id is: "+customerId);
		 
		 
		 do {
			
			 System.out.println("\n");
			 System.out.println("A. Check Balance");
			 System.out.println("B. Deposit");
			 System.out.println("C. Withdraw");
			 System.out.println("D. Previous Transaction");
			 System.out.println("E. Exit");
			 System.out.println("====================================================");
			 System.out.println("Enter an option");
			 System.out.println("====================================================");
			 option= sc.next().charAt(0);
			 System.out.println("\n");
			 
			 switch(option) {
			 
			 case 'A':
				 System.out.println("------------------------------");
				 System.out.println("Balance= "+balance);
				 System.out.println("------------------------------");
				 System.out.println("\n");
				 break;
			 
			 case 'B':
				 System.out.println("------------------------------");
				 System.out.println("Enter an amount to deposit: ");
				 System.out.println("------------------------------");
				 double amount= sc.nextDouble();
				 if (amount>0) {
					 
					 deposit(amount);
					 System.out.println("Amount successfully deposited: $"+ amount);
					 System.out.println("Current Balance: $"+balance);
					 System.out.println("\n");
					 
					 
				 }
				 else {
					 System.out.println("Transaction could not be completed");
					 System.out.println("\n");
				 }
				 break;
				 
			 case 'C':
				 System.out.println("------------------------------");
				 System.out.println("Enter an amount to be withdrawn: ");
				 System.out.println("------------------------------");
				 double amount2= -(sc.nextDouble());
				 double receiptAmount= (-1*amount2);
				 if(receiptAmount>balance) {
					 withdraw(amount2);
				 }
				 else if (amount2<0) {
					 
					 withdraw(amount2);
					 System.out.println("Amount successfully withdrawn: $"+ receiptAmount);
					 System.out.println("Current Balance: $"+balance);
					 System.out.println("\n");
					 
				 }
				 else {
					 System.out.println("Transaction could not be completed");
					 System.out.println("\n");
				 }
				 break;
				 
			 case 'D':
				 
				 System.out.println("------------------------------");
				 getPreviousTransaction();
				 System.out.println("------------------------------");
				 System.out.println("\n");
			
			 case 'E':
				 System.out.println("=================================");
				 break;
				 
			default:
				
				System.out.println("Invalid option! Please try again.");
				break; 
			 }
			 
			 
		 }
		 while(option!='E');
		 
		 System.out.println("Thank You for using our services"); 
			 
			 
		 }
	 public static void main(String[] args) throws InsufficientFundsException {
				 
		 BankAccount obj= new BankAccount("BZ007","ABC",25);
		 obj.showMenu();
	 }
	 
	 
	
	



	

}
