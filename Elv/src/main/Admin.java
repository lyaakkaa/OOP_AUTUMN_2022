package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @generated
*/
public class Admin extends Employee implements Comparable, INews, IOrder{

	public Admin() {}
	
	public Admin(String firstName, String lastName, String email, int salary) {
    	super(firstName, lastName, email, salary);
    }
	
	public static void createAdmin(String firstName, String lastName, String email, int salary) {
        Admin a = new Admin(firstName, lastName, email, salary);
        Database.users.add(a);
	}

    public void createStudent(String firstName, String lastName, String email, Integer yearOfStudy, Faculties faculty, Degree degree) {
        Student s = new Student(firstName, lastName, email, yearOfStudy, faculty, degree);
        Database.users.add(s);
    }

    public void createManager(String firstName, String lastName, String email, 
    		Integer salary) {
        Manager m =  new Manager(firstName, lastName, email, salary);
        Database.users.add(m);
    }

    public void createTechSupportGuy(String firstName, String lastName, String email, Integer salary) {
        TechSupportGuy guy = new TechSupportGuy(firstName, lastName, email, salary);
        Database.users.add(guy);
    }

    public void createTeacher(String firstName, String lastName, String email, int salary, Faculties faculty) {
        Teacher t = new Teacher(firstName, lastName, email, salary, faculty);
        Database.users.add(t);
    }

    @Override
    public String toString() {
        return String.format("Admin: { %s }", super.toString());
    }

    public boolean removeUser(User user) {
        for(User u: Database.users) {
        	if (user.equals(u)) {
        		Database.users.remove(user);
        		return true;
        	}
        }
    	return false;
    }
  

	@Override
	public void createNews(String title, String text, Date date, Employee sender) {
		News n = new News(title, text, date, sender);
	}
	
	public void addCourse(String courseName, Integer credits, String courseCode) {
    	Course c = new Course(courseName, credits, courseCode);
    	Database.courses.add(c);
    }
	
//	private static void seeLogFiles(String h) throws IOException{
//		BufferedWriter out = new BufferedWriter(new FileWriter("adminHistory.txt", true));
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		String history = "";
//		history = dateFormat.format(date).toString() + " " + h;
//		out.write(history); 
//		out.flush();
//		out.close();
//	}


	@Override
	public void sendOrder(String problem, Order order, TechSupportGuy techSupportGuy) {
		techSupportGuy.addOrder(order);
		order.setOrderStatus(OrderStatus.NEW);
	}
	
	@Override
	public int compareTo(Object o) {
		Admin m = (Admin)o;
		if (m.getSalary() > this.getSalary()) return -1;
		if (m.getSalary() < this.getSalary()) return 1;
		return 0;
	}
	
	public String showInfo() {
		String s = "";
		s += "\nFull name: " + this.getFirstName() + " " + this.getLastName() + "\nWork Experience: " + this.getWorkExperience();
		return s;
	}
    
}