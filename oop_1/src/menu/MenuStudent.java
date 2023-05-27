package menu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import classes.Book;
import classes.Course;
import classes.Database;
import classes.Mark;
import classes.Student;
import classes.Teacher;

public class MenuStudent extends MenuUser{
	private Student student;
	
	public MenuStudent() {
		super.setMenu("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					  "1.View data about me\n" + 
					  "2.View all courses\n" + 
					  "3.Register for a course\n"+
					  "4.View transcript\n" +
					  "5.Download transcript\n" + 
					  "6.Rate teacher\n" +
					  "7.View news\n" + 
					  "8.Take a book\n" + 
					  "9.Return a book\n" + 
					  "0.Exit\n" +
					  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
		);
		
	}
	
	public MenuStudent(Student student) {
		this();
		this.student = student;
		hello();
	}

	@Override
	public void hello() {
		System.out.println("Login successfully, hello " + student.getName());
		Database.getDatabase().addTimeOfSignIn("Student " + student.getName() + " " + student.getSurname() + "logged in at " + new Date().toString());
		
	}

	@Override
	public boolean choosingAction(String act) throws IOException, InterruptedException {
		if(act.equals("1")) viewDataAboutMe();
		else if(act.equals("2")) viewCourses();
		else if(act.equals("3")) registerForCourse();
		else if(act.equals("4")) viewTranscript();
		else if(act.equals("5")) downloadTranscript();
		else if(act.equals("6")) rateTeacher();
		else if(act.equals("7")) viewNews();
		else if(act.equals("8")) orderBook();
		else if(act.equals("9")) returnBook();
		else if (act.equals("0")){
			System.out.println("Goodbye! " + student.getName() + " " + student.getSurname());
            return false;
		}
		else {
			System.out.println("You chose the wrong action, try again");
			return true;
		}
		
		return true;
	}
	
	public void viewDataAboutMe() throws InterruptedException{
		 System.out.println("Student " + student.getId() + " : "+ student.getName() + " " + student.getSurname());
	     System.out.println("Faculty - " + student.getFaculty() + ";\nSpecialty - " + student.getSpeciality() 
	     + ";\nGPA - " + 0 + ";\nYear of study: " + student.getYearOfStudy() + ";\nDegree - " + student.getDegree());
	 }
	 
	 public void viewCourses() throws IOException, InterruptedException {
	   System.out.println("\nList of student's courses: ");
       int index = 1;
	 	for(Course c : student.getGrades().keySet()) {
           System.out.println((index) + ". " + c);
           index++;
	 	}
	 }

	 public void registerForCourse() throws IOException, InterruptedException {
		 int totalCredits = student.getTotalCredits();
		 Vector <Course> courses = Database.getDatabase().getCourses();
		 System.out.println("Total taken credits: " + totalCredits + ". It can't be more than 21!");
		 System.out.println("List of eligible courses: ");
		 int index = 1;
		 for(Course course : courses) {
			 System.out.println(index + ")" + course); 
			 index++;
		 }
		 System.out.print("\nChoose the course to register: ");
		 int choice = Buffer.numAct(Buffer.reader.readLine());
		 if(choice < 1 || choice > courses.size()) {
			 System.out.println("Invalid operation");
			 return;
		 }
		 Course wantedCourse = Database.getDatabase().getCourses().get(choice - 1);
		 if(student.getGrades().containsKey(wantedCourse)) {
			 System.out.println("You already have such a course.");
			 return;
		 }
//		 if(Database.getDatabase().getPermissionOfRegistrationCourse().get(student).getName().equals(wantedCourse.getName())) {
//			 System.out.println("You have already sent a request, wait for the manager's response!");
//			 return;
//		 }
		 if(wantedCourse.getCredits() + totalCredits > 21) {
			 System.out.println("Attention! You have exceeded the number of credits!");
	         return;
		 }
		 Database.getDatabase().getPermissionOfRegistrationCourse().put(student, wantedCourse);
		 System.out.println("Your request has been successfully completed. Wait for manager's approval.");
	 }
	 
	 public void viewTranscript() {
		 
		 System.out.println("Your overall GPA: " + student.getTranscript().calculateGPA());
	        System.out.println("Course, First attestation, Second attestation, Final points, Overall, Letter, GPA");
	        for(Map.Entry<Course, Mark> entry : student.getGrades().entrySet()) {
	            int index = 1;
	            System.out.println(index + ") " + entry.getKey() + ": " + entry.getValue());
	            index++;
	            System.out.println();
	        }
	 }
	 
	 public void downloadTranscript() {
		 try {
			 String file = student.getName() + "'s_" + "transcript" + ".txt";
			 PrintWriter pw = new PrintWriter(new FileWriter(file),true); 
			 int index = 1;
			 for(Map.Entry<Course, Mark> item : student.getGrades().entrySet()) {
				 pw.write(index +") "+item.getKey() + ": " + item.getValue().getAttestation1() + 
						 ", " + item.getValue().getAttestation2() + ", " + item.getValue().getFinalExam() + "\n");
				 index++;
			 }
			 pw.close();
			 System.out.println("Look at the transcript in the files");
		 }
		 catch(IOException exc) {
	            System.out.println("Error message: " + exc.getMessage());
		 }
	 }
	 
	 public void rateTeacher() throws IOException {
		 @SuppressWarnings("unchecked")
		Vector<Course> courses = (Vector<Course>) student.getGrades().keySet();
		 if(!courses.isEmpty()) {
			System.out.println("Your courses: ");
			int index = 1;
			for(Course c : courses) {
			    System.out.println((index) + ". " + c);
			    index++;
			}
		     System.out.println("\nWhich course teacher do you want to grade: ");
		     int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
		     
		     Vector<Teacher> teachers = new Vector<>(Database.getDatabase().getTeachersOfCourse(courses.get(choice)));
		     if (teachers.isEmpty()) {
		         System.out.println("\nNo teachers for this course");
		         return;
		     }
		    int index2 = 1;
			for(Teacher t : teachers) {
			    System.out.println((index2) + ". " + t.getName() + " " + t.getSurname());
			    index2++;
			}
		     System.out.print("Choose teacher: ");
		     choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
		     System.out.print("Enter your rating: ");
		     double r = Double.parseDouble(Buffer.reader.readLine());
		     try {
		         teachers.get(choice).setRate(r);
		     } catch (IndexOutOfBoundsException exc) {
		         System.out.println("Error rate");
		         return;
		     }
		     System.out.println("Your rate has been successfully given!");
		     return;
		 }else System.out.println("You don't register any courses :(");
	 }
	 
	 public void orderBook() throws IOException {
		 System.out.println("Which book do you want to take?:");
		 int index = 1;
		 for(Book b : Database.getDatabase().getBooks().keySet()) {
			 System.out.println((index) + ". " + b);
			 index++;
		 }
		 int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
		 Book newBook = Database.getDatabase().getNeededBooks(choice, "giveToStudent");
		 student.addBooks(newBook);
		 System.out.println("You successfully get a book!");
	 }
	 
	 public void returnBook() throws IOException {
		 System.out.println("Which book do you want to return:");
		 int index = 1;
		 for(Book b : student.getBooks()) {
			 System.out.println((index) + ". " + b);
			 index++;
		 }
		 int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
		 student.getBooks().remove(student.getBooks().get(choice));
		 Database.getDatabase().getNeededBooks(choice, "getFromStudent");
		 System.out.println("The book successfully returned");
     }


}
