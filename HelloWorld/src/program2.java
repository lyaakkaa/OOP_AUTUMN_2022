import java.util.Scanner;

public class program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 4 * n;
        int s = n * n;
        double d = n * Math.pow(2, 0.5);
        System.out.println("Периметр квадрата: " + p);
        System.out.println("Площадь квадрата: " + s);
        System.out.println("Диагональ квадрата: " + d);
  
        sc.close();

	}

}
