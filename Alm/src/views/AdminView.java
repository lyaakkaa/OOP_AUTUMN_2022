package views;

import comparators.NameComparator;
import database.Database;
import models.Admin;
import models.User;
import utils.*;
import java.io.IOException;
import java.util.*;

public class AdminView extends UserView {
    private Admin admin;

    public AdminView() {
        setMenu(
                "---------------------------------\n" +
                "|1| View users\n" +
                "|2| Add user\n" +
                "|3| Delete user\n" +
                "|4| Update user\n" +
                "|5| View logs about user actions\n" +
                "|6| View news\n" +
                "|X| Logout\n" +
                "---------------------------------"
        );
    }

    public AdminView(Admin admin) {
        this();
        this.admin = admin;
        greet();
    }

    @Override
    public boolean performAction(String choice) throws IOException, InterruptedException {
        switch(choice.toLowerCase()) {
            case "1" -> viewUsers();
            case "2" -> addUser();
            case "3" -> removeUser();
            case "4" -> updateUser();
            case "5" -> viewUserActions();
            case "6" -> viewNews();
            case "7", "x", "q", "exit", "quit" -> {
                System.out.println("Logging out.. Goodbye, " + admin.getName() + "!");
                return false;
            }
            default -> {
                System.out.println("Wrong operation was selected, please, choose the correct one");
                return true;
            }
        }
        return true;
    }

    @Override
    public void greet() {
        System.out.println("Welcome, " + admin.getName() + "!");
        Database.getInstance().addUserAction("User " + admin.getName() + " (Admin) logged in at " + new Date().toString());
    }

    public void addUser() throws IOException, InterruptedException {
        System.out.println("Choose which type of user you want to add, or X to cancel:");
        System.out.println("|1| Admin\n|2| Manager\n|3| Teacher\n|4| Librarian\n|5| Student\n|X| Cancel");
        String chosenUser = determineUser(Util.reader.readLine());

        if(chosenUser.equals("exit") || chosenUser.equals("unknown")) {
            System.out.println("Operation was canceled");
            return;
        }
        UserFactory factory = new UserFactory();
        User user = factory.createUser(chosenUser);
        if(!Database.getInstance().getUserLoginsAndPasswords(user.getClass().getSimpleName().toLowerCase()).containsKey(user.getLogin())) {
            admin.addUser(user);
            System.out.println("Added user " + user);
            Thread.sleep(500);
            System.out.println("Don't forget your password, write it down somewhere!!!");
        } else {
            System.out.println("Such user already exists");
        }
        Thread.sleep(1500);
    }

    public void removeUser() throws IOException {
        ArrayList<User> users = new ArrayList<>(Database.getInstance().getUsersExcept(admin));

        if(users.size() > 0) {
            System.out.println("Select which user to remove, or X to cancel:");
            Util.printList(users);
            System.out.println("X) Cancel");

            int choice = Util.parseChoice(Util.reader.readLine());
            if(choice < 0 || !Util.isInRange(choice, 0, users.size() - 1)) {
                System.out.println("Operation was either cancelled or interrupted");
                return;
            }
            admin.removeUser((User) users.get(choice));
            System.out.println("User has been removed!");
            return;
        }
        System.out.println("There is currently no user to remove");
    }

    public void updateUser() throws IOException, InterruptedException {
        ArrayList<User> users = new ArrayList<>(Database.getInstance().getUsers());
        users.sort(new NameComparator());

        System.out.println("Select the user to update, or X to cancel:");

        for(int i = 0; i < users.size(); i++) {
            if(users.get(i) != admin) {
                System.out.println((i + 1) + ") " + users.get(i));
            } else {
                System.out.println(Util.COLOR_BLUE + (i + 1) + ") This " + users.get(i) + Util.COLOR_RESET);
            }
        }
        System.out.println("X) Cancel");

        int choice = Util.parseChoice(Util.reader.readLine());
        if(choice < 0 || !Util.isInRange(choice, 0, users.size() - 1)) {
            System.out.println("Operation was either cancelled or interrupted");
            return;
        }
        UserRenovator renovator = new UserRenovator(users.get(choice));
        renovator.updateUser();
        System.out.println(users.get(choice));
    }

    public void viewUserActions() throws IOException {
        ArrayList<String> actions = admin.getUserActions();

        if(!actions.isEmpty()) {
            System.out.println("User log actions up to now:");

            Util.printList(actions);
            System.out.println("\nDo you wish to clear the history of log actions? Any key to answer No");
            System.out.println("|1| Yes\n|X| No");
            String choice = Util.reader.readLine();

            if(choice.equals("1")) {
                actions.clear();
                System.out.println("Action history has been cleared!");
            }
            return;
        }
        System.out.println("No actions available for now..");
    }

    public void viewUsers() {
        Util.printUserList(admin.getUsers());
    }

    private String determineUser(String chosenUser) {
        switch(chosenUser.toLowerCase()) {
            case "1" -> {
                return "admin";
            }
            case "2" -> {
                return "manager";
            }
            case "3" -> {
                return "teacher";
            }
            case "4" -> {
                return "librarian";
            }
            case "5" -> {
                return "student";
            }
            case "x", "q", "exit", "quit" -> {
                return "exit";
            }
            default -> {
                return "unknown";
            }
        }
    }
}