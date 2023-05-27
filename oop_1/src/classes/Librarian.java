package classes;

import java.util.HashMap;

@SuppressWarnings("serial")
public class Librarian extends Employee {
	
	public Librarian(){}

	
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
	
//	public void orderBook(Student student, Book book) {
//		if(Database.getDatabase().getBooks().containsKey(book) && Database.getDatabase().getBooks().get(book) > 0) {
//			student.getBooks().add(book);
//			this.deleteBooks(book);
//			System.out.println("Book given to student");
//		}
//		else System.out.println("There is no such book");
//	}
//	
	public HashMap<Book, Integer> getLibrary() {
		return Database.getDatabase().getBooks();
	}
	

}
