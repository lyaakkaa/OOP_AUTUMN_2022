package utils;

import database.Database;
import enums.MessageType;
import models.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Util implements Serializable {
    public static final String COLOR_RESET = "\033[0m";
    public static final String COLOR_BLACK = "\033[0;30m";
    public static final String COLOR_RED = "\033[0;31m";
    public static final String COLOR_GREEN = "\033[0;32m";
    public static final String COLOR_BLUE = "\033[0;34m";
    public static final String COLOR_WHITE = "\033[0;37m";
    public static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private Util() {}

    public static int parseChoice(String choice) {
        try {
            return (Integer.parseInt(choice) - 1);
        } catch (NumberFormatException exc) {
            return -1;
        }
    }

    public static boolean isInRange(int number, int left, int right) {
        return (number >= left && number <= right);
    }

    public static void viewNews() {
        ArrayList<News> allNews = Database.getInstance().getNews();

        if(!allNews.isEmpty()) {
            int index = 1;
            for(News news : allNews) {
                System.out.println(COLOR_GREEN + "|" + index + "| " + news.getTitle() + ". " + news.getPostDate() + COLOR_RESET);
                System.out.println("Content: " + news.getContent());
                System.out.println("Comments: " + news.getComments() + "\n");
                index++;
            }
        } else {
            System.out.println("No news for now");
        }
    }

    public static<T> void printList(Iterable<T> list) {
        int index = 1;
        for(T type : list) {
            System.out.println(index + ") " + type);
            index++;
        }
    }

    public static<T extends User> void printUserList(Iterable<T> users) {
        int index = 1;
        for(T user : users) {
            System.out.println(index + ") " + user.getName() + " " + user.getSurname()
                    + " (" + user.getClass().getSimpleName() + ")");
            index++;
        }
    }

    public static void sendMessage(Employee sender) throws IOException, InterruptedException {
        System.out.println("Choose employee, or X to cancel:");
        ArrayList<Employee> employees = new ArrayList<>(Database.getInstance().getEmployees());
        printUserList(employees);
        int choice = parseChoice(reader.readLine());
        if(choice < 0) {
            System.out.println("Invalid input");
            return;
        }

        MessageType type = null;
        if(sender instanceof Teacher) {
            System.out.println("What type is your message?\n|1| Letter\n|2| Request");
            switch(reader.readLine()) {
                case "1" -> type = MessageType.LETTER;
                case "2" -> type = MessageType.REQUEST;
            }
        }
        System.out.print("Enter the content of your message: ");
        String content = reader.readLine();
        boolean isSigned = false;

        if(sender instanceof Teacher && employees.get(choice) instanceof Manager && type == MessageType.REQUEST) {
            System.out.println("Seems you are sending a request to a manager. It's highly recommended to put dean's sign on it, but it will take some time");
            System.out.println("Will you sign it?\n|1| Yes |2| No");
            switch(reader.readLine()) {
                case "1" -> {
                    System.out.println("Dean is signing...");
                    isSigned = true;
                    Thread.sleep(1500);
                }
                case "2" -> System.out.println("Okay");
            }
        }
        Message message = new Message(sender, employees.get(choice), type, content, isSigned, new Date());
        Database.getInstance().addMessage(message);
        System.out.println("Message has been sent!");
    }
}