import java.util.Scanner;

public class program4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double x1, x2;
        double d = b * b - 4 * a * c;
        if(d > 0) {
        	x1 = (-b + Math.pow(d, 0.5)) / (2 * a);
        	x2 = (-b - Math.pow(d, 0.5)) / (2 * a);
        	System.out.println(x1 + " " + x2);
 
        }
        else if(d == 0) {
        	x1 = x2 = -b / (2 * a);
        	System.out.println(x1);
        }
        else {
        	System.out.println("Error");
        	
        }
        
        sc.close();

	}

}
