package comparator;

import java.util.Comparator;
import classes.Student;

public class ComparatorGPA implements Comparator<Student>{
	
	public ComparatorGPA() {
		super();
	}
	
	
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getGPA() > o2.getGPA()) return 1;
		else if(o1.getGPA() < o2.getGPA()) return -1;
		return 0;
	}

}
