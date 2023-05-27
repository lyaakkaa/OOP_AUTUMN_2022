package Problem4;

import java.util.Objects;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(int num, double interestRate) {
		super(num);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void addInterest() {
		super.deposit(super.getBalance() * this.interestRate / 100);
	}
	
	public String toString() {
		return super.toString() + "\nInterest rate: " + this.interestRate + "\n";
	}	
	@Override
	public boolean equals(Object o) {
		  if (!super.equals(o)) return false;
		  SavingsAccount a = (SavingsAccount)o;
		  return this.interestRate == a.interestRate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(getBalance(), getAccountNumber(), this.interestRate);
	}
}
