import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        System.out.print("Enter a day: ");
        int day = input.nextInt();
        //GregorianCalendar calendar = new GregorianCalendar(year , Calendar.SEPTEMBER, day);
        int week = (year + (year - 1) / 4 + 6) % 7;
        String[] weeks = {"Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"};
        System.out.println("\n\n      " + "СЕНТЯБРЬ");
        for (int j = 1; j < weeks.length; j++) {
            System.out.print(weeks[j] + " ");
        }
        
	    System.out.println(weeks[0]);
	    for (int j = 0; j < week - 1; j++) {
            System.out.print("   ");
        }
        int d = 1;
        for (; d <= 30; d++) {
        	System.out.print(d + " ");
            if (day < 10) {
            	System.out.print(" ");
            }
            week++;
            if (week == 7) {
                week = 0;
            } else if (week == 1) {
                System.out.println();
            }
        }
        
        

	}

}
