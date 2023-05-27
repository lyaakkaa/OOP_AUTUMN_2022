package Problem4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		
		
		Account a = new Account(1);
		Account b = new SavingsAccount(2, 5);
		Account c = new CheckingAccount(3);
		
		a.deposit(100);
		b.deposit(100);
		c.deposit(100); //1
		c.withdraw(10); //2
		//c.transfer(10, b); //3
		c.withdraw(10);
		c.deposit(50); //4
		
		bank.open(a);
		bank.open(b);
		bank.open(c);
		
		bank.update();
		
		
		System.out.print(bank);
	}

}
