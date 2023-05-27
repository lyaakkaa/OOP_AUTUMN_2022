package users;

import other.News;

public class Admin extends Employee{
	
	
	public Admin() {}
	
	
	public Admin(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password, salary,workExperience);
	}
	
	
	public void addUserToSystem(User u) {
		Database.getDatabase().addUser(u);
	}
	
	public void deleteuser(User u) {
		if(Database.users.contains(u)) {
			Database.getDatabase().deleteUser(u);
		}
	}
	
	

	
	
	
	public void addStudentToSystem(String name, String surname, String password, int yearOfStudy, String id, Degree degree, Faculty faculty, String speciality) {
		Student s = new Student(name, surname, password, yearOfStudy, id, degree, faculty, speciality);
		Database.users.add(s);
	}
	
	public void addManagerToSystem(String name, String surname, String password, int salary, double workExperience) {
		
	}
	
	public void addTeacherToSystem(String name, String surname, String password, int salary, double workExperience, Faculty faculty, double rate, TeacherStatus teacherStatus) {
		Teacher t = new Teacher(name, surname, password, salary, workExperience, faculty, rate, teacherStatus);
		Database.users.add(t);
	}
	
	public void addLibrarianToSystem(String name, String surname, String password, int salary, double workExperience) {
		Librarian l = new Librarian(name, surname, password, salary, workExperience);
		Database.users.add(l);
	}
	
	
	
	public void createNewsInTheSystem(String title, String text) {
		News n = new News(title, text);
		Database.news.add(n);
	}
	
	public void createCourseInTheSystem(String name, String code, int credits, Faculty faculty, int limitOfStudents,  Boolean isElective, Course prereq) {
		Course course = new Course(name, code, credits, faculty, limitOfStudents, isElective, prereq);
		Database.courses.add(course);
	}

	
	

	 @Override
	 public String toString() {
	    return "Admin: " +  super.toString();
	 }


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	

	
	 
	 
	 
	
}
