package encapsulation;

public class Account {

	private double balance;
	private double interestRate;

	public Account(double balance, double interestRate) {
		if (balance < 0 || interestRate < 0) {
			throw new IllegalArgumentException(
					"Ingen av tallene kan v�re negative!");
		}else {
			this.balance = balance;
			this.interestRate = interestRate;
		}

	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("Rentefoten m� v�re positiv!");

		} else {
			this.interestRate = interestRate;
		}
	}

	public void deposit(double money) {
		if (money <= 0) {
			throw new IllegalArgumentException("Bel�p m� v�re st�rre enn 0!");
		} else {
			this.balance += money;
		}
	}

	public void withdraw(double money) {
		if (money <= 0) {
			throw new IllegalArgumentException(
					"Du kan ikke ta ut et negativt besl�p");
		} else if (money >= balance) {
			throw new IllegalStateException(
					"Du kan ikke ta ut mer penger enn du har p� konto");
		} else {
			this.balance -= money;
		}
	}

}
