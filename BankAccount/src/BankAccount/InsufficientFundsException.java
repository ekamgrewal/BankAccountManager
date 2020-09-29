package BankAccount;

public class InsufficientFundsException extends Exception{
	
	public InsufficientFundsException(String arg) {
		
		super(arg);
	}

}