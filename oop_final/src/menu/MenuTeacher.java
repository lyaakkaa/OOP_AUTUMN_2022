package menu;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import classes.*;
import enums.TimeOfAttestation;

public class MenuTeacher extends MenuUser {
	
	private Teacher teacher;
	
	public MenuTeacher() {
		super.setMenu("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				  "1.View courses\n" + 
				  "2.Manage courses\n" + 
				  "3.Send message\n" + 
				  "4.View news\n"+
				  "5.Put Mark\n" + 
				  "6.View info about students\n" + 
				  "0.Exit\n" +  
				  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
		);
	}
	
	public MenuTeacher(Teacher teacher) {
		this();
		this.teacher = teacher;
		this.hello();
	}

	@Override
	public void hello() {
		System.out.println("Login successfully, hello " + teacher.getName());
		Database.getDatabase().addTimeOfSignIn("Teacher " + teacher.getName() + " " + teacher.getSurname() + "logged in at " + new Date().toString());
	}

	@Override
	public boolean choosingAction(String act) throws IOException, InterruptedException {
		if(act.equals("1")) this.viewCourses();
		else if(act.equals("2")) this.manageCourse();
		else if(act.equals("3")) this.sendMessages();
		else if(act.equals("4")) this.viewNews();
		else if(act.equals("5")) this.putMarks();
		else if(act.equals("6")) this.viewInfoAboutStudents();
		else if (act.equals("0")){
			System.out.println("Goodbye! " + teacher.getName() + " " +  teacher.getSurname());
            return false;
		}
		else {
			System.out.println("You chose the wrong action, try again");
			return true;
		}
		return true;
	}
	
	public Course chooseCourse() throws IOException, InterruptedException {
		Vector <Course> courses = new Vector<Course>(teacher.getCourses());
        System.out.println("Choose course: ");
        int index = 1;
		for(Course c : courses) {
		    System.out.println((index) + ". " + c);
		    index++;
		}
	    int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
	    Course course = courses.get(choice);
	    return course;
	}
	
	public void viewCourses() throws IOException, InterruptedException{
		System.out.println("My courses:");
		Vector <Course> courses = new Vector<Course>(teacher.getCourses());
		
		for(Course course : courses) {
			System.out.println(course);
		}
	}
	
	public void manageCourse() throws IOException, InterruptedException {
	    Course courseToManage = this.chooseCourse();
        System.out.println("What do you want to do?: ");
        System.out.println("1. View files\n2. Add new file\n3. Delete file");
	    int choice = Integer.parseInt(Buffer.reader.readLine());
	    if(choice == 1) viewFiles(courseToManage);
	    else if(choice == 2) addFile(courseToManage);
	    else if(choice == 3) deleteFile(courseToManage);
	}
	
	private void viewFiles(Course course) {
		if(!course.getCourseFiles().isEmpty()) {
			for(File f : course.getCourseFiles()) {
				System.out.println(f.getTitle() + "\nContent of file: " + f.getContent());
			}
		}else System.out.println("You have no files!");
		
	}
	
	private void addFile(Course course) throws IOException{
		System.out.print("Enter file name: ");
        String fileName = Buffer.reader.readLine();
		System.out.print("Enter content of file: ");
        String fileContent = Buffer.reader.readLine();
        File file = new File(fileName, fileContent, course);
        course.addCourseFiles(file);
	}
	
	private void deleteFile(Course course) throws IOException{
		Vector<File> files = new Vector<File>(course.getCourseFiles());
		if(!files.isEmpty()) {
			System.out.println("Choose which file do you want to delete?");
			int index = 1;
			for(File f : files) {
			    System.out.println((index) + ". " + f.getTitle());
			    index++;
			}
		    int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
		    course.getCourseFiles().remove(choice);
		    System.out.println("File has been successfully deleted!");
		}
		System.out.println("There are no course files!");
	}
	
	
	
	public void sendMessages() throws IOException, InterruptedException {
		Buffer.sendMessage(teacher);
	}
	
	public void putMarks() throws IOException, InterruptedException {
	    Course course = this.chooseCourse();
	    
		Vector <Student> studentsOfCourse = new Vector<Student>();
	    for(Student st : Database.getDatabase().getStudents()) {
	    	if(st.getGrades().containsKey(course)) studentsOfCourse.add(st);
	    }
	    
	    System.out.println("Choose student: ");
        int index1 = 1;
		for(Student st : studentsOfCourse) {
		    System.out.println((index1) + ". " + st.getName() + " " + st.getSurname());
		    index1++;
		}
	    int choice = Integer.parseInt(Buffer.reader.readLine()) - 1;
	    Student choosenStudent = studentsOfCourse.get(choice);
	    
	    System.out.println("Enter mark: ");
	    double mark = Double.parseDouble(Buffer.reader.readLine());
	    
	    
	    System.out.println("Choose time of attestation: ");
	    TimeOfAttestation ta = null;
        System.out.println("1. First Attestation\n2. Second Attestation\n3. Final exam");
	    choice = Integer.parseInt(Buffer.reader.readLine());
	    if(choice == 1) ta = TimeOfAttestation.ATTESTATION1;
	    else if(choice == 2) ta = TimeOfAttestation.ATTESTATION2;
	    else if(choice == 3) ta = TimeOfAttestation.FINAL;
	    teacher.putMarks(choosenStudent, course, mark, ta);
	    System.out.println("Your mark has been successfully put!");
	}
	
	public void viewInfoAboutStudents() throws IOException, InterruptedException {
	    Course course = this.chooseCourse();
	    int index = 1;
	    for(Student st : Database.getDatabase().getStudents()) {
	    	if(st.getGrades().containsKey(course)) {
	    		System.out.println(index + ". " + st.getName() + " " + 
	    				st.getSurname() + ", " + st.getId() + ", " + st.getFaculty());
		    	index++;
	    	} 
	    }
	    
	}
	
	
	
	

}

