package users;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;


import other.*;
import other.File;

public class Database {
//  public static Vector<Student> students = new Vector<>(); 
//  public static Vector<Teacher> teachers = new Vector<>(); 
//  public static Vector<Manager> managers = new Vector<>(); 
  public static Vector<User> users = new Vector<>();
//  public static Vector<Admin> admins = new Vector<>(); 
//  public static Vector<Librarian> librarians = new Vector<>(); 
  public static Vector<Course> courses = new Vector<>(); 
  public static Vector<Message> messages = new Vector<>(); 
  public static Vector<News> news = new Vector<>(); 
  public static Vector<File> files = new Vector<>(); 
  public static HashMap <Course, Mark> marks = new HashMap <Course, Mark> ();
  public static HashMap <Book, Integer> books = new HashMap <Book, Integer> ();
  public static boolean registrationIsOpen = true;
  
  public static FileInputStream fis;
  public static FileOutputStream fos;
  public static ObjectOutputStream oos;
  public static ObjectInputStream oin;
  
  private static Database database;
  
  
  public static Database getDatabase() {
	  if(database == null) database = new Database();
	  return database;
  }
  
  public void addUser(User user) {
	  users.add(user);
  }
  
  public void deleteUser(User user) {
	  users.remove(user);
  }
  
  
 
  
}