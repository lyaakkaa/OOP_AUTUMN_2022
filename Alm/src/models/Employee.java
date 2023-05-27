package models;

/**
 * WSP System's Employee model. Represents the User which works in the University. This class is abstract and can't be
 * instantiated. Workers have extra field called salary.
 *
 * @see User
 * @see Admin
 * @see Manager
 * @see Teacher
 * @see Librarian
 */
@SuppressWarnings("serial")
public abstract class Employee extends User {
	/**
	 * Salary of the worker in tenges.
	 */
	private double salary;

	public Employee() {}

	/**
	 * Constructor for creating inherited instances of {@code Employee} class. This constructor can't be used to
	 * create {@code Employee} instance itself, since it is abstract, but can be used in child classes. Given user
	 * specific fields and Employee's salary.
	 */
	public Employee(String name, String surname, String id, String login, String password, double salary) {

		super(name, surname, id, login, password);
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Object clone() throws CloneNotSupportedException {
		Employee employee = (Employee) super.clone();
		employee.salary = salary;
		return employee;
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