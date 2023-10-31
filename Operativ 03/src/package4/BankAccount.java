package package4;

public class BankAccount {
	private double balance;

	/**
	 * Synchronized method that adds the specified amount to the accounts balance.
	 * @param amount to be added.
	 */
	public synchronized void credit(double amount) {
		balance = balance + amount;
		System.out.println("Kredit: " + balance);
		notify();
	}
	/**
	 * Synchronized method that detracts the specified amount from the accounts balance.
	 * @param amount to be detracted.
	 */
	public synchronized void debit(double amount) {
		if (balance - amount >= 0) {
			balance = balance - amount;
			System.out.println("Debit: " + balance);
		} else {
			try {
				wait();
				System.out.println("Venter...");
				if (balance - amount >= 0) {
					balance = balance - amount;
					System.out.println("Debit: " + balance);
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public double getBalance() {
		return balance;
	}
}
