
package LabWork1;
import java.util.*;
import problems.Student;

public class GradeBookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		GradeBook gr = new GradeBook( new Course("Object-oriented Programming and Design", "CS101", 4));
		String name; int grade;
		
		System.out.print(gr.displayMessage());
		
		while(sc.hasNext()){
			name = sc.next();
			grade = sc.nextInt();
			Student st = new Student(name, grade);
			GradeBook.addStudent(st);
		}
		System.out.print(gr.displayGradeReport());
		System.out.print(gr.outputBarChart());
		//gr.gradesDistribution();
	}
}
