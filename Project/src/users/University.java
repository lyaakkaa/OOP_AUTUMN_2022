package users;


import other.TimeOfAttestation;

public class University {

	public static void main(String[] args) {


		Student s1 = new Student("Amina", "Seidakhmetova", "amina123", 2, "21B03043", Degree.BACHELOR, Faculty.FIT, "IS");
		Student s2 = new Student("Leila", "Bekturgan", "lyaka123", 2, "21B0304323", Degree.BACHELOR, Faculty.FIT, "IS");
		Course c = new Course("OOP", "2186CFR", 4, Faculty.FIT, 5, false, null);
		Course c2 = new Course("Disc", "21dasdsadad", 2, Faculty.FIT,1, false, null);

		Course c1 = new Course("Algo", "21dasdasd", 4, Faculty.FIT,1, false, c2);
		
		
		Manager m = new Manager("Nazym", "Kaidarova", "nazym123", 1312321, 4.6, ManagerType.DEPARTMENTS);
		Teacher t1 = new Teacher("Pakita", "Shamoi", "pakita123", 120000, 4.5,  Faculty.FIT, 45, TeacherStatus.PROFESSOR);
	
		m.addCourse(c);
		m.addCourse(c1);
		m.addCourse(c2);
		
		//Database.courses.add(c);
		//Database.courses.add(c1);
		//Database.courses.add(c2);
		
		t1.addCourse(c);
		t1.addCourse(c1);
		t1.addCourse(c2);
		
		
		System.out.println(s1.registerToCourse(c));
		System.out.println(s1.registerToCourse(c1));
		System.out.println(s1.registerToCourse(c2));
		System.out.println(m.approveRegistration(s2, c));
		
		
		t1.putMarks(s1, c, 25, TimeOfAttestation.ATTESTATION1);
		t1.putMarks(s1, c, 2, TimeOfAttestation.ATTESTATION1);
		t1.putMarks(s1, c, 30, TimeOfAttestation.ATTESTATION2);
		
		t1.putMarks(s1, c2, 25, TimeOfAttestation.ATTESTATION1);
		t1.putMarks(s1, c2, 30, TimeOfAttestation.ATTESTATION2);
		
		


//		System.out.println(t1.putMarks(s1, c, 45, TimeOfAttestation.ATTESTATION1));
//		
//		System.out.println(t1.putMarks(s1, c1, 30, TimeOfAttestation.ATTESTATION1));
//		System.out.println(t1.putMarks(s1, c1, 2, TimeOfAttestation.ATTESTATION1));
//		System.out.println(t1.putMarks(s1, c1, 5, TimeOfAttestation.ATTESTATION2));

		System.out.println(s1.viewGrades());
		
		System.out.println(s1.registerToCourse(c1));
		
		t1.putMarks(s1, c1, 25, TimeOfAttestation.ATTESTATION1);
		t1.putMarks(s1, c1, 30, TimeOfAttestation.ATTESTATION2);
		System.out.println(s1.viewGrades());

	}
}