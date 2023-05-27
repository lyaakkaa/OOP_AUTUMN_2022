package views;

import database.Database;
import models.Book;
import models.Librarian;
import utils.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class LibrarianView extends UserView {
    private Librarian librarian;

    public LibrarianView() {
        setMenu(
                "-----------------\n" +
                "|1| View library\n" +
                "|2| Order a book\n" +
                "|3| View news\n" +
                "|X| Logout\n" +
                "-----------------"
        );
    }

    public LibrarianView(Librarian librarian) {
        this();
        this.librarian = librarian;
        greet();
    }

    @Override
    public boolean performAction(String choice) throws IOException {
        switch(choice.toLowerCase()) {
            case "1" -> viewLibrary();
            case "2" -> orderBook();
            case "3" -> viewNews();
            case "4", "x", "q", "exit", "quit" -> {
                System.out.println("Logging out.. Goodbye, " + librarian.getName() + "!");
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
        System.out.println("Welcome, " + librarian.getName() + "!");
        Database.getInstance().addUserAction("User " + librarian.getName() + " (Librarian) logged in at " + new Date().toString());
    }

    private void viewLibrary() {
        if(librarian.getLibrary().isEmpty()) {
            System.out.println("No books in the library yet");
            return;
        }
        System.out.println("Library:");
        int index = 1;
        for(Map.Entry<Book, Integer> entry : librarian.getLibrary().entrySet()) {
            System.out.println(index + ") " + entry.getKey() + ". Amount: " + entry.getValue());
            index++;
        }
    }

    private void orderBook() throws IOException {
        ArrayList<Book> books = new ArrayList<>(librarian.getLibrary().keySet());
        viewLibrary();
        System.out.println((books.size() + 1) + ") Order a new book");
        System.out.println("\nSelect which book to order, or order a brand new book. Enter anything else to cancel");
        int choice = Util.parseChoice(Util.reader.readLine());
        if(choice < 0) {
            System.out.println("Operation was cancelled");
            return;
        }
        if(choice == books.size()) {
            orderNewBook();
        } else {
            if(Util.isInRange(choice, 0, books.size() - 1)) {
                System.out.println(books.get(choice));
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(Util.reader.readLine());
                librarian.getLibrary().merge(books.get(choice), quantity, Integer::sum);
            }
        }
    }

    private void orderNewBook() throws IOException {
        System.out.println("Enter the book data:");
        System.out.print("|1| Name: ");
        String name = Util.reader.readLine();
        System.out.print("|2| Author: ");
        String author = Util.reader.readLine();
        System.out.print("|3| Amount: ");
        int amount = Integer.parseInt(Util.reader.readLine());
        if(librarian.getLibrary().putIfAbsent(new Book(name, author), amount) != null) {
            System.out.println("Book already exists in the library");
        } else {
            System.out.println("Book was successfully added");
        }
    }
}