import java.util.Scanner;

public class program5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	    double balance = sc.nextDouble();

	    double percent = sc.nextDouble();

	    double ans = (balance * percent) / 100;

	    System.out.println(ans);

	    sc.close();
	
	}

}
