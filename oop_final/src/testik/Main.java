package testik;

import java.io.IOException;


import classes.*;
import enums.Degree;
import enums.Faculty;
import enums.ManagerType;
import enums.TeacherStatus;
import exceptions.WrongLoginException;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException, WrongLoginException{

//		Admin a = new Admin("Ainash", "J", "123", 100000, 0.7);
//		Manager m = new Manager("Akmi", "Sag", "qwerty", 90000,1,ManagerType.OR);
//		Student st2 = new Student("Amina", "S", "qwerty", 2021, "21B030784", Degree.BACHELOR, Faculty.FIT, "IS", new Transcript());
//		Student st3 = new Student("Lyaka", "B", "qwerty", 2021, "1", Degree.BACHELOR, Faculty.FIT, "IS", new Transcript());
//		Student st4 = new Student("Dari", "A", "qwerty", 2021, "21B030754", Degree.BACHELOR, Faculty.FIT, "IS", new Transcript());
//		Teacher t = new Teacher("Pakita", "Shamoi", "qwerty", 2132334, 6.5, Faculty.FIT, 100, TeacherStatus.PROFESSOR);
//		Teacher t1 = new Teacher("Bobur", "M", "qwerty", 2132334, 4.5, Faculty.FIT, 60, TeacherStatus.LECTURER);
//		Librarian l = new Librarian("Bakhyt", "Rakh", "qwerty", 59000, 3.4);
//		Course course = new Course("OOP", "123", 6, Faculty.FIT, 300, false, null);
//		Course course1 = new Course("PP1", "527", 4, Faculty.FIT, 250, false, null);
//		Course course2 = new Course("PP2", "935", 5, Faculty.FIT, 350, false, null);
//		Course course3 = new Course("ALGO", "777", 4, Faculty.FIT, 150, false, null);
		
		Student st1 = new Student("Atsushi", "K", "qwerty", 2021, "21B030784", Degree.BACHELOR, Faculty.FIT, "IS", new Transcript());
		Student st2 = new Student("Pakita", "S", "qwerty", 2021, "21B030775", Degree.BACHELOR, Faculty.FIT, "IS", new Transcript());
		Teacher t = new Teacher("Hiroharu", "P", "qwerty", 2132334, 6.5, Faculty.FIT, 100, TeacherStatus.PROFESSOR);
		Course course = new Course("Fuzzy", "123", 6, Faculty.FIT, 300, false, null);
		Manager m = new Manager("A", "Q", "qwerty", 90000,1,ManagerType.OR);
		Database.getDatabase().getUsers().add(m);
		Database.getDatabase().getUsers().add(st2);
		Database.getDatabase().getUsers().add(st1);
		Database.getDatabase().getUsers().add(t);

		Database.getDatabase().getCourses().add(course);

		Intranet intranet = new Intranet();
		intranet.run();
	}

}
