import java.util.Scanner;

public class program6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		if(isPalindrome(s)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		sc.close();

	}
	static boolean isPalindrome(String s) {
		String t = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			t = t + s.charAt(i);
		}
		return t.equals(s);
	}

}
