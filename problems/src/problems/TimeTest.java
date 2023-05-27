package problems;
import java.util.*;


public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Time myTime = new Time(21, 0, 24);
		Time mySecondTime = new Time(1, 0, 61);
		
		myTime.timeSetting();
		mySecondTime.timeSetting();
		System.out.println(myTime.toStandard());
		System.out.println(mySecondTime.toStandard());
		System.out.println(myTime.addTimes(mySecondTime).toStandard());
		System.out.println(myTime.addTimes(mySecondTime).toUniversal());
		System.out.println(Time.addTimes(mySecondTime, myTime).toStandard());
	}
}
