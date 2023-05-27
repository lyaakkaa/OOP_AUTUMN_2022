package models;

import java.io.Serializable;
import java.util.*;

/**
 * Represents student's transcript. Transcript is a document with the name of the courses taken and grades received.
 * Contains courses according to the time period of the certain course and at what time the course was taken.
 *
 * @see Student
 * @see Course
 * @see Mark
 */
@SuppressWarnings("serial")
public class Transcript implements Serializable {
	/**
	 * Represents the time period and set of courses for this time period, each course is associated with a mark value.
	 * {@code TreeMap<>} is used for convenient sorted order of the courses by their time period.
	 */
	private TreeMap<Period, HashMap<Course, Mark>> marksOfCourses;

	/**
	 * Overall GPA calculated among all courses of a student.
	 */
	private double overallGpa;

	/**
	 * Creates the empty transcript.
	 */
	public Transcript() {
		marksOfCourses = new TreeMap<>();
		overallGpa = 0;
	}

	/**
	 * Derives the overall GPA of the student traversing each course and its course GPA.
	 *
	 * @return overall GPA
	 */
	public double determineOverallGpa() {
		int credits = 0;
		double products = 0;
		for(Map.Entry<Period, HashMap<Course, Mark>> entry : marksOfCourses.entrySet()) {
			for(Map.Entry<Course, Mark> courseMark : entry.getValue().entrySet()) {
				credits += courseMark.getKey().getCreditsAmount();
				products += (courseMark.getKey().getCreditsAmount() * courseMark.getValue().getGpa());
			}
		}
		overallGpa = (products / credits);

		return overallGpa;
	}

	public double getOverallGpa() {
		return overallGpa;
	}

	/**
	 * Retrieves the transcript.
	 *
	 * @return tree map transcript
	 */
	public TreeMap<Period, HashMap<Course, Mark>> getMarks() {
		return marksOfCourses;
	}

	/**
	 * Gets all courses independent of time period.
	 *
	 * @return list of all student courses
	 */
	public ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		for(Map.Entry<Period, HashMap<Course, Mark>> entry : marksOfCourses.entrySet()) {
			courses.addAll(entry.getValue().keySet());
		}
		return courses;
	}

	/**
	 * Add the given file to files of the given course.
	 *
	 * @param course course to which the file to add
	 * @param file addend file
	 */
	public void addCourseFile(Course course, CourseFile file) {
		for(Map.Entry<Period, HashMap<Course, Mark>> entry : marksOfCourses.entrySet()) {
			for(Map.Entry<Course, Mark> courseMark : entry.getValue().entrySet()) {
				if(courseMark.getKey().equals(course)) {
					courseMark.getKey().addCourseFile(file);
					return;
				}
			}
		}
	}
}