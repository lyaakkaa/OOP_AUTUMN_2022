package problem1;

import LabWork1.Gender;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d1 = new Dog("Barbos", 3, 10.5, Gender.MALE, 25);
		System.out.println(d1.toString());
		System.out.println(d1.moving(15));
		System.out.println(d1.speak());
		

	}

}
