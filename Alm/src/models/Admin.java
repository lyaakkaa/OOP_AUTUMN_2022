package models;

import database.Database;
import interfaces.CanAlterUserData;
import views.AdminView;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * WSP University System's Admin model. Can add, remove or update users.
 * Has all of the functionality of base Employee class.
 *
 * @see User
 * @see Employee
 * @see AdminView
 */
@SuppressWarnings("serial")
public class Admin extends Employee implements CanAlterUserData {
	/**
	 * Creates an Admin class with Employee's fields.
	 */
	public Admin() {}

	/**
	 * Creates an Admin class with Employee's fields.
	 */
	public Admin(String name, String surname, String id, String login, String password, double salary) {
		super(name, surname, id, login, password, salary);
	}

	/**
	 * Adds the given user to Database.
	 *
	 * @param user user to add
	 */
	public void addUser(User user) {
		Database.getInstance().addUser(user);
	}
	
	/**
	 * Removes the given user from Database if exists, nothing otherwise.
	 * @param user user to remove
	 */
	public void removeUser(User user) {
		Database.getInstance().removeUser(user);
	}
	
	/**
	 * Retrieves all users from Database.
	 * @return set of users
	 */
	public HashSet<User> getUsers() {
		return Database.getInstance().getUsers();
	}
	
	/**
	 * Retrieves all user log actions from Database.
	 * @return list of all user actions
	 */
	public ArrayList<String> getUserActions() {
		return Database.getInstance().getUserActions();
	}
}