package models;

import java.io.Serializable;
import java.util.Objects;

/**
 * WSP University System's User model. One of the most general and important classes in the system.
 *  Contains user specific fields such as name, surname, id, login and password. Every other user in the
 *  system extends this base class. This class itself can't be instantiated, since it's abstract.
 */
public abstract class User implements Cloneable, Serializable, Comparable<User> {
	/**
	 * Name of the user.
	 */
	private String name;
	
	/**
	 * Surname of the user.
	 */
	private String surname;
	
	/**
	 * ID of the user.
	 */
	private String id;
	
	/**
	 * Login of the user.
	 */
	private String login;
	
	/**
	 * Password of the user.
	 */
	private String password;

	public User() {}

	/**
	 * Constructor needed for creating instances of inherited classes of {@code User}. Can't be used to create
	 * {@code User} instance itself. Provides specific fields of a user.
	 */
	public User(String name, String surname, String id, String login, String password) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return login.equals(user.login);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	public Object clone() throws CloneNotSupportedException {
		User user = (User) super.clone();
		user.name = name;
		user.surname = surname;
		user.id = id;
		user.login = login;
		user.password = password;
		return user;
	}

	@Override
	public int compareTo(User o) {
		return name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return (id + "| " + name + " " + surname + " (" + getClass().getSimpleName()
				+ "). Login: " + login + ", Password: " + password);
	}
}