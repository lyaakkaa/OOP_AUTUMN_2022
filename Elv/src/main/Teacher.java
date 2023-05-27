package main;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.Map.Entry;

/**
* @generated
*/
public class Teacher extends Employee implements Serializable, IOrder, IMessage, INews {
    
    private List<Course> courses;
    private TeachingStatus teachingStatus;
    public Faculties faculty;
    
    public Teacher() {
    	courses = new Vector<Course>();
    }

    public Teacher(String firstName, String lastName, String email, int salary, Faculties faculty) {
    	super(firstName, lastName, email, salary);
    	this.faculty = faculty;
    	courses = new Vector<Course>();
    }
    public List<Course> getCourses() {
        return this.courses;
    }
   
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
   
    public TeachingStatus getTeachingStatus() {
        return this.teachingStatus;
    }

    public void setTeachingStatus(TeachingStatus teachingStatus) {
        this.teachingStatus = teachingStatus;
    }
    
    
    //                          Operations                                  
    


    @Override
    public void createNews(String title, String text, Date date, Employee sender) {
		News n = new News(title, text, date, sender);
	}
    
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public boolean putMark(Course course, MarksType marksType, double points, Student student) throws DeadlineExpired{
    	for (User u: Database.users) {
    		if (u instanceof Student) {
    			Student s = (Student) u;
    			if (s.equals(student)) {
    				if (s.getCourses().contains(course)) {
	    				for (Entry<Course, Mark> entry : student.getMarks().entrySet()) {
		//    				System.out.println(entry.getValue());
		    				Mark m = entry.getValue();
		    				Database.marks.put(course, m);
		    				student.setMark(course, new Mark(points, marksType));
		    				return true;
	    				}
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public boolean addCourseFile(Course course, File file) {
        for (Course c: this.courses) {
        	if (c.equals(course)) {
        		c.courseFiles.add(file);
        		return true;
        	}
        }
        return false;
    }
    
    public boolean deleteCourseFile(Course course, File file) {
    	for (Course c: this.courses) {
        	if (c.equals(course)) {
        		if (c.courseFiles.contains(file)) {
        			c.courseFiles.remove(file);
        			return true;
        		}
        	}
        }
        return false;
    }
    
    public String viewCourses() {
    	String s = "";
    	if (this.courses.size() >= 1) {
    		for (Course c: this.courses) {
    			s += c + "\n";
    		}
    		return s;
    	}
        return "You have no courses:(";
    }
    
    public String showCourseFiles(Course course) {
    	String s = "";
        for (File f: course.courseFiles) {
        	s += f.showFileInfo() + "\n";
        }
        return s;
    }

	@Override
	public void sendMessage(Message message, Employee sendTo) {
		Manager m = (Manager) sendTo;
		m.putMessage(message);
	}

	@Override
	public void sendOrder(String problem, Order order, TechSupportGuy techSupportGuy) {
		techSupportGuy.addOrder(order);
		order.setOrderStatus(OrderStatus.NEW);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), faculty, teachingStatus, courses);
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)){
			return true;
		}
    	Teacher s = (Teacher) obj;
    	return super.equals(s) && teachingStatus.equals(s.teachingStatus) && faculty.equals(faculty)
    			&& s.courses == this.courses;
	}

	@Override
	public String toString() {
		return "Teacher [courses=" + courses + ", teachingStatus=" + teachingStatus + ", faculty=" + faculty + "]";
	}
	
	public String showInfo() {
		String s = "";
		s += "\nFull name: " + this.getFirstName() + " " + this.getLastName() + "\nWork Experience: " + this.getWorkExperience()
		+ "\nTeaching rank: " + this.getTeachingStatus() + "\nCourses: "+ this.getCourses();
		return s;
	}
	
	
	
    
}