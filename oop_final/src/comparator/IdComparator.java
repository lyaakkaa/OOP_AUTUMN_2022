package comparator;

import java.util.Comparator;
import classes.Student;

public class IdComparator implements Comparator<Student>{
	
	public IdComparator() {
		super();
	}
	
	
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
