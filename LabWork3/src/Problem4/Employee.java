package Problem4;

import java.util.Date;

public class Employee extends Person implements Comparable <Object>, Cloneable {
	private double salary;
	private Date hireDate;
	private String insuranceNumber;
	
	public Employee () {}
	
	public Employee (String name, double salary, Date hireDate, String insuranceNumber) {
		super(name);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void addSalary(double salary) {
		this.salary += salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	@Override
	public String toString() {
		return "My name is " + super.getName() + 
				".My Salary: " + this.getSalary() +
				". My Started time to work: " + this.getHireDate() + 
				". My Insurance number: " + this.getInsuranceNumber();
	}
	@Override
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		Employee e = (Employee)o; 
		return (this.salary == e.salary) && (this.hireDate.equals(e.hireDate)) && this.insuranceNumber.equals(e.insuranceNumber);
	}
	
	@Override
	public int compareTo(Object o) {
		Employee e = (Employee)o;
		if(this.salary > e.salary) return 1;
		else if(this.salary < e.salary) return -1;
		return 0;
	}
	@Override
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned =(Employee)super.clone(); 
		cloned.hireDate = (Date)hireDate.clone();
		return cloned;
	}
}
