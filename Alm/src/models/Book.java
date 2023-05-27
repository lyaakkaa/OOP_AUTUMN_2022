package models;


import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Book implements Serializable {
	private String name;
	private String author;

	public Book() {}

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return Objects.equals(name, book.name) && Objects.equals(author, book.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, author);
	}

	@Override
	public String toString() {
		return ("Name: " + name + ". Author: " + author);
	}
}