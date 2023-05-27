package Problem4;
import java.util.Vector;

public class Bank {
	
	private Vector <Account> accounts;
	
	{
		accounts = new Vector<Account>();
	}
	
	public void update() {
		for(Account account : accounts) {
			if(account instanceof SavingsAccount) {
				((SavingsAccount)account).addInterest();
			}
			else if(account instanceof CheckingAccount) {
				((CheckingAccount)account).deductFee();
			}
		}
	}
	
	public void open(Account a) {
		accounts.add(a);
		System.out.println("Account opened successfully!");
	}
	
	public void close(Account a) {
		accounts.remove(a);
		System.out.println("Account closed successfully!");
	}
	
	public String toString() {
		String s = "";
		for(Account account : accounts) {
			s +=  account.toString() + "\n";
		}
		return s;
	}
	
}
