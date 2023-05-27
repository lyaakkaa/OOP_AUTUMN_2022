package main;


import java.util.*;

/**
* @generated
*/
public class Manager extends Employee implements INews, IOrder, IMessage {
    
   
    public Manager() {}
    
    public Manager(String firstName, String lastName, String email, 
    		Integer salary) {
    	super(firstName, lastName, email, salary);
    }
    
    
    //                          Operations                                  

	public boolean createCourse(String name, int credits, String courseCode) {
    	
    	Course newCourse = new Course(name, credits, courseCode);
    	for (Course course: Database.courses) {
        	if (!course.getCourseCode().equals(courseCode)) {
        		Database.courses.add(newCourse);
        		return true;
        	}
    	}
    	return false;
    }
    

    public boolean suggestCourse(Course course, Faculties faculty) {
        //TODO
    	for(User u : Database.users) {
    		if (u instanceof Student) {
    			Student s = (Student) u;
    			if (s.getFaculty().equals(faculty) && !s.getCourses().contains(course)) {
    				course.setIsAvailable(true);
    				return true;
    			}
    		}
    	}
    	return false;
    }

//    public boolean approveRegistration(Student student, Course course) {
//		
//    	if(student.getCurCredits() <= (21 - course.getCredits())) {
//    		return true;
//    	}else {
//    		return false;
//    	}
//    }

    @Override
    public void createNews(String title, String text, Date date, Employee sender) {
		News n = new News(title, text, date, sender);
	}

    @Override
	public void sendOrder(String problem, Order order, TechSupportGuy techSupportGuy) {
		techSupportGuy.addOrder(order);
		order.setOrderStatus(OrderStatus.NEW);
	}
    
	public boolean equals(Object obj) {
    	return super.equals(obj);
    }
	
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}
	
	public String showInfo() {
		String s = "";
		s += "\nFull name: " + this.getFirstName() + " " + this.getLastName() + "\nWork Experience: " + this.getWorkExperience();
		return s;
	}

	@Override
	public void sendMessage(Message message, Employee sendTo) {
		Teacher m = (Teacher) sendTo;
		m.putMessage(message);
	}
}