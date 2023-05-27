package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import enums.*;

/**
 * 
 * @author leila
 *
 */

@SuppressWarnings("serial")

public class Student extends User {

	private int yearOfStudy;
	private String id;
	private Degree degree;
	private Double GPA;
	private Faculty faculty;
	private String speciality;
	private Transcript transcript;
	private int totalCredits;
	private Vector<Organization> organizations;
	private HashMap<Course, Mark> grades;
	private Vector <Book> books;
	
	
	public Student() {}

	public Student(String name, String surname, String password, int yearOfStudy, String id, Degree degree, Faculty faculty, String speciality) {
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

	public Double getGPA() {
		this.GPA = this.transcript.calculateGPA();
		return this.GPA;
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
		if(this.transcript == null) {
			Transcript t = new Transcript(this);
			return t;
		}
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
	
	public void rateTeacher(Teacher teacher, double rating) {
		teacher.setRate(rating);
	}
	
//	public void returnBookToLibrarian(Book book, Librarian librarian) {
//		if(this.books.contains(book)) {
//			this.books.remove(book);
//			librarian.addBooks(book);
//			System.out.println("book successfully returned");
//		}
//		else {
//			System.out.println("The student does not have such a book");
//		}
//	}
	
	public boolean registerToCourse(Course course) {
		Mark m = new Mark();
		if(Database.getDatabase().getCourses().contains(course) && !this.grades.containsKey(course)) {
			if(course.getPrereq() == null || this.grades.containsKey(course.getPrereq()) && this.grades.get(course.getPrereq()).getTotal() > 50) {
				if(course.getFaculty() == this.faculty) {
					course.setLimitOfStudents(course.getLimitOfStudents() + 1);
					this.grades.put(course, m);
				    return true;
				}
				else {
		 			if(course.getIsElective() == true) {
						course.setNumOfStudents(course.getNumOfStudents() + 1);
						this.grades.put(course, m);
						return true;
					}
					return false;
				}
			}
		}
		return false;
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
