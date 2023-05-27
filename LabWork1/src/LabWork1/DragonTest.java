package LabWork1;

import java.util.Scanner;

public class DragonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'B') {
				Person p = new Person(GenderOfPerson.BOY);
				DragonLaunch.kidnap(p);
			}
			else {
				Person p = new Person(GenderOfPerson.GIRL); 
				DragonLaunch.kidnap(p);
			}

		}
		
//		Person p1 = new Person(GenderOfPerson.BOY);
//		Person p2 = new Person(GenderOfPerson.GIRL); 
//		Person p3 = new Person(GenderOfPerson.BOY);
//		Person p4 = new Person(GenderOfPerson.GIRL);
//		
//		DragonLaunch.kidnap(p1);
//		DragonLaunch.kidnap(p2);
//		DragonLaunch.kidnap(p3);
//		DragonLaunch.kidnap(p4);
		
		System.out.print(DragonLaunch.willDragonEatOrNot());
		sc.close();
	

	}

}
