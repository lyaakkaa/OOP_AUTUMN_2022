package problems;
import java.util.*;
public class chapter2_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(BinToDec(s));
        sc.close();
	}
	static int BinToDec(String s) {
		int ans = 0;
		int power = s.length() - 1;
		for(int i = 0; i < s.length(); i++) {
			ans += (s.charAt(i) - '0') * Math.pow(2, power);
			power--;
		}
		return ans;
	}
}
