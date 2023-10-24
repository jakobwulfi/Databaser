package package2;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private double balance;
	private Semaphore sema = new Semaphore(1);
	public void setBalance(double amount, String action) {
		try {
			sema.acquire();
			if (action.equals("c")) {
				balance = balance + amount;
			}
			if (action.equals("d")){
				balance = balance - amount;
			}
			sema.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
	}

	public double getBalance() {
		return balance;
	}
}
