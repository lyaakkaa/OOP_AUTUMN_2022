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
		
//		Student st1 = new Student("Leila", "Bekturgan", "lyaka123", 2021, "21B030788", Degree.BACHELOR, Faculty.FIT, "IS");
//		Manager m = new Manager("Darina", "Aitbayeva", "darina123", 90000,1,ManagerType.OR);
		Student st2 = new Student("Amina", "S", "amina123", 2021, "21B030784", Degree.BACHELOR, Faculty.FIT, "IS");
		Student st3 = new Student("Lyaka", "B", "amina123", 2021, "21B030788", Degree.BACHELOR, Faculty.FIT, "IS");
		Student st4 = new Student("Dari", "A", "amina123", 2021, "21B030754", Degree.BACHELOR, Faculty.FIT, "IS");
		Manager m = new Manager("Akmi", "Sag", "amina123", 90000,1,ManagerType.OR);
		Teacher t = new Teacher("Pakita", "S", "amina123", 2132334, 6.5, Faculty.FIT, 100, TeacherStatus.LECTURER);
		Course course = new Course("OOP", "123", 6, Faculty.FIT, 300, false, null);
		Course course1 = new Course("pp1", "123ss", 6, Faculty.FIT, 300, false, null);
		Database.getDatabase().getUsers().add(st2);
		Database.getDatabase().getUsers().add(st3);
		Database.getDatabase().getUsers().add(st4);
		Database.getDatabase().getUsers().add(m);
		Database.getDatabase().getUsers().add(t);
		Database.getDatabase().getCourses().add(course);
		Database.getDatabase().getCourses().add(course1);
//		for(Course coursee : Database.getDatabase().getCourses()) {
//			System.out.println(coursee);
//		}
		Intranet intranet = new Intranet();
		intranet.run();
	}

}
