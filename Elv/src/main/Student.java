package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Vector;

/**
* @generated
*/
public class Student extends User {
    
    private Integer yearOfStudy;
    private double GPA;
    private Vector<Course> courses;
    private String id="";
    private int curCredits = 0;
    private Faculties faculty;
    private Degree degree;
    private Transcript transcript;
    private HashMap<Course, Mark> marks;
    final Integer CREDITS_LIMIT = 21;
    public static int numOfStud = 0;
    
    public Student() {
    	courses = new Vector<Course>();
    	marks = new HashMap<Course, Mark>();
    	this.createID();
    }

    public Student(String firstName, String lastName, String email, Integer yearOfStudy, Faculties faculty, Degree degree) {
    	super(firstName, lastName, email);
    	this.yearOfStudy = yearOfStudy;
    	this.faculty = faculty;
    	this.degree = degree;
    	numOfStud++;
    	courses = new Vector<Course>();
    	marks = new HashMap<Course, Mark>();
    	this.createID();
    }
    
    
    
    public Student(Integer yearOfStudy, double gPA, Vector<Course> courses, String id, Faculties faculty, 
    		Degree degree, Transcript transcript, HashMap<Course, Mark> marks) {
		super();
		this.yearOfStudy = yearOfStudy;
		this.GPA = GPA;
		this.courses = courses;
		this.id = id;
		this.faculty = faculty;
		this.degree = degree;
		this.transcript = transcript;
		this.marks = marks;
		numOfStud++;
		courses = new Vector<Course>();
		marks = new HashMap<Course, Mark>();
		this.createID();
	}
    

	public Integer getYearOfStudy() {
        return this.yearOfStudy;
    }
    
    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    
    public double getGPA() {
        return this.GPA;
    }
    
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    public Vector<Course> getCourses() {
        return this.courses;
    }
    
    public int getCurCredits() {
    	return curCredits;
    }
    
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Faculties getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
    
    public Degree getDegree() {
        return this.degree;
    }
    
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    
    public Transcript getTranscript() {
        return this.transcript;
    }
    
    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    
    public HashMap<Course, Mark> getMarks() {
        return this.marks;
    }
    
    public void setMark(Course c, Mark m) {
    	marks.put(c, m);
    }		
    

    //                          Operations                                  
    
    public boolean registerOnCourse(String courseID) throws CreditsOverflow{
    	Course newCourse = null;
    	if (Database.courses.size() >= 1) {
	        for (Course course: Database.courses) {
	        	if (course.getCourseCode().equals(courseID)) {
	        		this.curCredits += course.getCredits();
	        		newCourse = course;
	        	}
	        }
	        if (this.curCredits <= this.CREDITS_LIMIT && newCourse.getIsAvailable()) {
	        	courses.add(newCourse);
	    		marks.put(newCourse, null);
	    		return true;
	        }
	        else {
	            throw new CreditsOverflow(newCourse, CREDITS_LIMIT);
	        }
    	}
    	return false;
    	
    }
    
    public void updateYearOfStudy() {
    	this.yearOfStudy++;
    }
    
    public void createID() {
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	year -= this.yearOfStudy;
    	year++;
    	this.id += String.valueOf(year).substring(2);
    	if (this.degree == Degree.BACHELOR) this.id += "BD";
    	else if (this.degree == Degree.MASTERS) this.id += "MD";
    	else this.id += "PD";
    	StringBuilder builder = new StringBuilder(String.valueOf(numOfStud));
        while (builder.length() < 6) builder.insert(0, "0");
        this.id += builder.toString();
    }
    
    public String showInfo() {
    	String s = "";
    	s += "\nStudent Name: " + this.getFirstName() + " " + this.getLastName() + 
    			"\nYear of study: " + this.yearOfStudy + "\nFaculty: " + this.faculty + "\nGPA: " + this.GPA + "\nID: " + this.id + "\n";
    	return s;
    }
    
    @Override
	public String toString() {
		return "Student [yearOfStudy=" + yearOfStudy + ", GPA=" + GPA + ", id=" + id + ", faculty=" + faculty + "]";
	}

    public Transcript viewTranscript() {
    	return this.transcript;
    }
    
    public String viewCourses() {
    	String s = "";
    	if (this.courses != null) {
	    	for (Course course: this.courses) {
	    		s += course.showInfo() + "\n";
	    	}
    	}
    	return s + "You have " + this.courses.size() + " courses.";
    }
   
    public String viewCourseFiles(Course course) {
    	String s = "";
        for (File file: course.courseFiles) {
        	s += file.showFileInfo() + "\n";
        }
        return s;
    }
    
    public void viewMarks(Course course) {
		System.out.println("Marks of the student " + this.getFirstName() + " " + this.getLastName());
		for (Entry<Course, Mark> entry : this.marks.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
    }

    public String showTeachers() {
        return Database.getTeachers();
    }

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id, yearOfStudy, courses, GPA);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)){
			return true;
		}
    	Student s = (Student) obj;
    	return super.equals(s) && yearOfStudy.equals(s.yearOfStudy) && id.equals(s.id)
    			&& s.GPA == this.GPA;
	}
	
}