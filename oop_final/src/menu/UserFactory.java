package menu;

import java.io.IOException;

import classes.Admin;
import classes.Librarian;
import classes.Manager;
import classes.Student;
import classes.Teacher;
import classes.Transcript;
import classes.User;
import enums.Degree;
import enums.Faculty;
import enums.ManagerType;
import enums.TeacherStatus;

public class UserFactory {
	private String name;
	private String surname;
	private String password;
	private int salary;
	private double workExperience;
	private Faculty faculty;
	private TeacherStatus teacherStatus;
	private double rate;
	private String id;
	private int yearOfStudy;
	private Degree degree;
	private String speciality;
	private ManagerType managerType;
	
	public User createNewUser(String uType) throws IOException {
		if(uType.equals("admin")) return createNewAdmin();
		else if(uType.equals("teacher")) return createNewTeacher();
		else if(uType.equals("student")) return createNewStudent();
		else if(uType.equals("manager")) return createNewManager();
		else if(uType.equals("librarian")) return createNewLibrarian();
		return null;
	}
	
	
	public void getGeneralUserInfo() throws IOException {
        System.out.print("Enter ID: ");
        id = Buffer.reader.readLine();
        System.out.print("Enter name: ");
        name = Buffer.reader.readLine();
        System.out.print("Enter surname: ");
        surname = Buffer.reader.readLine();       
        System.out.print("Enter password: ");
        password = Buffer.reader.readLine();
    }
	
	public Admin createNewAdmin() throws IOException{
		getGeneralUserInfo();
		return new Admin(name, surname, password, salary, workExperience);
	}
	
	public Faculty getFaculty() throws IOException{
		System.out.println("1. FIT\n2. FGGE\n3. ISE\n4. FGE\n5. FEOG\n6. BS\n7. KMA\n8. CCE");
		String  facultyName = Buffer.reader.readLine();
		if(facultyName == "1") faculty = Faculty.FIT;
		else if(facultyName == "2") faculty = Faculty.FGGE;
		else if(facultyName == "3") faculty = Faculty.ISE;
		else if(facultyName == "4") faculty = Faculty.FGE;
		else if(facultyName == "5") faculty = Faculty.FEOG;
		else if(facultyName == "6") faculty = Faculty.BS;
		else if(facultyName == "7") faculty = Faculty.KMA;
		else if(facultyName == "8") faculty = Faculty.CCE;
		return faculty;
	}
	
	public Teacher createNewTeacher() throws IOException{
		getGeneralUserInfo();
		System.out.print("Enter teacher's salary: ");
        salary = Integer.parseInt(Buffer.reader.readLine());
        
        System.out.print("Enter teacher's experience: ");
        workExperience = Integer.parseInt(Buffer.reader.readLine());
        
        System.out.println("Choose teacher's faculty: ");
        faculty = getFaculty();
        
        System.out.print("Enter employee's rate: ");
        rate = Double.parseDouble(Buffer.reader.readLine());
        
		System.out.println("Choose teacher's status: ");
        System.out.println("1. Profesor\n2. Senior Lecturer\n3. Lectorer\n4. Assistant\n");
		String type = Buffer.reader.readLine();
        if(type == "1") teacherStatus = TeacherStatus.PROFESSOR;
		else if(type == "2") teacherStatus = TeacherStatus.SENIOR_LECTURER;
		else if(type == "3") teacherStatus = TeacherStatus.LECTURER;
		else if(type == "4") teacherStatus = TeacherStatus.ASSISTANT;
        
		return new Teacher(name, surname, password, salary, workExperience, faculty, rate, teacherStatus);
	}
	
	public Student createNewStudent() throws IOException{
		getGeneralUserInfo();
		System.out.print("Enter student's year of study: ");
		yearOfStudy = Integer.parseInt(Buffer.reader.readLine());
		
        System.out.println("Choose student's degree: ");
        System.out.println("1. Bachelor\n2. Master\n3. PhD");
		String type = Buffer.reader.readLine();
		if(type == "1") degree = Degree.BACHELOR;
		else if(type == "2") degree = Degree.MASTER;
		else if(type == "3") degree = Degree.PHD;
		
        System.out.println("Choose student's faculty: ");
        faculty = getFaculty();
        
        System.out.print("Enter student's specialty: ");
        speciality = Buffer.reader.readLine();
        
		return new Student(name, surname, password, yearOfStudy, id, degree, faculty, speciality, new Transcript());
        
	}
	public Manager createNewManager() throws IOException{
		getGeneralUserInfo();
		System.out.print("Enter manager's salary: ");
        salary = Integer.parseInt(Buffer.reader.readLine());
        
        System.out.print("Enter manager's experience: ");
        workExperience = Integer.parseInt(Buffer.reader.readLine());
        
        System.out.println("Choose manager's degree: ");
        System.out.println("1. DEPARTMENTS\n2. OR\n");
		String type = Buffer.reader.readLine();
		if(type.equals("1")) managerType = ManagerType.DEPARTMENTS;
		else if(type.equals("2")) managerType = ManagerType.OR;

		return new Manager(name, surname, password, salary, workExperience, managerType);
	}
	
	public Librarian createNewLibrarian() throws IOException{
		getGeneralUserInfo();
		System.out.print("Enter librarian's salary: ");
        salary = Integer.parseInt(Buffer.reader.readLine());
        
        System.out.print("Enter librarian's experience: ");
        workExperience = Integer.parseInt(Buffer.reader.readLine());

		return new Librarian(name, surname, password, salary, workExperience);
	}
}