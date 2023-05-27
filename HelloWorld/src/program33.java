import java.util.Scanner;

public class program33 {


public class program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int month = 3;
 
        switch (n) {
            case 1:  n >= 95 && n <= 100;
            System.out.println("A");
                     break;
            case 2:  monthString = "Февраль";
                     break;
            case 3:  monthString = "Март";
                     break;
            case 4:  monthString = "Апрель";
                     break;
            case 5:  monthString = "Май";
                     break;
            case 6:  monthString = "Июнь";
                     break;
            case 7:  monthString = "Июль";
                     break;
            case 8:  monthString = "Август";
                     break;
            case 9:  monthString = "Сентябрь";
                     break;
            case 10: monthString = "Октябрь";
                     break;
            case 11: monthString = "Ноябрь";
                     break;
            case 12: monthString = "Декабрь";
                     break;
            default: monthString = "Не знаем такого";
                     break;
        }
        if(n >= 95 && n <= 100) {
        	System.out.println("A");
        }
        else if(n >= 90 && n <= 94) {
        	System.out.println("A-");
        }
        else if(n >= 85 && n <= 89) {
        	System.out.println("B+");
        }
        else if(n >= 80 && n <= 84) {
        	System.out.println("B");
        }
        else if(n >= 75 && n <= 79) {
        	System.out.println("B-");
        }
        else if(n >= 70 && n <= 74) {
        	System.out.println("C+");
        }
        else if(n >= 65 && n <= 69) {
        	System.out.println("C");
        }
        else if(n >= 60 && n <= 64) {
        	System.out.println("C-");
        }
        else if(n >= 55 && n <= 59) {
        	System.out.println("D+");
        }
        else if(n >= 50 && n <= 54) {
        	System.out.println("D");
        }
        else {
        	System.out.println("F");
        }
        sc.close();

	}

}


}
