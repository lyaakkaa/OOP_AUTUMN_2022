package classes;


import java.util.Objects;
import java.util.Vector;

import enums.Faculty;

public class Course {
	private String name;
	private String code;
	private int credits;
	private Faculty faculty;
	private int limitOfStudents;
	private int numOfStudents;
	private Course prereq;
	private Boolean isAvailable;
	private Vector <File> courseFiles;
	private Boolean isElective;
	private Vector <Lesson> lessons;
	

	{
		courseFiles = new Vector<File>();
		this.setNumOfStudents(0);
	}
	
	public Course() {}
	

	public Course(String name, String code, int credits, Faculty faculty, int limitOfStudents, Boolean isElective,
			Vector<Student> students, Course prereq, Vector <File> courseFiles, Vector <Lesson> lessons) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.faculty = faculty;
		this.limitOfStudents = limitOfStudents;
		this.setIsElective(isElective);
		this.prereq = prereq;
		this.courseFiles = courseFiles;
		this.setLessons(lessons);
	}
	
	public Course(String name, String code, int credits, Faculty faculty, int limitOfStudents,  Boolean isElective, Course prereq) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.faculty = faculty;
		this.limitOfStudents = limitOfStudents;
		this.setIsElective(isElective);
		this.prereq = prereq;
	}
	
	public void addCourseFiles(File f) {
		this.courseFiles.add(f);
	}

	@Override
	public String toString() {
		return "Course: "+ name + " (" + faculty + ")";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getLimitOfStudents() {
		return limitOfStudents;
	}

	public void setLimitOfStudents(int limitOfStudents) {
		this.limitOfStudents = limitOfStudents;
	}

	public Course getPrereq() {
		return prereq;
	}

	public void setPrereq(Course prereq) {
		this.prereq = prereq;
	}


	public Boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public Vector <File> getCourseFiles() {
		return courseFiles;
	}


	public void setCourseFiles(Vector <File> courseFiles) {
		this.courseFiles = courseFiles;
	}


	public Boolean getIsElective() {
		return isElective;
	}


	public void setIsElective(Boolean isElective) {
		this.isElective = isElective;
	}


	public int getNumOfStudents() {
		return numOfStudents;
	}


	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}


	public Vector <Lesson> getLessons() {
		return lessons;
	}


	public void setLessons(Vector <Lesson> lessons) {
		this.lessons = lessons;
	}


	@Override
	public int hashCode() {
		return Objects.hash(code, courseFiles, credits, faculty, isAvailable, isElective, lessons, limitOfStudents,
				name, numOfStudents, prereq);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(code, other.code) && Objects.equals(courseFiles, other.courseFiles)
				&& credits == other.credits && faculty == other.faculty
				&& Objects.equals(isAvailable, other.isAvailable) && Objects.equals(isElective, other.isElective)
				&& Objects.equals(lessons, other.lessons) && limitOfStudents == other.limitOfStudents
				&& Objects.equals(name, other.name) && numOfStudents == other.numOfStudents
				&& Objects.equals(prereq, other.prereq);
	}
	
	
	

}
