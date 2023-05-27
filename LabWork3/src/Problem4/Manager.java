package Problem4;

import java.util.*;

public class Manager extends Employee implements Comparable<Object>, Cloneable{
	private Vector <Employee> employees;
	private double bonus;
	
	{
		employees = new Vector <Employee>();
	}
	
	public Manager() {};
	
	public Manager(String name, double salary, Date hireDate, String insuranceNumber) {
		super(name, salary, hireDate, insuranceNumber);
	}

	public double getBonus() {
		return this.bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void addBonus(double bonus) {
		this.bonus += bonus;
	}
	
	public void calculateBonus() {
		double res = 0;
		for(Employee e : employees) {
			res += e.getSalary() * 0.5;
		}
		this.bonus = res / employees.size();
	}
	
	public void getEmployees() {
		System.out.println("Emoloyees: ");
		for(Employee e : employees) {
			System.out.println(e);
		}
	}

	public void setEmployees(Vector <Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}
	
	@Override
	public String toString() {
		return super.toString() + ".My bonus: "+ bonus;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Manager m = (Manager)o;
		return this.bonus == m.bonus;
	} 
	@Override
	public int compareTo(Object o) {
		Manager m = (Manager)o;
		if(super.compareTo(m) == 0) {
			if(this.bonus > m.bonus) return 1;
			else if(this.bonus < m.bonus) return -1;
			return 0;
		}
		return super.compareTo(m);
	}
	
	@Override
	public Manager clone() throws CloneNotSupportedException{
		Manager cloned =(Manager)super.clone(); 
		return cloned;
	}
}
