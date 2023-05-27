package models;

import database.Database;
import enums.ManagerType;
import interfaces.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WSP University System's Manager model. Represents the manager who as corresponds controls some kernel processes
 * in the system, such as assigning courses to teachers, creating new courses, approving students registrations,
 * creating statistical reports and more.
 *
 * @see User
 * @see Employee
 */
@SuppressWarnings("serial")
public class Manager extends Employee implements CanAlterStudentData, CanAlterCourseData {
	/**
	 * Represents the type of the manager.
	 */
	private ManagerType type;

	public Manager() {}

	/**
	 * Creates a new manager with corresponding fields of base classes. Also one more specific field {@code type}.
	 */
	public Manager(String name, String surname, String id, String login,
				   String password, double salary, ManagerType type) {
		super(name, surname, id, login, password, salary);
		this.type = type;
	}

	public ManagerType getType() {
		return type;
	}

	/**
	 * Adds the given course to the general set. All dependent class have global access to them.
	 *
	 * @param course course to add
	 */
	public void addCourse(Course course) {
		Database.getInstance().addCourse(course);
	}

	/**
	 * Generates a report about academic performance of students of some faculties.
	 *
	 * @param fileName name of the file to be created
	 * @param quantity total amount of students
	 * @param fit amount of FIT students
	 * @param mcm amount of MCM students
	 * @param bs amount of BS students
	 * @param gpa average GPA
	 * @param performance mark of the performance by given data
	 */
	public void generateReport(String fileName, int quantity, int fit, int mcm, int bs, double gpa, String performance) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
			writer.write(String.format("Total students: %d\n", quantity));
			writer.write(String.format("Total FIT students: %d\n", fit));
			writer.write(String.format("Total SECMC students: %d\n", mcm));
			writer.write(String.format("Total BS students: %d\n", bs));
			writer.write(String.format("Average GPA: %f\n", gpa));
			writer.write(String.format("Academic performance status: %s", performance));
			writer.close();
		} catch(IOException exc) {
			System.out.println("Unable to create a report, " + exc.getMessage());
		}
	}
}