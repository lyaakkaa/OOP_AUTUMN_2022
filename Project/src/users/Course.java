package users;

import java.util.Vector;

import other.File;

public class Course {
	private String name;
	private String code;
	private int credits;
	private Faculty faculty;
	private Vector <Teacher> teachers;
	private int limitOfStudents;
	private int numOfStudents;
	private Course prereq;
	private Boolean isAvailable;
	private Vector <File> courseFiles;
	private Boolean isElective;
	

	{
		setTeachers(new Vector<Teacher>());
		courseFiles = new Vector<File>();
		this.setNumOfStudents(0);
	}
	
	public Course() {}
	

	public Course(String name, String code, int credits, Faculty faculty, Vector<Teacher> teachers, int limitOfStudents, Boolean isElective,
			Vector<Student> students, Course prereq, Vector <File> courseFiles) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.faculty = faculty;
		this.limitOfStudents = limitOfStudents;
		this.setIsElective(isElective);
		this.teachers = teachers;
		this.prereq = prereq;
		this.courseFiles = courseFiles;
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
	
	public void addTeacher(Teacher t) {
		this.teachers.add(t);
	}
	

	
	public void addCourseFiles(File f) {
		this.courseFiles.add(f);
	}


//	@Override
//	public String toString() {
//		return "Course [name=" + name + ", code=" + code + ", credits=" + credits + ", faculty=" + faculty
//				+ ", teachers=" + teachers + ", limitOfStudents=" + limitOfStudents + ", students=" + students
//				+ ", prereq=" + prereq + "]";
//	}
	
	@Override
	public String toString() {
		return name + " (" + faculty + ")";
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

	public Vector <Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Vector <Teacher> teachers) {
		this.teachers = teachers;
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
	

	
	
	
	
	
	

}
