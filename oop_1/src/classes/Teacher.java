package classes;

import java.util.Objects;
import java.util.Vector;

import enums.*;


@SuppressWarnings("serial")
public class Teacher extends Employee{
	private Faculty faculty;
	private double rate;
	private TeacherStatus teacherStatus;
	private Vector <Course> courses;
	
	{
		setCourses(new Vector <Course>());
	}
	
	public Teacher() {}

	
	public Teacher(String name, String surname, String password, int salary, double workExperience, Faculty faculty, double rate, TeacherStatus teacherStatus) {
		super(name, surname, password, salary, workExperience);
		this.setFaculty(faculty);
		this.setRate(rate);
		this.setTeacherStatus(teacherStatus);
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public TeacherStatus getTeacherStatus() {
		return teacherStatus;
	}


	public void setTeacherStatus(TeacherStatus teacherStatus) {
		this.teacherStatus = teacherStatus;
	}


	public Vector <Course> getCourses() {
		return courses;
	}


	public void setCourses(Vector <Course> courses) {
		this.courses = courses;
	}
	
	public String putMarks(Student student, Course course, double points, TimeOfAttestation timeOfAttestation) {
		Mark mark = new Mark(points, timeOfAttestation);
		if(this.courses.contains(course)) {
			if(student.getGrades().containsKey(course)) {
				if(student.getGrades().get(course).getTotal() == 0) {
					student.getGrades().put(course, mark);
				}
				else {
					student.getGrades().put(course, student.getGrades().get(course).addMarks(mark));
				}
				
				return "You put mark to " + student.getName();
			}
		}
		return "Error";
	}


	@Override
	public String toString() {
		return "Teacher [faculty=" + faculty + ", rate=" + rate + ", teacherStatus=" + teacherStatus + ", courses="
				+ courses + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(courses, faculty, rate, teacherStatus);
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
		Teacher other = (Teacher) obj;
		return Objects.equals(courses, other.courses) && faculty == other.faculty
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& teacherStatus == other.teacherStatus;
	}
	
	
	public Object clone() throws CloneNotSupportedException{
		Teacher t = (Teacher) super.clone();
		t.courses = this.courses;
		t.faculty = this.faculty;
		t.rate = this.rate;
		t.teacherStatus = this.teacherStatus;
		return t;
	}
	
	
	

}
