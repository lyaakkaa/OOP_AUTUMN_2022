package classes;

import java.io.Serializable;
import java.util.Map;


@SuppressWarnings("serial")
public class Transcript implements Serializable{
	private Student student;
	private double overallGpa;
	
	
	public Transcript(Student student) {
		this.setStudent(student);
		this.overallGpa = 0;
	}

	public Double calculateGPA() {
		int sum = 0;
		
		for(Map.Entry<Course, Mark> item : student.getGrades().entrySet()) {
			sum += item.getKey().getCredits() * item.getValue().getGpa();
		}
		
		return (double) (sum / student.getTotalCredits());
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getOverallGpa() {
		return overallGpa;
	}

	public void setOverallGpa(double overallGpa) {
		this.overallGpa = overallGpa;
	}
 
}
