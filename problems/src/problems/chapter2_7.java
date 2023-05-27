package problems;
import java.util.*;
public class chapter2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(UpperCase(s));
        sc.close();
		

	}
	static String UpperCase(String str) {
		String answer = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				answer += str.charAt(i);
			}
		}
		return answer;
	}

}
