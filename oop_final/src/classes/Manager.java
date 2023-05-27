package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import enums.ManagerType;


/**
 * Intranet System's Manager model. The manager inherits from Employee, 
 * it can create new courses, accept a request to register a student's course, 
 * assign a course discipline to a teacher, create a statistical report, and more
 *
 * @see User
 * @see Employee
 */

@SuppressWarnings("serial")
public class Manager extends Employee{
	/**
	 * Represents the type of the manager.
	 */
	private ManagerType managerType;
	
	public Manager() {
		super();
	}
	/**
	 * Creates a new manager.Has a constructor from inheritance. Also one more specific field {@code type}.
	 */
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
	
	/**
	 * Adds the given course to the Database.
	 * @param cours
	 */
	public void addCourse(Course course) {
		Database.getDatabase().addCourses(course);
	}
	/**
	 * Deletes the given course from the Database.
	 * @param cours
	 */
	public void deleteCourse(Course course) {
		if(Database.getDatabase().getCourses().contains(course)) {
			Database.getDatabase().deleteCourses(course);
		}
	}
	/**
	 * Makes a statistical report at a certain rate. Displays the lowest and highest gpa, 
	 * the number of reattached students.
	 * @param course
	 * @param numOfStudents
	 * @param maxGPA
	 * @param minGPA
	 * @param retakedStudents
	 */
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
