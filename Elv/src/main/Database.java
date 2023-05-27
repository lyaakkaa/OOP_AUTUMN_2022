package main;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Database implements Serializable {
    
	public static Vector<User> users = new Vector<User>();
	public static Vector<Course> courses = new Vector<Course>();
	public static Vector<File> files = new Vector<File>();
	public static Vector<News> news = new Vector<News>();
	public static Vector<Order> orders = new Vector<Order>();
	public static Vector<Message> messages = new Vector<Message>();
	public static HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	public static ObjectInputStream oin;
	
	
	
	
	
    //                          Operations                                  
    
	
	public static void save() {
		saveCourses();
		saveFiles();
		saveMarks();
		saveMessages();
		saveNews();
		saveOrders();
		saveUsers();
	}
	
	public static void load() {
		loadCourses();
		loadFiles();
		loadMarks();
		loadMessages();
		loadNews();
		loadOrders();
		loadUsers();
	}
	
	public static void serUsers() throws IOException{
		fos = new FileOutputStream("users.out");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.close();
	}
	
	public  static void desUsers() throws IOException, ClassNotFoundException {
		fis = new FileInputStream("users.out");
		oin = new ObjectInputStream(fis);
		users = (Vector<User>) oin.readObject();
		oin.close();
		fis.close();
//		for(User u : users) {
//			System.out.println(u);
//		}
	}
	
	public static void serCourses() throws IOException{
		fos = new FileOutputStream("courses.out");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	
	public  static void desCourses() throws IOException, ClassNotFoundException {
		fis = new FileInputStream("courses.out");
		oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
		oin.close();
		fis.close();
	}
	
	
	public static String getTeachers() {
		String s = "";
		for(User u: users) {
			if (u instanceof Teacher) {
				Teacher t = (Teacher) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getManagers() {
		String s = "";
		for(User u: users) {
			if (u instanceof Manager) {
				Manager t = (Manager) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getAdmins() {
		String s = "";
		for(User u: users) {
			if (u instanceof Admin) {
				Admin t = (Admin) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getStudents() {
		String s = "";
		for(User u: users) {
			if (u instanceof Student) {
				Student t = (Student) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
	
	public static String getTechGuys() {
		String s = "";
		for(User u: users) {
			if (u instanceof TechSupportGuy) {
				TechSupportGuy t = (TechSupportGuy) u;
				s += t.showInfo() + "\n";
			}
		}
		return s;
	}
    
    public Course findCourse(String courseCode) {
        for (Course course : this.courses) {
        	if (course.getCourseCode().equals(courseCode)) {
        		return course;
        	}
        }
        return null;
    }
    
    public Student findStudent(String id) {
    	for (User user : this.users) {
    		if (user instanceof Student) {
    			Student student = (Student) user;
    			if (student.getId().equals(id)) {
    				return student;
    			}
    		}
        	
        }
        return null;
    }
    
    public boolean removeUser(String login) {
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course removeCourse(String name) {
        for (Course course: courses) {
            if (course.getCourseName().equals(name)) {
                courses.remove(course);
                return course;
            }
        }
        return null;
    }
    
    public void addNews(News news) {
        this.news.add(news);
    }
    
    //--------------------------- E N U M S --------------------------
    public Faculties[] getFaculties() {
        return new Faculties[] {
        	Faculties.FIT, Faculties.BS, Faculties.FGA, Faculties.FEOGI, Faculties.ISE, Faculties.MCM, Faculties.KMA
        };
    }
    
    public Degree[] getDegree() {
        return new Degree[] { Degree.BACHELOR, Degree.MASTERS, Degree.PHD };
    }
    
    public TeachingStatus[] getTeachingStatus() {
        return new TeachingStatus[] {
        	TeachingStatus.ASSISTANT, TeachingStatus.LECTURER, TeachingStatus.PROFESSOR, TeachingStatus.SENIOR_LECTURER, TeachingStatus.TUTOR
        };
    }
    
    
    //--------------------------- S A V E   D A T A --------------------------
    
    
    private static void saveUsers() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("users.txt"))) {
            oot.writeObject(users);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("users.txt: IOException");
        }
    }
    
    private static void saveMarks() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("marks.txt"))) {
            oot.writeObject(marks);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("marks.txt: IOException");
        }
    }
    

    private static void saveCourses() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("courses.txt"))) {
            oot.writeObject(courses);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("courses.txt: IOException");
        }
    }

    private static void saveNews() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("news.txt"))) {
            oot.writeObject(news);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("news.txt: IOException");
        }
    }
    
    private static void saveMessages() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("messages.txt"))) {
            oot.writeObject(messages);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("messages.txt: IOException");
        }
    }
    
    private static void saveOrders() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("orders.txt"))) {
            oot.writeObject(orders);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("orders.txt: IOException");
        }
    }
    
    private static void saveFiles() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("files.txt"))) {
            oot.writeObject(files);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("files.txt: IOException");
        }
    }
    
  //--------------------------- L O A D   D A T A --------------------------
    
    private static void loadUsers() {
    	try {
        	fis = new FileInputStream("users.txt");
        	oin = new ObjectInputStream(fis); 
            users = (Vector<User>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            users = new Vector<>();
            System.err.println("users.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("users.txt: ClassNotFoundException");
        }   
    }
    
    private static void loadMarks() {
    	try {
        	fis = new FileInputStream("marks.txt");
        	oin = new ObjectInputStream(fis); 
            marks = (HashMap<Course, Mark>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            marks = new HashMap<>();
            System.err.println("marks.txt: IOException");
        }
        catch (ClassNotFoundException e) {
        	marks = new HashMap<>();
            System.err.println("marks.txt: ClassNotFoundException");
        }
        
    }
    
    private static void loadCourses(){
    	try {
        	fis = new FileInputStream("courses.txt");
        	oin = new ObjectInputStream(fis); 
            courses = (Vector<Course>) oin.readObject();
            oin.close();
            fis.close();
//            for(Course c: courses) {
//            	System.out.println(c);
//            }
        }
        catch (ClassNotFoundException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: ClassNotFoundException");
        }
        catch (IOException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: IOException");
        }
    }
    
    private static void loadNews() {
        try {
        	fis = new FileInputStream("news.txt");
        	oin = new ObjectInputStream(fis); 
            news = (Vector<News>) oin.readObject();
            oin.close();
            fis.close();
        }
        catch (ClassNotFoundException e) {
            news = new Vector<>();
            System.err.println("news.txt: ClassNotFoundException");
        }
        catch (IOException e) {
            news = new Vector<>();
            System.err.println("news.txt: IOException");
        }
    }
    
    private static void loadMessages() {
    	try {
        	fis = new FileInputStream("messages.txt");
        	oin = new ObjectInputStream(fis); 
            messages = (Vector<Message>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            users = new Vector<>();
            System.err.println("messages.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("messages.txt: ClassNotFoundException");
        }
    }
    
    private static void loadOrders() {
    	try {
        	fis = new FileInputStream("orders.txt");
        	oin = new ObjectInputStream(fis); 
            orders = (Vector<Order>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            orders = new Vector<>();
            System.err.println("orders.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            orders = new Vector<>();
            System.err.println("orders.txt: ClassNotFoundException");
        }
    }
    
    private static void loadFiles() {
    	try {
        	fis = new FileInputStream("files.txt");
        	oin = new ObjectInputStream(fis); 
            files = (Vector<File>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            files = new Vector<>();
            System.err.println("files.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            files = new Vector<>();
            System.err.println("files.txt: ClassNotFoundException");
        }
    }
}