package Problem4;

import java.util.Objects;

public class Account{
	private double balance; //The current balance
	private int accNumber; //The account number
	
	public Account(int num){ 
		balance=0.0;
		accNumber=num;
	}
	
	public void deposit(double sum) {
		this.balance += sum;
	}
	
	public void withdraw(double sum) {
		if(sum > this.balance) {
			System.out.println("You don't have enough money!");
		}
		else {
			this.balance -= sum;
		}	
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public double getAccountNumber(){
		return this.accNumber;
	}
	
	public void transfer(double amount, Account other){
		if(amount > this.balance) {
			System.out.println("You do not have enough money!");
		}
		else {
			this.withdraw(amount);
			other.deposit(amount);
		}
	}

	public String toString() {
		return "\nAccount number: " + this.accNumber + "\nBalance: " + this.balance;
	}

	public final void print(){
		//Don't override this,override the
		// toString method
		System.out.println(toString() + "\n");
	} 	
	
	public boolean equals(Object o) {
		  if (o == this) return true;
		  if (o == null) return false;
		  if (o.getClass() != this.getClass()) return false;
		  Account a = (Account)o;
		  return this.balance == a.balance && this.accNumber == a.accNumber;
    }
	
	
	public int hashCode() {
		return Objects.hash(balance, accNumber);
	}
	
	
}