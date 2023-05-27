package LabWork1;
import java.util.*;

public class DragonLaunch {
	static Vector <Person> launch;
	
	static {
		launch = new Vector <Person>();
	}
	
	
	DragonLaunch(){}
	
	static void kidnap(Person student) {
		launch.add(student);
	}
	
	
	static String willDragonEatOrNot() {
		int cnt = 0;
		int love = 0;
		for(Person p : launch) {
			if(p.getGender() == GenderOfPerson.BOY) {  // BGGG
				                                       // 1000
				cnt++;
			}
			else {
				if(cnt > 0) {
					cnt--;
					love++;
				}
			}
		}
		if(love * 2 == launch.size()) return "NO";
		else return "YES";
	}
}
