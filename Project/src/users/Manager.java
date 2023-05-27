package users;

import other.News;

public class Manager extends Employee{
	
	private ManagerType managerType;
	
	public Manager() {
		super();
	}
	
	public Manager(String name, String surname, String password, int salary, double workExperience, ManagerType managerType) {
		super(name, surname, password, salary, workExperience);
		this.setManagerType(managerType);
	}

	public ManagerType getManagerType() {
		return managerType;
	}

	public void setManagerType(ManagerType managerType) {
		this.managerType = managerType;
	}
	
	public String infoStudents() {
		String ans = "";
		int num = 1;
		for(User u : Database.users) {
			if(u instanceof Student) {
				Student s = (Student)u;
				ans += num + ") Student name: " + s.getName()
				+ "\nStudent surname: " + s.getSurname()
				+ "\nStudent id: " + s.getId()
				+ "\nStudent year of study: " + s.getYearOfStudy()
				+ "\nStudent degree: " + s.getDegree()
				+"\nStudent faculty: " + s.getFaculty()
				+"\nStudent speciality: " + s.getSpeciality();
				
				num++;
			}
		}
		return ans;
	}
	
	public String infoTeachers() {
		String ans = "";
		for(User u : Database.users) {
			if(u instanceof Teacher) {
				Teacher t = (Teacher) u;
				ans += t;
				ans += '\n';
			}
		}
		return ans;
	}
	
	public void addNews(String title, String text) {
		News news = new News(title, text);
		if(!Database.news.contains(news)) {
			Database.news.add(news);
			System.out.println("News added");
		}
		else System.out.println("The news already exists");
	}
	
	public void removeNews(String title) {
		for(News news : Database.news) {
			if(news.getTitle().equals(title)) {
				Database.news.remove(news);
				System.out.println("News successfully deleted");
			}
			else System.out.println("News does not exist");
		}
	}
	

	
//	public boolean addCourse(String name, String code, int credits, Faculty faculty, int limitOfStudents, Boolean isElective, Course prereq) {
//		Course course = new Course(name, code, credits, faculty, limitOfStudents, isElective, prereq);
//		if(!Database.courses.contains(course)) {
//			Database.courses.add(course);
//			return true;
//		}
//		return false;
//	}
	
	public boolean addCourse(Course course) {
		if(!Database.courses.contains(course)) {
			Database.courses.add(course);
			return true;
		}
		return false;
	}
	
	public boolean deleteCourse(String name, String code, int credits, Faculty faculty, int limitOfStudents, Boolean isElective, Course prereq) {
		Course course = new Course(name, code, credits, faculty, limitOfStudents, isElective, prereq);
		if(Database.courses.contains(course)) {
			Database.courses.remove(course);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Manager [managerType=" + managerType + "]";
	}
	
	
	
	public boolean approveRegistration(Student student, Course course) {
		for(User u : Database.users) {
			if(u instanceof Student) {
				Student s = (Student) u;
				if(s.getLogin().equals(student.getLogin())) {
					if(course.getLimitOfStudents() > course.getNumOfStudents()) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	
}
