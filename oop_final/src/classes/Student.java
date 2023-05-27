package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import enums.*;

/**
 * Intranet System's Student model. Represents the student of University.
 * Has his own year of study, degree, faculty and specialty to which he belongs. Can study courses, and
 * {@code Mark} represents his academic performance, which is expressed by attestation points and GPA.
 * This class posses the functionality of viewing news and rating teachers of belonging courses.
 *
 * @see User
 * @see Teacher
 * @see Course
 * @see Mark
 */

@SuppressWarnings("serial")

public class Student extends User {
	/**
	 * Represents student year of study.
	 */
	private int yearOfStudy;
	/**
	 * Represents id of student.
	 */
	private String id;
	/**
	 * Represents student's academic degree.
	 */
	private Degree degree;
	/**
	 * GPA (Grade Point Average).
	 */
	private Double GPA;
	/**
	 * The faculty to which student belongs.
	 */
	private Faculty faculty;
	/**
	 * The specialty of student, unique and belongs to only one faculty.
	 */
	private String speciality;
	/**
	 * Student's transcript. Represents the academic performance.
	 */
	private Transcript transcript;
	/**
	 * Student's total credits.
	 */
	private int totalCredits;
	/**
	 * Organizations in which the student participates.
	 */
	private Vector<Organization> organizations;
	/**
	 * Courses and student grades.
	 */
	private HashMap<Course, Mark> grades;
	/**
	 * Student's books.
	 */
	private Vector <Book> books;
	
	
	public Student() {}
	/**
	 * Creates a student with base user fields and specific student field such as year of study,
	 * degree, etc.
	 */
	public Student(String name, String surname, String password, int yearOfStudy, String id, Degree degree, Faculty faculty, String speciality, Transcript transcript) {
		super(name, surname, password);
		this.setYearOfStudy(yearOfStudy);
		this.setId(id);
		this.setDegree(degree);
		this.setFaculty(faculty);
		this.setSpeciality(speciality);
		this.totalCredits = 0;
		this.books = new Vector <Book>();
		setOrganizations(new Vector<Organization>());
		setGrades(new HashMap<Course, Mark>());
		this.transcript = transcript;
		
	}
	
	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	/**
	 * Calculate the GPA according to Transcript data and returns it.
	 *
	 * @return
	 */

	public double calculateGPA() {
		double sum = 0;
		if(getGrades().size() != 0) {
			for(Map.Entry<Course, Mark> item :getGrades().entrySet()) {
				sum += item.getKey().getCredits() * item.getValue().getGpa();
			}
			return (double) (sum / getTotalCredits());	
		}
		return 0.0;
	}

	public void setGPA(Double gPA) {
		GPA = gPA;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Transcript getTranscript() {
		return this.transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public int getTotalCredits() {
		for(Map.Entry<Course, Mark> item : this.grades.entrySet()){
			   this.totalCredits += item.getKey().getCredits();   
	    }
		return this.totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Vector<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Vector<Organization> organizations) {
		this.organizations = organizations;
	}

	public HashMap<Course, Mark> getGrades() {
		return grades;
	}

	public void setGrades(HashMap<Course, Mark> grades) {
		this.grades = grades;
	}

	public Vector <Book> getBooks() {
		return books;
	}

	public void addBooks(Book book) {
		this.books.add(book);
	}
	/**
	 * Sets the rating of a specified teacher.
	 * @param teacher teacher who to rate
	 * @param rating 
	 */
	public void rateTeacher(Teacher teacher, double rating) {
		teacher.setRate(rating);
	}
	
	public boolean dropCourse(Course course) {
		if(this.grades.containsKey(course)) {
			this.grades.remove(course);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [yearOfStudy=" + yearOfStudy + ", id=" + id + ", degree=" + degree + ", GPA=" + GPA
				+ ", faculty=" + faculty + ", speciality=" + speciality + ", transcript=" + transcript
				+ ", totalCredits=" + totalCredits + ", organizations=" + organizations + ", grades=" + grades
				+ ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(GPA, books, degree, faculty, grades, id, organizations, speciality,
				totalCredits, transcript, yearOfStudy);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(GPA, other.GPA) && Objects.equals(books, other.books) && degree == other.degree
				&& faculty == other.faculty && Objects.equals(grades, other.grades) && Objects.equals(id, other.id)
				&& Objects.equals(organizations, other.organizations) && Objects.equals(speciality, other.speciality)
				&& totalCredits == other.totalCredits && Objects.equals(transcript, other.transcript)
				&& yearOfStudy == other.yearOfStudy;
	}
	

}
