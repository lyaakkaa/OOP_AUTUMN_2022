package classes;
/**
 * Intranet System's Employee model. Represents employees who work at the university. This class is abstract and can't be
 * instantiated. Workers have extra field called salary and work experience.
 *
 * @see User
 * @see Admin
 * @see Manager
 * @see Teacher
 * @see Librarian
 */

@SuppressWarnings("serial")
public class Employee extends User{
	/**
	 * Salary of the worker in dollars.
	 */
	private int salary;
	/**
	 * Work experience of the worker in dollars.
	 */
	private double workExperience;
	
	/**
	 * Empty constructor.
	 */
	public Employee(){}
	
	/**
	 *  Constructor for creating inherited instances of {@code Employee} class. This constructor can't be used to 
	 *  create {@code Employee} instance itself, since it is abstract, but can be used in child classes. Given user
	 *  specific fields and Employee's salary.
	 * @param name
	 * @param surname
	 * @param password
	 * @param salary
	 * @param workExperience
	 */
	
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
