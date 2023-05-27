package classes;


@SuppressWarnings("serial")
public class Employee extends User{
	
	private int salary;
	private double workExperience;

	public Employee(){}
	
	public Employee(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password);
		this.salary = salary;
		this.workExperience = workExperience;
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
	
	public Object clone() throws CloneNotSupportedException{
		Employee employee = (Employee) super.clone();
		employee.salary = salary;
		employee.workExperience = workExperience;
		return employee;
	}
	
	
	@Override
	public int compareTo(User o) {
		Employee employee = (Employee) o;
		if(super.compareTo(employee) == 0) {
			if(this.workExperience > employee.workExperience) {
				return 1;
			}
			else if(this.workExperience < employee.workExperience) {
				return -1;
			}
			return 0;
		}
		return super.compareTo(employee);
	}
	

}
