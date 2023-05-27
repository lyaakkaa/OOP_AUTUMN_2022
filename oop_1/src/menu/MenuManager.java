
package menu;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import classes.Course;
import classes.Database;
import classes.File;
import classes.Lesson;
import classes.Manager;
import classes.Mark;
import classes.Student;
import classes.Teacher;
import comparator.*;
import enums.DayOfWeek;
import enums.Faculty;
import enums.LessonType;
public class MenuManager extends MenuUser {
	private Manager manager;
	
	public MenuManager() {
		super.setMenu("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				  "1.Approve student registration\n" + 
				  "2.Assign a course to a teacher\n" + 
				  "3.Add course\n" +
				  "4.View students\n" + 
				  "5.View teachers\n" +
				  "6.Manage news\n" + 
				  "7.Create report\n" + 
				  "8.Read messages\n" + 
				  "9.Send message\n" + 
				  "0.Exit\n" +
				  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				);
	}
	
	public MenuManager(Manager m) {
		this();
		this.manager = m;
		this.hello();
	}

	@Override
	public void hello() {
		System.out.println("Login successfully, hello " + manager.getName() + " " + manager.getSurname());
		Database.getDatabase().addTimeOfSignIn("Manager " + manager.getName() + " " + manager.getSurname() + "logged in at " + new Date().toString());
	}

	@Override
	public boolean choosingAction(String act) throws IOException, InterruptedException {
		if(act.equals("1")) this.approveStudentRegistration();
		else if(act.equals("2")) this.assignCourseToTeacher();
		else if(act.equals("3")) this.addCourse();
		else if(act.equals("4")) this.viewStudents();
		else if(act.equals("5")) this.viewTeachers();
		else if(act.equals("6")) this.manageNews();
		else if(act.equals("7")) this.createReport();
		else if(act.equals("8")) this.readMessages();
		else if(act.equals("9")) this.sendMessages();
		else if (act.equals("0")){
			System.out.println("Goodbye! " + manager.getName() + " " + manager.getSurname());
            return false;
		}
		else {
			System.out.println("You chose the wrong action, try again");
			return true;
		}
		
		return true;
	}
	
	public void approveStudentRegistration() throws InterruptedException, IOException {
		HashMap <Student, Course> porc = Database.getDatabase().getPermissionOfRegistrationCourse();
		if(porc.size() != 0) {
			System.out.println("Incoming Course Registration Requests: ");
			int index = 1;
			
			for(Map.Entry<Student, Course> req: porc.entrySet()) {
				System.out.println(index + ") " + req.getKey().getName() + " " + req.getKey().getSurname());
	            index++;
			}
			
			System.out.println("Select a student: ");
			int numChoice = Buffer.numAct(Buffer.reader.readLine());
			
			if(Buffer.checkRange(numChoice - 1, 0, porc.size() - 1)) {
				int i = 0;
				for(Map.Entry<Student, Course> req: porc.entrySet()) {
					if(i == numChoice - 1) {
						System.out.println("Selected student: " + req.getKey().getName() + " " + req.getKey().getSurname());
						startStudentRegistration(req.getKey(), req.getValue());
			            break;
					}
					i++;
		            
				}
			}
			else {
				System.out.println("Enter the correct operation!");
			}
			return;
		}
		System.out.println("No incoming requests(");
		
	}
	
	public void startStudentRegistration(Student student, Course course) throws IOException, InterruptedException {
		System.out.println("Selected course: " + course.getName());
		System.out.println("\nChoose the action:\n1. Accept\n2. Reject");
		String choice = Buffer.reader.readLine();
		
		if(choice.equals("1")) {
            System.out.println("Request for Course Registration was accepted.");
            acceptRequestOfCourseRegistration(student, course);
            student.getGrades().put(course, new Mark());
            Database.getDatabase().getPermissionOfRegistrationCourse().remove(student);
        }
        else if(choice.equals("2")) {
            System.out.println("Request was rejected");
            Database.getDatabase().getPermissionOfRegistrationCourse().remove(student);
        } else {
            System.out.println("Wrong action");
        }
		
	}
	
	public void  acceptRequestOfCourseRegistration(Student student, Course course) throws IOException {
		
	}
	
