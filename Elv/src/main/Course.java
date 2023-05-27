package main;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;


public class Course implements Serializable, Comparable {
    
    private String courseName;
    private Integer credits;
    private String description;
    private String courseCode;
    private boolean isAvailable;
//    private Teacher teacher;
    public  Vector<File> courseFiles;
//    private HashMap<Student, Mark> marks;
    private String prerequisite;
//    public List<File> files;
    
    public Course() {
    	List<Student> students = new ArrayList <Student>();
    	courseFiles = new Vector<File>();
//    	marks = new HashMap<Student, Mark>();
    }
    public Course(String courseName, Integer credits, String courseCode) {
    	this.courseName = courseName;
    	this.credits = credits;
    	this.courseCode = courseCode;
    	List<Student> students = new ArrayList <Student>();
    	courseFiles = new Vector<File>();
//    	marks = new HashMap<Student, Mark>();
    	this.isAvailable = true;
    }

    public Course(String courseName, Integer credits, String description, String courseCode, Boolean isAvailable, Teacher teacher,
    		 Vector<File> courseFiles, HashMap<Student, Mark> marks, String prerequisite) {
    	this.courseName = courseName;
    	this.credits = credits;
    	this.description = description;
    	this.courseCode = courseCode;
    	this.isAvailable = isAvailable;
//    	this.teacher = teacher;
    	this.courseFiles = courseFiles;
//    	this.marks = marks;
    	this.prerequisite = prerequisite;
    	
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public Integer getCredits() {
        return this.credits;
    }
    
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

//    public Teacher getTeacher() {
//        return this.teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//    
//    public HashMap<Student, Mark> getMarks() {
//        return this.marks;
//    }
//
//    public void setMarks(HashMap<Student, Mark> marks) {
//        this.marks = marks;
//    }

    public String getPrerequisite() {
        return this.prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }


    //                          Operations                                  


    public boolean addCourseFile(File courseFile) {
    	if(!courseFiles.contains(courseFile)) {
    		courseFiles.add(courseFile);
    		return true;
    	}
    	return false;
    }

    public boolean removeCourseFile(File courseFile) {
    	if(courseFiles.contains(courseFile)) {
    		courseFiles.remove(courseFile);
    		return true;
    	}
    	return false;
    }

    public boolean hasPrereq() {
    	if(prerequisite != null) {
    		return true;
    	}
    	return false;
    }

    public boolean showPrereq(Course course) {
    	if(hasPrereq()) {
    		System.out.println(prerequisite);
    		return true;
    	}
    	return false;
    }

    public boolean addPrereq(String courseCode) {
    	if(!hasPrereq()) {
    		setPrerequisite(courseCode);
    		return true;
    	}
    	return false;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Course c = (Course) o;
		return this.courseCode.compareTo(c.courseCode);
	}
	
	public String showInfo() {
		return "Course name: " + this.courseName + "\nCourse credits: " + this.credits + "\nCourse prerequisite: " + 
				this.prerequisite + "\nCourse description: " + this.description;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", credits=" + credits + ", description=" + description
				+ ", prerequisite=" + prerequisite + "]";
	}
	
    
}
