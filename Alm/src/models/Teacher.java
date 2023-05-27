package models;

import enums.TeacherTitle;
import interfaces.CanAlterCourseData;
import java.util.*;

/**
 * WSP University System's Teacher model. Represents the instructor of the certain course or courses.
 * Has {@code User} and {@code Employee} fields, leading with self specific fields such as title and
 * experience in teaching. Courses have students and teacher must evaluate their skills.
 *
 * @see User
 * @see Employee
 * @see Student
 * @see Course
 */
@SuppressWarnings("serial")
public class Teacher extends Employee implements CanAlterCourseData {
	/**
	 * Represents the status of the teacher in teaching.
	 */
	private TeacherTitle title;
	
	/**
	 * Indicates the experience of the teacher in teaching.
	 */
	private int experience;
	
	/**
	 * List of courses of teacher. Teacher can't manage courses himself, it's done by a manager.
	 */
	private ArrayList<Course> courses;
	
	/**
	 * Indicator of how good the teacher is according to students, not objective indicator.
	 */
	private double rating;

	private int ratedBy;

	public Teacher() {}

	/**
	 * Creates a new teacher with {@code User} and {@code Employee} fields, with specific {@code Teacher} fields.
	 */
	public Teacher(String name, String surname, String id, String login, String password, double salary,
				   TeacherTitle title, int experience, ArrayList<Course> courses, double rating) {

		super(name, surname, id, login, password, salary);
		this.title = title;
		this.experience = experience;
		this.courses = courses;
		this.rating = rating;
		this.ratedBy = 0;
	}
	
	public TeacherTitle getTitle() {
		return title;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public double getRating() {
		return rating;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}

	/**
	 * Applies the rating to the teacher. Average value is calculated.
	 *
	 * @param rating student's rating to the teacher
	 */
	public void setRating(double rating) {
		ratedBy++;
		this.rating += (rating - this.rating) / ratedBy;
	}

	/**
	 * Puts the mark by applying the corresponding fields.
	 *
	 * @param marks string array of marks
	 * @param mark mark class that to be altered
	 */
	public void putMark(String[] marks, Mark mark) {
		mark.setMarks(
			Double.parseDouble(marks[0]),
			Double.parseDouble(marks[1]),
			Double.parseDouble(marks[2])
		);
	}

	/**
	 * String representation of the teacher.
	 *
	 * @return the teacher as a string
	 */
	@Override
	public String toString() {
		return super.toString() + ". Title: " + title + ". Experience: " + experience + " years";
	}
}