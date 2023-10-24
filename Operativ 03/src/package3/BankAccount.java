package package3;

public class BankAccount {

	private double balance;

	public synchronized void setBalance(double amount, String action) {
		if (action.equals("c")) {
			balance = balance + amount;
		}
		if (action.equals("d")){
			balance = balance - amount;
		}
		
	}

	public double getBalance() {
		return balance;
	}
}
