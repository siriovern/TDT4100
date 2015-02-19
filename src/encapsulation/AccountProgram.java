package encapsulation;

public class AccountProgram {
	
	public static void main (String[] args) {
		Account account = new Account(0, 0);
		
		account.setInterestRate(5);
		account.deposit(-150);
		account.withdraw(200);
		
		
		System.out.println("Kontobeløp: " +account.getBalance());
	}

}
