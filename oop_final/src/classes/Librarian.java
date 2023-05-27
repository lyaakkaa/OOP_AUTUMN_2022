package classes;

import java.util.HashMap;

/**
 * Intranet  System's Librarian model. Has a library, can order books and view the library.
 *
 * @see Book
 */


@SuppressWarnings("serial")
public class Librarian extends Employee {
	
	public Librarian(){}

	/**
	 * Creates the librarian with base User and Employee fields.
	 */
	public Librarian(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password, salary, workExperience);
	}
	
	public void addBooks(Book book) {
		if(Database.getDatabase().getBooks().containsKey(book)) {
			Database.getDatabase().getBooks().put(book, Database.getDatabase().getBooks().get(book) + 1);
		}
		else Database.getDatabase().getBooks().put(book, 1);
    }
	
	public boolean deleteBooks(Book book) {
		if(Database.getDatabase().getBooks().containsKey(book)) {
			if(Database.getDatabase().getBooks().get(book) != 0) {
				Database.getDatabase().getBooks().put(book, Database.getDatabase().getBooks().get(book) - 1);
				return true;
			}
		}
        return false;
    }
	
	/**
	 * Displays the library.
	 *
	 * @return library as map of books and integer values representing amount of books.
	 */
	public HashMap<Book, Integer> getLibrary() {
		return Database.getDatabase().getBooks();
	}
	

}
