package menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.Map.Entry;

import classes.Book;
import classes.Database;
import classes.Librarian;




public class MenuLibrarian extends MenuUser {
	
    private Librarian librarian;

    public MenuLibrarian() {
        super.setMenu(
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\n" +
                "1. View info about library\n" +
                "2. Order a book\n" +
                "3. View news\n" +
                "0. Exit\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\n"
        );
    }

    public MenuLibrarian(Librarian librarian) {
        this();
        this.librarian = librarian;
        this.hello();
    }
    @Override
    public void hello() {
        System.out.println("Login successfully, hello " + librarian.getName()+ "!");
        Database.getDatabase().addTimeOfSignIn("Librarian " + librarian.getName() + " "+ librarian.getSurname()+ "logged in at " + new Date().toString());
    }

    @Override
    public boolean choosingAction(String act) throws IOException, InterruptedException {
        if(act.equals("1")) this.viewLibrary();
        else if(act.equals("2")) this.orderBook();
        else if(act.equals("3")) this.viewNews();
        else if(act.equals("0")) {
        	System.out.println("Goodbye! " + librarian.getName() + " " + librarian.getSurname());
        	return false;
        }
        else {
        	System.out.println("You chose the wrong action, try again");
        	return true;
        }
        return true; 
    }

   
    private void viewLibrary() throws IOException, InterruptedException{
        if(librarian.getLibrary().isEmpty()) {
            System.out.println("Sorry, but Library is empty now");
            return;
        }
        System.out.println("Library:");
        int index = 1;
        for(Entry<Book, Integer> entry : librarian.getLibrary().entrySet()) {
            System.out.println(index + ") " + entry.getKey() + ". Amount: " + entry.getValue());
            index++;
        }
    }

    private void orderBook() throws IOException, InterruptedException {
        ArrayList<Book> books = new ArrayList<>(librarian.getLibrary().keySet());
        viewLibrary();
        System.out.println((books.size() + 1) + ") Order a new book");
        System.out.println("\n Select a book to order. To cancel, press 0");
        int option = Buffer.numAct(Buffer.reader.readLine());
        if(option < 0) {
            System.out.println("Operation was cancelled");
            return;
        }
        if(option == books.size()) {
            orderNewBook();
        } else {
            if(Buffer.checkRange(option, 0, books.size() - 1)) {
                System.out.println(books.get(option));
                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(Buffer.reader.readLine());
                librarian.getLibrary().merge(books.get(option), quantity, Integer::sum);
            }
        }
    }

    private void orderNewBook() throws IOException {
        System.out.println("Enter info about book:");
        System.out.print("1. Name: ");
        String name = Buffer.reader.readLine();
        System.out.print("2.Id: ");
        int id = Integer.parseInt(Buffer.reader.readLine());
        System.out.print("3. Amount: ");
        int amount = Integer.parseInt(Buffer.reader.readLine());
        if(librarian.getLibrary().putIfAbsent(new Book(name, id), amount) != null) {
            System.out.println("Book already exists");
        } else {
            System.out.println("Book was added");
        }
    }
   
}