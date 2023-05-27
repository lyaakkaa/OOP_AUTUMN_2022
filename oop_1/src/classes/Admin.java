package classes;

import java.util.Vector;

import enums.TeacherStatus;

@SuppressWarnings("serial")
public class Admin extends Employee{
	public Admin() {}
	
	public Admin(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password, salary, workExperience);
	}
	
	public void addUser(User user) {
		Database.getDatabase().addUser(user);
	}
	
	public void removeUser(User user) {
		Database.getDatabase().removeUser(user);
	}
	
	public void updateTeacher(Teacher teacher, TeacherStatus ts, int salary) {
		if(Database.getDatabase().getUsers().contains(teacher)) {
			teacher.setSalary(salary);
			teacher.setTeacherStatus(ts);
		}
	}
	
	public Vector <User> viewUsers(){
		return Database.getDatabase().getUsers();
	}
	
	public Vector<String> getTimeOfSignIn (){
		return Database.getDatabase().getTimeOfSignIn();
	}
}
