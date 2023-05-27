package users;

import java.util.Objects;
import java.util.Vector;

import other.*;

public class Teacher extends Employee{
	
	private Faculty faculty;
	private double rate;
	private TeacherStatus teacherStatus;
	private Vector <Course> courses;
	
	{
		courses = new Vector <Course>();
	}
	
	public Teacher() {
		super();
	}

	
	public Teacher(String name, String surname, String password, int salary, double workExperience, Faculty faculty, double rate, TeacherStatus teacherStatus) {
		super(name, surname, password, salary, workExperience);
		this.faculty = faculty;
		this.rate = rate;
		this.teacherStatus = teacherStatus;
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

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
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

	
	public String putMarks(Student student, Course course, double points, TimeOfAttestation timeOfAttestation) {
		Mark mark = new Mark(points, timeOfAttestation);
		if(this.courses.contains(course)) {
			if(student.viewGrades().containsKey(course)) {
				if(student.viewGrades().get(course).getTotal() == 0) {
					student.viewGrades().put(course, mark);
				}
				else {
					if(timeOfAttestation == TimeOfAttestation.ATTESTATION1) {
//						mark.setAttestation1(student.viewGrades().get(course).getAttestation1());
//						student.viewGrades().put(course, mark);
						student.viewGrades().put(course, student.viewGrades().get(course).addMarks(mark));
					}
					else if(timeOfAttestation == TimeOfAttestation.ATTESTATION2) {
//						mark.setAttestation2(student.viewGrades().get(course).getAttestation2());
//						student.viewGrades().put(course, mark);
						student.viewGrades().put(course, student.viewGrades().get(course).addMarks(mark));
					}
					else if(timeOfAttestation == TimeOfAttestation.FINAL) {
//						mark.setFinalExam(student.viewGrades().get(course).getFinalExam());
//						student.viewGrades().put(course, mark);
						student.viewGrades().put(course, student.viewGrades().get(course).addMarks(mark));
					}
				}
				
				return "You put mark to " + student.getName();
			}
		}
		return "Error";
		
	}
	
	public void addCourse(Course course) {
		if(!this.courses.contains(course)) {
			this.courses.add(course);
		}
	}
}
