package problems;
import java.util.*;
public class chapter2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(SumOfNumber(n));
        sc.close();
	}
	static int SumOfNumber(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
