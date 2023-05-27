package problem2;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Person> persons = new Vector<Person>();
		persons.add(new Person("Akmira", "lol"));
		persons.add(new Student("Leila", "lol", "FIT", 2, 123.23));
		persons.add(new Staff("Dimash", "kek", "117", 125.45));
		
		for (Person i: persons) {
			System.out.println(i);
		}
	}
}