	public void assignCourseToTeacher()  throws IOException  {
		Vector <Course> courses = Database.getDatabase().getCourses();
		Vector <Teacher> teachers = Database.getDatabase().getTeachers();
		int i = 1;
		System.out.println("Select the teacher you want to add the course to: ");
		for(Teacher t: teachers) {
			System.out.println(i + ")" + t.getName() + " " + t.getSurname() + " " + t.getFaculty());
		}
		i = 1;
		int selectedTeacher = Buffer.numAct(Buffer.reader.readLine());
		System.out.println("Select the course you want to add to the teacher's list of courses: ");
		for(Course course : courses) {
			System.out.println(i + ")" + course);
			i++;
		}
		int selectedCourse = Buffer.numAct(Buffer.reader.readLine());
		
		if(!teachers.get(selectedTeacher - 1).getCourses().contains(courses.get(selectedCourse - 1))) {
			teachers.get(selectedTeacher - 1).getCourses().add(courses.get(selectedCourse - 1));
			System.out.println("The course has been successfully added to the teacher!");
		}
		else{
			System.out.println("The selected teacher already has such a course");
		}
	}
	
	public void addCourse() throws IOException {
		System.out.println("Enter the name of the new course: ");
		String name = Buffer.reader.readLine();
		System.out.println("Enter the code of the new course: ");
		String code = Buffer.reader.readLine();
		System.out.println("Enter the number of credits of the new course: ");
		int credits = Buffer.numAct(Buffer.reader.readLine());
		System.out.println("Enter the faculty of the new course: ");
		int index = 1;
		for(Faculty fac : Database.getDatabase().getFaculties()) {
			System.out.println(index + ")" + fac);
			index++;
		}
		int selectedFac = Buffer.numAct(Buffer.reader.readLine()); 
		Faculty faculty = Database.getDatabase().getFaculties().get(selectedFac - 1);
		System.out.println("Enter the limit of student of the new course: ");
		int limit = Integer.parseInt(Buffer.reader.readLine());
		int limitOfStudents = 0;
		if(limit > 0 && limit <= 300) {
			limitOfStudents = limit;
		}
		else {
			System.out.println("Please enter a number between 0 and 300!");
		}
		System.out.println("Is the created course an elective?");
		String elective = Buffer.reader.readLine();
		boolean isElective = false;
		if(elective == "true") {
			isElective = true;
		}
		
		System.out.println("Enter the prerequisite of the new course, if there are no prerequisites, press 0: ");
		index = 1;
		for(Course course : Database.getDatabase().getCourses()) {
			System.out.println(index + ")" + course);
			index++;
		}
		Course prereq;
		int selectedPrereq = Integer.parseInt(Buffer.reader.readLine());
		if(selectedPrereq == 0) {
			prereq = null;
		}
		else prereq = Database.getDatabase().getCourses().get(selectedPrereq - 1);
		
		
		Vector <Lesson> lessons = new Vector <Lesson>();
		System.out.print("Select the number of lessons per week: ");
		int numLessons = Integer.parseInt(Buffer.reader.readLine());
		
		for(int i = 0; i < numLessons; i++) {
			System.out.println("Select the lesson type: ");
			System.out.println("1.Lecture");
			System.out.println("2.Practice");
			System.out.println("3.Labaratoty");
			
			String choosenType = Buffer.reader.readLine();
			LessonType lt;
			if(choosenType == "1") lt = LessonType.LECTURE;
			else if(choosenType == "2") lt = LessonType.PRACTICE;
			else if(choosenType == "3") lt = LessonType.LAB;
			else {
				System.out.println("You cannot choose more or less than 3");
				return;
			}
			System.out.println("Select weekday of lesson: ");
			System.out.println("\n1. Monday 2. Tuesday 3. Wednesday 4. Thursday 5. Friday 6. Saturday");
			String chosenDay = Buffer.reader.readLine();
			DayOfWeek dow = null;
			if(chosenDay ==  "1") dow = DayOfWeek.MON;
			else if(chosenDay ==  "2") dow = DayOfWeek.TUE;
			else if(chosenDay ==  "3") dow = DayOfWeek.WED;
			else if(chosenDay ==  "4") dow = DayOfWeek.THU;
			else if(chosenDay ==  "5") dow = DayOfWeek.FRI;
			else if(chosenDay ==  "6") dow = DayOfWeek.SAT;
			else {
				System.out.println("Choose a number that is between 1 and 6!");
			}
			System.out.print("Enter the start time of the class, separated by a colon: ");
	        String [] start = Buffer.reader.readLine().split(":");
	        System.out.print("Enter the end time of the class, separated by a colon: ");
	        String [] end = Buffer.reader.readLine().split(":");
	        
	        Lesson lesson = new Lesson(lt, dow, Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(end[0]), Integer.parseInt(end[1]));
	        lessons.add(lesson);		
		}
		Course newCourse= new Course(name, code, credits, faculty, limitOfStudents, isElective, null,  prereq, null, lessons);
		manager.addCourse(newCourse);
		System.out.println("You have successfully added a course");
	}
	
