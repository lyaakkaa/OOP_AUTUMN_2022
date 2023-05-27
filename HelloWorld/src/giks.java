import java.util.*;

public class giks {

    public static void main(String[] args) {
        
        String[] months = {"ЯНВАРЬ", "ФЕВРАЛЬ", "МАРТ", "АПРЕЛЬ", "МАЙ", "ИЮНЬ", "ИЮЛЬ", "АВГУСТ", "СЕНТЯБРЬ", "ОКТЯБРЬ", "НОЯБРЬ", "ДЕКАБРЬ"};
        
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        String[] weeks = {"Вс", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"};
        
        Scanner in = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = in.nextInt();
        
        // Вычисление дня недели для 1 января
        int week = (year + (year - 1) / 4 + 6) % 7;
        
        // Подгон февраля под високосный год
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            days[1] = 28; // Не високосный
        }
        else {
            days[1] = 29; // Високосный
        }
        
        // Вывод месяца
        for (int month = 0; month < months.length; month++) {
            // Месяц
            System.out.println("\n\n      " + months[month]);
            
            // Дни недели
            for (int j = 1; j < weeks.length; j++) {
                System.out.print(weeks[j] + " ");
            }
            System.out.println(weeks[0]);
            
            //Отступ до 1 числа
            for (int j = 0; j < week - 1; j++) {
                System.out.print("   ");
            }
            
            // Вывод чисел
            int day = 1;
            for (; day <= days[month]; day++) {
                System.out.print(day + " ");
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
}