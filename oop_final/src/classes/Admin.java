package classes;

import java.util.Vector;

/**
 * Intranet System's Admin model. Can add, delete, update(Teacher) users.
 * @see User
 * @see Employee
 *  @see AdminView
 */

import enums.TeacherStatus;

@SuppressWarnings("serial")
public class Admin extends Employee{
	/**
	 * Constructor that creates an object of class Admin that inherits from Employee.
	 */
	public Admin() {}
	/**
	 * Constructor that creates an object of class Admin that inherits from Employee.
	 */
	public Admin(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password, salary, workExperience);
	}
	/**
	 * Adds the given user to Database.
	 * @param user
	 */
	public void addUser(User user) {
		Database.getDatabase().addUser(user);
	}
	
	/**
	 * Removes the given user from Database.
	 * @param user
	 */
	public void removeUser(User user) {
		if(Database.getDatabase().getUsers().contains(user)) Database.getDatabase().removeUser(user);
	}
	/**
	 * Update teacher.
	 * @param teacher
	 * @param ts
	 * @param salary
	 */
	public void updateTeacher(Teacher teacher, TeacherStatus ts, int salary) {
		if(Database.getDatabase().getUsers().contains(teacher)) {
			teacher.setSalary(salary);
			teacher.setTeacherStatus(ts);
		}
	}
	/**
	 * Displays all users from Database.
	 * @return vector of users
	 */
	public Vector <User> viewUsers(){
		return Database.getDatabase().getUsers();
	}
	/**
	 * Displays all users actions from Database.
	 * @return vector of String
	 */
	public Vector<String> getTimeOfSignIn (){
		return Database.getDatabase().getTimeOfSignIn();
	}
}
