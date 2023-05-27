package users;


import java.util.*;

import other.Book;
import other.Mark;

public class Student extends User{
	
	private int yearOfStudy;
	private double GPA;
	private String id;
	private Degree degree;
	private Faculty faculty;
	private String speciality;
	private int totalCredits;
	private Vector<Organization> organizations;
	private HashMap<Course, Mark> grades;
	private Vector <Course> courses;
	private Vector <Book> books;
	
	{
		organizations = new Vector<Organization>();
		grades = new HashMap<Course, Mark>();
		courses = new Vector <Course>();
		books = new Vector <Book>();
	}
	
	public Student() {}

	public Student(String name, String surname, String password, int yearOfStudy, String id, Degree degree, Faculty faculty, String speciality) {
		super(name, surname, password);
		this.yearOfStudy = yearOfStudy;
		this.id = id;
		this.degree = degree;
		this.faculty = faculty;
		this.speciality = speciality;
		this.books = null;
	}
	
	

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
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

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Vector<Course> viewCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public Vector<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Vector<Organization> organizations) {
		this.organizations = organizations;
	}

	public HashMap<Course, Mark> viewGrades() {
		return grades;
	}

	public void setGrades(HashMap<Course, Mark> grades) {
		this.grades = grades;
	}
	
	public Vector<Book> getBooks() {
		return books;
	}

	

	

	@Override
	public String toString() {
		return "Student [yearOfStudy=" + yearOfStudy + ", GPA=" + GPA + ", id=" + id + ", degree=" + degree
				+ ", faculty=" + faculty + ", speciality=" + speciality + ", totalCredits=" + totalCredits
				+ ", organizations=" + organizations + ", grades=" + grades + ", courses=" + courses + ", books="
				+ books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(GPA, courses, degree, faculty, grades, id, organizations, speciality,
				totalCredits, yearOfStudy);
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
		return Double.doubleToLongBits(GPA) == Double.doubleToLongBits(other.GPA)
				&& Objects.equals(courses, other.courses) && degree == other.degree && faculty == other.faculty
				&& Objects.equals(grades, other.grades) && Objects.equals(id, other.id)
				&& Objects.equals(organizations, other.organizations) && Objects.equals(speciality, other.speciality)
				&& totalCredits == other.totalCredits && yearOfStudy == other.yearOfStudy;
	}
	
	
	@Override
	public int compareTo(User o) {
		if(super.compareTo(o) == 0) {
			Student s = (Student)o;
	        return id.compareTo(s.id);
		}
		return 0;
	}
	
	public boolean registerToCourse(Course course) {
		Mark m = new Mark();
		if(Database.courses.contains(course) && !this.grades.containsKey(course)) {
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
	
	public void returnBookToLibrarian(Book book, Librarian librarian) {
		if(this.books.contains(book)) {
			this.books.remove(book);
			librarian.addBooks(book);
			System.out.println("book successfully returned");
			
		}
		else {
			System.out.println("The student does not have such a book");
		}
		
	}
		

}
