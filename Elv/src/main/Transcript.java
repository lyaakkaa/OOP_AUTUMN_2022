package main;


import java.util.HashMap;

/**
* @generated
*/
public class Transcript {
    
    private double totalGPA;
    HashMap< Integer,HashMap<Course,Mark> > semesters = new HashMap< Integer,HashMap<Course,Mark> >();
    int totalCredits;
    
    
    private double getTotalGPA() {
        return this.totalGPA;
    }
    
    private void setTotalGPA(double totalGPA) {
        this.totalGPA = totalGPA;
    }
    //                          Operations                                  
    
    public void calculateGPA() {
		int numOfCourses = 0;
		double cntGPA = 0;
		for(int i = 1; i <= semesters.size(); i++) {
			for (HashMap.Entry<Course, Mark> entry : semesters.get(i).entrySet()){
				numOfCourses++;
			    cntGPA += entry.getValue().getCourseGPA();
			}
		}
		totalGPA = cntGPA / numOfCourses;
    }
    
    public void addMark(Integer semester, Course course, Mark mark) {
		semesters.get(semester).put(course, mark);
		totalCredits = totalCredits + course.getCredits();
		calculateGPA();
	}
    
    public String toString() {
		String s = "";
		System.out.println("--------------------------------");
		for(int i = 1; i <= semesters.size(); i++) {
			s = s + "Marks of semester " + (i + 1) + "\n";
			for (HashMap.Entry<Course,Mark> entry : semesters.get(i).entrySet()) {
			    s = s + (entry.getKey() + "-" + entry.getValue().gradeToLetter()) + "\n";
			}
		}
		System.out.println("--------------------------------");
		return s;
	}
    
    
}