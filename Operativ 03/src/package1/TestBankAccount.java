package package1;

public class TestBankAccount {
	private static int turn;
	private static boolean[] flag;

	public static void main(String[] args) {
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		turn = 1;
		BankAccount ba = new BankAccount();
			BankAccountTraad bat1 = new BankAccountTraad(ba);
			BankAccountTraad2 bat2 = new BankAccountTraad2(ba);
			
			bat1.start();
			bat2.start();
			try {
				bat1.join();
				bat2.join();
			} catch (InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		System.out.println(ba.getBalance());
		}

		public static boolean getFlag(int index) {
		return flag[index];
		}
		public static void setFlag(int index, boolean boo) {
		flag[index] = boo;
		}
		public static int getTurn() {
		return turn;
		}
		public static void setTurn(int i) {
		turn = i;
		}
}
