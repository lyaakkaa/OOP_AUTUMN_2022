package classes;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;


import enums.*;

@SuppressWarnings("serial")
public final class Database implements Serializable{
	private static Database database;
	private static Vector<User> users;
	private static Vector<Course> courses;
	private static Vector<Faculty> faculties;
	private static Vector<Message> messages;
	private static Vector<String> timeOfSignIn;
	private static Vector <News> news;
	private static HashMap<Student, Course> permissionOfRegistrationCourse;
	private static HashMap <Book, Integer> books = new HashMap <Book, Integer> ();
	
	
	private Database(){
		users = new Vector<User>();
		courses = new Vector<Course>();
		faculties = new Vector<Faculty>();
		messages = new Vector<Message>();
		timeOfSignIn = new Vector<String>();
		news =  new Vector<News>();
		permissionOfRegistrationCourse = new HashMap <Student, Course>();
		books = new HashMap <Book, Integer>();
//		createUsers();
		addFaculty();
	}
	
	public static Database getDatabase() {
		if(database == null) database = new Database();
		return database;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public void removeUser(User u) {
		users.remove(u);
	}

	public Vector<User> getUsers() {
		return users;
	}

	public void setUsers(Vector<User> users) {
		Database.users = users;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		Database.courses.add(course);
	}
	
	public void deleteCourses(Course course) {
		Database.courses.remove(course);
	}

	public Vector<Faculty> getFaculties() {
		return faculties;
	}
	
	public void addFaculty() {
		faculties.add(Faculty.BS);
		faculties.add(Faculty.CCE);
		faculties.add(Faculty.FEOG);
		faculties.add(Faculty.FGE);
		faculties.add(Faculty.FGGE);
		faculties.add(Faculty.FIT);
		faculties.add(Faculty.ISE);
		faculties.add(Faculty.KMA);
	}

	public void setFaculties(Vector<Faculty> faculties) {
		Database.faculties = faculties;
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	public void setMessages(Vector<Message> messages) {
		Database.messages = messages;
	}

	public Vector<String> getTimeOfSignIn() {
		return timeOfSignIn;
	}

	public void addTimeOfSignIn(String timeOfSignIn) {
		Database.timeOfSignIn.add(timeOfSignIn);
	}
	
	public Vector<News> getNews() {
		return news;
	}

	public void setNews(Vector<News> news) {
		Database.news = news;
	}

	public HashMap<Student, Course> getPermissionOfRegistrationCourse() {
		return permissionOfRegistrationCourse;
	}

	public void setPermissionOfRegistrationCourse(HashMap<Student, Course> permissionOfRegistrationCourse) {
		Database.permissionOfRegistrationCourse = permissionOfRegistrationCourse;
	}

	public HashMap<Book, Integer> getBooks() {
		return books;
	}

	public void setBooks(HashMap<Book, Integer> books) {
		Database.books = books;
	}

	public void setDatabase(Database database) {
		Database.database = database;
	}
	
	
	public Vector <Employee> getEmployees(){
		Vector <Employee> employees = new Vector<Employee>();
		
		for(User user : users) {
			if(user instanceof Employee) {
				Employee e = (Employee) user;
				employees.add(e);
			}
		}
		return employees;
	}
	
	public Vector <Student> getStudents(){
		Vector <Student> stds = new Vector<Student>();
		for(User u : users) {
			if(u instanceof Student) {
				Student student = (Student) u;
				stds.add(student);
			}
		}
		return stds;
	}
	
	public Vector <Teacher> getTeachers(){
		Vector <Teacher> tchrs = new Vector<Teacher>();
		for(User u : users) {
			if(u instanceof Teacher) {
				Teacher t = (Teacher) u;
				tchrs.add(t);
			}
		}
		return tchrs;
	}
	
	
	
	public static void refresh() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("database.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(database);
			oos.close();
			fos.close();
		} catch(IOException exc) {
			throw new IOException("Error, database could not save changes" + exc.getMessage() + ":" + exc.getCause());
		}
	}
	
	
	public static void loading() {
		try {
			FileInputStream fis = new FileInputStream("db.out");
			ObjectInputStream ois = new ObjectInputStream(fis);

			database = (Database) ois.readObject();
			ois.close();
			fis.close();
		} catch(IOException | ClassNotFoundException exc) {
			database = new Database();
		}
	}
	
	
	public Vector<Teacher> getTeachersOfCourse(Course c) {
	    Vector<Teacher> teachers = new Vector<>();
	    for(User u : users) {
	      if(u instanceof Teacher) {
	        if(((Teacher) u).getCourses().contains(c)) {
	          teachers.add((Teacher) u);
	        }
	      }
	    }
	    return teachers;
    }
	  
	public Book getNeededBooks(int index, String type){
	    Book b = new Book();
	    int i = 1;
	    for(Entry<Book, Integer> b1 : books.entrySet()) {
	      if(i == index) {
	        b = b1.getKey();
	        if(type.equals("giveToStudent")) Database.getDatabase().getBooks().put(b1.getKey(), b1.getValue() - 1);
	        else Database.getDatabase().getBooks().put(b1.getKey(), b1.getValue() + 1);
	        break;
	      }
	    }
	    return b;
	 }
	
	
//	public void createUsers() {
//		addUser(new Student("Leila", "Bekturgan", "lyaka123", 2021, "21B030788", Degree.BACHELOR, Faculty.FIT, "IS"));
//		addUser(new Manager("Darina", "Aitbayeva", "darina123", 90000,1,ManagerType.OR));
//	}

	public void addMessages(Message message) {
		messages.add(message);
		
	}
}