	public void viewStudents() throws IOException{
		Vector <Student> students = Database.getDatabase().getStudents();
		System.out.println("How do you want to display them?");
		System.out.println("Sort it by: ");
		System.out.println("1.By login");
		System.out.println("2.By gpa");
		System.out.println("3.By id");
		
		String type = Buffer.reader.readLine();
		
		if(type == "1") {
			students.sort(new LoginComparator());
		}
		else if(type == "2") {
			students.sort(new ComparatorGPA());
		}
		else if(type == "3") {
			students.sort(new IdComparator());
		}
		System.out.println("List of system students: ");
		int index = 1;
		for(Student s : students) {
			System.out.println(index + ")" + s.getName() + " " + s.getSurname() + " " + s.getGPA());
		}
	}
	
	public void viewTeachers() throws IOException{
		Vector <Teacher> teachers = Database.getDatabase().getTeachers();
		System.out.println("How do you want to display them?");
		System.out.println("Sort it by: ");
		System.out.println("1.By login");
		System.out.println("2.By Work experience");
		System.out.println("3.By salary");
		
		String type = Buffer.reader.readLine();
		
		if(type == "1") {
			teachers.sort(new LoginComparator());
		}
		else if(type == "2") {
			teachers.sort(new WorkExperienceComparator());
		}
		else if(type == "3") {
			teachers.sort(new SalaryComparator());
		}
		System.out.println("List of system teachers: ");
		int index = 1;
		for(Teacher t : teachers) {
			System.out.println(index + ")" + t.getName() + " " + t.getSurname() + " " + "WE: " + t.getWorkExperience() + " salary: " + t.getSalary());
		}
	}
	
	public void manageNews() {
		
	}
	
	public void createReport() throws IOException{
		System.out.println("Select the course for which you want to receive a statistical report: ");
		int index = 1;
		for(Course course : Database.getDatabase().getCourses()) {
			System.out.println(index + ")" + course);
			index++;
		}
		String chosenCourse = Buffer.reader.readLine();
		Course reportCourse;
		if(Buffer.checkRange(Integer.parseInt(chosenCourse), 0, Database.getDatabase().getCourses().size())) {
			reportCourse = Database.getDatabase().getCourses().get(Integer.parseInt(chosenCourse) - 1);
			
		}
		else {
			System.out.println("Choose the right operator");
			return;
		}
		
		int numOfStudents = 0;
		double maxiGPA = -99999;
		double miniGPA = 99999;
		int retakedStudents = 0;
		for(Student student : Database.getDatabase().getStudents()) {
			if(student.getGrades().containsKey(reportCourse)) {
				numOfStudents++;
			}
			if(student.getGrades().containsKey(reportCourse) && student.getGrades().get(reportCourse).getGpa() > maxiGPA) {
				maxiGPA = student.getGrades().get(reportCourse).getGpa();
			}
			if(student.getGrades().containsKey(reportCourse) && student.getGrades().get(reportCourse).getGpa() < miniGPA) {
				miniGPA = student.getGrades().get(reportCourse).getGpa();
			}
			if(student.getGrades().containsKey(reportCourse) && student.getGrades().get(reportCourse).getTotal() < 50) {
				retakedStudents++;
			}
		}
		
		manager.getReport(reportCourse, numOfStudents, maxiGPA, miniGPA, retakedStudents);
		 System.out.println("Report added successfully!");
		
	}
	
	public void readMessages() {
		
	}
	
	public void sendMessages() {
		
	}

}