package comparator;

import classes.Employee;
import java.util.Comparator;


public class WorkExperienceComparator  implements Comparator<Employee>{
	public WorkExperienceComparator() {
		super();
	}
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getWorkExperience() > o2.getWorkExperience()) return 1;
		else if(o1.getWorkExperience() < o2.getWorkExperience()) return -1;
		return 0;
	}

}
