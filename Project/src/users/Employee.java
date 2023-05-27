package users;



import java.util.*;

import other.Message;

public class Employee extends User{
	
	private int salary;
	private double workExperience;

	public Employee(){}
	
	public Employee(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password);
		this.setSalary(salary);
		this.setWorkExperience(workExperience);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(double workExperience) {
		this.workExperience = workExperience;
	}
	
	
	public void sendMessage(Message message, Employee employee) {
		Database.messages.add(message);
	}
	

	public String getMessages() {
		String ans = "";
		int countOfMessages = 0;
		for(Message message : Database.messages) {
			if(message.getReceiver().getLogin().equals(this.getLogin())) {
				countOfMessages++;
				ans += countOfMessages + ") Message from: " + message.getSender().getName() + " " + message.getSender().getSurname()
						+ "\nText: " + message.getTitle();
			}
		}
		if(ans.length() != 0) {
			return ans;
		}
		return "You have no messages";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary, workExperience);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return salary == other.salary
				&& Double.doubleToLongBits(workExperience) == Double.doubleToLongBits(other.workExperience);
	}
	
	@Override
	public String toString() {
		return super.toString() + "with salary: " + this.salary + ", work Exprerience: " + this.workExperience;
	}
	
	
	
	@Override
	public int compareTo(User o) {
		Employee employee = (Employee) o;
		if(super.compareTo(employee) == 0) {
			if(salary == employee.salary) {
				return ((salary > employee.salary) ? 1 : -1);
			}
			return 0;
		}
		return super.compareTo(employee);
	}


	

	

}
