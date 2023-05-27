import java.util.Scanner;

public class program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String grades[] = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    
        int t = 0;
        t = ((n * 2 + 9) / 10) - 10; 
        System.out.println(grades[t]);
//        
//        if(n >= 95 && n <= 100) {
//        	System.out.println("A");
//        }
//        else if(n >= 90 && n <= 94) {
//        	System.out.println("A-");
//        }
//        else if(n >= 85 && n <= 89) {
//        	System.out.println("B+");
//        }
//        else if(n >= 80 && n <= 84) {
//        	System.out.println("B");
//        }
//        else if(n >= 75 && n <= 79) {
//        	System.out.println("B-");
//        }
//        else if(n >= 70 && n <= 74) {
//        	System.out.println("C+");
//        }
//        else if(n >= 65 && n <= 69) {
//        	System.out.println("C");
//        }
//        else if(n >= 60 && n <= 64) {
//        	System.out.println("C-");
//        }
//        else if(n >= 55 && n <= 59) {
//        	System.out.println("D+");
//        }
//        else if(n >= 50 && n <= 54) {
//        	System.out.println("D");
//        }
//        else {
//        	System.out.println("F");
//        }
        sc.close();

	}

}
