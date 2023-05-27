package users;


import other.Book;

public class Librarian extends Employee {
	
	public Librarian(){
		
	}

	public Librarian(String name, String surname, String password, int salary, double workExperience) {
		super(name, surname, password, salary, workExperience);
	}
	
	public void addBooks(Book book) {
		if(Database.books.containsKey(book)) {
			Database.books.put(book, Database.books.get(book) + 1);
		}
		else Database.books.put(book, 1);
    }
	
	public boolean deleteBooks(Book book) {
		if(Database.books.containsKey(book)) {
			if(Database.books.get(book) != 0) {
				Database.books.put(book, Database.books.get(book) - 1);
				return true;
			}
		}
        return false;
    }
	
	public void orderBook(Student student, Book book) {
		if(Database.books.containsKey(book)) {
			student.getBooks().add(book);
			this.deleteBooks(book);
			System.out.println("Book given to student");
		}
		else System.out.println("There is no such book");
		
	}

	
	

}
