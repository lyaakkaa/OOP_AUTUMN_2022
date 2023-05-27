package comparators;

import models.Employee;
import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
	public SalaryComparator() {
		super();
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getSalary() == e2.getSalary()) {
			return 0;
		}
		return ((e1.getSalary() > e2.getSalary()) ? 1 : -1);
	}
}