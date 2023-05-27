package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import enums.ManagerType;

@SuppressWarnings("serial")
public class Manager extends Employee{
	
	private ManagerType managerType;
	
	public Manager() {
		super();
	}
	
	public Manager(String name, String surname, String password, int salary, double workExperience, ManagerType managerType) {
		super(name, surname, password, salary, workExperience);
		this.setManagerType(managerType);
	}

	public ManagerType getManagerType() {
		return managerType;
	}

	public void setManagerType(ManagerType managerType) {
		this.managerType = managerType;
	}
	
	public void addCourse(Course course) {
		Database.getDatabase().addCourses(course);
	}
	
	public void deleteCourse(Course course) {
		if(Database.getDatabase().getCourses().contains(course)) {
			Database.getDatabase().deleteCourses(course);
		}
	}
	
	public void getReport(Course course, int numOfStudents, double maxGPA, double minGPA, int retakedStudents ){
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("statistical_report.txt", true));
			pw.write("Course name: " + course.getName() + "\n");
			pw.write("Total amount of students: " + numOfStudents + "\n");
			pw.write("Maximum GPA: " + maxGPA + "\n");
			pw.write("Minimum GPA: " + minGPA + "\n");
			pw.write("Number of retaked students: " + retakedStudents + "\n");
			pw.close();
		 }catch(IOException exc) {
			System.out.println("Error " + exc.getMessage());
		}
		
	}

}
