
public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student s = new Student(20, 2);
		Student s2 = (Student)s.clone();
		s2.age = 99;
		s2.enrolled.setMonth(2);
		System.out.println(s);
		System.out.println(s2);

	}

}
