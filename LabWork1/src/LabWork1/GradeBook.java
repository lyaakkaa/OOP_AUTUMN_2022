package LabWork1;

import problems.Student;
import java.util.*;


public class GradeBook {
	
	Course course;
	Student max;
	private String maxiStudentName, miniStudentName;
	private int maxiStudentId, miniStudentId;
	static Vector<Student> students = new Vector<Student>();
	
	
	GradeBook(Course course){
		this.course = course;
	}
	
	static public void addStudent(Student student) {
		students.add(student);
	}
	
	public String displayMessage() {
		return "Welcome to the grade book for " + course + "!\n\n" + 
	"Please, input grades for students: \n";
	}
	
	
	public double determineClassAverage() {
		double sum = 0;
		for(Student s: students) {
			sum += s.getGrade();
		}
		return sum / students.size();
	}
	
	public int findMaxi() {
		int maxi = 0;
		for(Student s : students) {
			if(s.getGrade() >= maxi) {
				max = s;
				maxi = s.getGrade();
				maxiStudentName = s.getName();
				maxiStudentId = s.getId();
			}
		}
		return maxi;
	}
	
	public int findMini() {
		int mini = 100;
		for(Student s : students) {
			if(s.getGrade() <= mini) {
				mini = s.getGrade();
				miniStudentName = s.getName();
				miniStudentId = s.getId();
			}
		}
		return mini;
	}
	
	public String getMaxiStudentName() {
		return maxiStudentName;
	}
	
	public int getMaxiId() {
		return maxiStudentId;
	}
	
	public String getMiniStudentName() {
		return miniStudentName;
	}
	
	public int getMiniId() {
		return miniStudentId;
	}
	
	public String displayGradeReport() {
		return "Class average is " + this.determineClassAverage() + ". Lowest grade is " + this.findMini() + " (" + "Student " + this.getMiniStudentName() + ", id: " + this.getMiniId() + ")" + "\n" + "Highest grade is " + this.findMaxi() + " (" + "Student " + this.getMaxiStudentName() + ", id: " + this.getMaxiId()+ ").\n";
	} 
	
	
	public void outputBarChartt() {
		System.out.println("\nGrades distribution:");
		int point = 0;
		while(point < 10) {
			System.out.print(point * 10 + "-" + (point * 10 + 9) + ": ");
			for(Student s : students) {
				if(s.getGrade() >= point * 10 && s.getGrade() <= point * 10 + 9) {
					System.out.print("*");
				}
			}
			System.out.println();
			point++;
		}
		System.out.print("100: ");
		for(Student s : students) {
			if(s.getGrade() == 100 ) {
				System.out.print("*");
			}
		}
	}
	public String outputBarChart() {
		String answer = "";
		answer += "\nGrades distribution:\n";
		int point = 0;
		while(point < 10) {
			answer += (point * 10 + "-" + (point * 10 + 9) + ": ");
			for(Student s : students) {
				if(s.getGrade() >= point * 10 && s.getGrade() <= point * 10 + 9) {
					answer += "*";
				}
			}
			answer += "\n";
			point++;
		}
		answer += "100: ";
		for(Student s : students) {
			if(s.getGrade() == 100 ) {
				answer += "*";
			}
		}
		return answer;
	}
}
