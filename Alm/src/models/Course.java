package models;




import enums.FacultyName;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Course implements Serializable {
	private String name;
	private String description;
	private String code;
	private FacultyName faculty;
	private int creditsAmount;
	private ArrayList<CourseFile> courseFiles;
	private ArrayList<Lesson> lessons;

	public Course() {}

	public Course(String name, String description, String code, FacultyName faculty,
				  int creditsAmount, ArrayList<Lesson> lessons) {
		this.name = name;
		this.description = description;
		this.code = code;
		this.faculty = faculty;
		this.creditsAmount = creditsAmount;
		this.courseFiles = new ArrayList<>();
		this.lessons = lessons;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}
	
	public FacultyName getFaculty() {
		return faculty;
	}

	public int getCreditsAmount() {
		return creditsAmount;
	}
	
	public ArrayList<CourseFile> getCourseFiles() {
		return courseFiles;
	}
	
	public ArrayList<Lesson> getLessons() {
		return lessons;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void addCourseFile(CourseFile file) {
		courseFiles.add(file);
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Course course = (Course) o;
		return (creditsAmount == course.creditsAmount && Objects.equals(name, course.name) && Objects.equals(code, course.code) && faculty == course.faculty);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, code, faculty, creditsAmount);
	}

	@Override
	public String toString() {
		return name + " (" + faculty + ")";
	}
}