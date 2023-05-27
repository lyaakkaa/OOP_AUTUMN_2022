package Problem4;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Date d = new Date();
		Employee e1 = new Employee("Lyaka", 1000, new Date(100), "1");
		Employee e2 = new Employee("Darina", 1000, new Date(200), "2");
		Employee e3 = new Employee("Akmi", 400, new Date(50), "3");
		Employee e4 = new Employee("Amina", 450, new Date(30), "4");
		
		
	//	Employee c = e1.clone();
	//	e1.setName("Akmii");
	//	e1.setInsuranceNumber("2");
	//	c.setSalary(2323232);
	//	System.out.println(e1);
	//	System.out.println(c);
		
	
		
	//	Manager m1 = new Manager("Akmira", 450, d, "1");
	//	m1.addEmployee(e1);
	//	m1.addEmployee(e2);
	//	m1.calculateBonus();
	
	//	Manager m2 = m1.clone();
	//	m2.calculateBonus();
	//	m2.setBonus(12312);
		
		//System.out.println(m1);
		//System.out.println(m2);
		//m2.getEmployees();
//		
	//	Manager m2 = new Manager("Dari", 450, d, "4");
		//m2.addEmployee(e3);
	//	m2.addEmployee(e4);
	//	m1.calculateBonus();
	//	m2.calculateBonus();
	
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		Collections.sort(employees, new DateComparator());
		for (Person p: employees) {
            System.out.println(p);
      }
		
		
//		System.out.println(e2.compareTo(e4));
//		System.out.println(m2.compareTo(m1));
////		m1.getEmployees();
////		m2.getEmployees();
//		System.out.println(m1.getBonus());
//		System.out.println(m2.getBonus());
//		System.out.println(m1);
//		System.out.println(m2);
		
	}

}
