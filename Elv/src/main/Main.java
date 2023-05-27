package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;



public class Main {

	//	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
    public static User signIn() throws IOException {
        for(int i = 0; i < 3; i++) {
        	System.out.println("\nYou have " + (3 - i) + " attempts to login.");
        	System.out.println("Press q to quit");
        	System.out.println("Enter login: ");
        	String in = reader.readLine();
        	if (in.equals("q")) {
        		System.out.println("Bye!");
        		System.exit(0);
        	}
        	for(User u: Database.users) {
	        	if (u.getLogin().equals(in) == true) {
	        		System.out.println("Enter password: ");
	        		String in1 = reader.readLine();
	        		String ps = in1;
	        		if (u.getPassword().equals(ps)) {
	        			System.out.println("Successfully authorized!");
	        			return u;
	        		}
	        		else {
	        			System.out.println("Error! Wrong password!");
	        			continue;
	        		}
	        	}
        	}
        	if (i < 2) System.out.println("Try again!");
        }
        
        System.out.println("No such user:(");
        System.exit(0);
        return null;
    }
    
	public static void main(String[] args) throws IOException{
		//                STUDENTS
		Student s1 = new Student("Jack", "Back", "email123", 2, Faculties.FIT, Degree.BACHELOR);
		Student s2 = new Student("Bob", "KKK", "newmail123", 3, Faculties.MCM, Degree.BACHELOR); 
		Student s3 = new Student("Mike", "Vaz", "gmail", 4, Faculties.ISE, Degree.BACHELOR); 
		Student s4 = new Student("Brown", "Les", "mailru", 1, Faculties.FIT, Degree.BACHELOR); 
		Student s5 = new Student("Jony", "TTT", "emailgoogle", 2, Faculties.FIT, Degree.BACHELOR);
		Database.users.add(s1); Database.users.add(s2); Database.users.add(s3); Database.users.add(s4); Database.users.add(s5);
		
		//                TEACHERS
		Teacher t1 = new Teacher("Teacher111", "235", "emailTeacher", 10000, Faculties.FIT);
		Teacher t2 = new Teacher("Teacher222", "123", "emailTeacher1", 100200, Faculties.FIT);
		Teacher t3 = new Teacher("Teacher333", "New", "emailTeacher2", 110000, Faculties.MCM);
		Teacher t4 = new Teacher("Teacher444", "AAA", "emailTeacher3", 310000, Faculties.FIT);
		Teacher t5 = new Teacher("Teacher555", "BBB", "emailTeacher4", 101000, Faculties.ISE);
		Database.users.add(t1); Database.users.add(t2); Database.users.add(t3); Database.users.add(t4); Database.users.add(t5);
		
		//                TechSupportGuy
		TechSupportGuy techGuy = new TechSupportGuy("Nurbol", "111", "emailTechGuy", 123000);
		Database.users.add(techGuy);
		TechSupportGuy techGuy1 = new TechSupportGuy("Erbol", "111", "emailTechGuy", 123000);
		Database.users.add(techGuy1);
		TechSupportGuy techGuy2 = new TechSupportGuy("Futbol", "111", "emailTechGuy", 123000);
		Database.users.add(techGuy2);
		
		//      		  Manager
		Manager manager = new Manager("FirstManager", "1112", "emailManager", 11223000);
		Database.users.add(manager); 
		
		//      		  Admin
		Admin admin = new Admin("Admin", "First", "emailAdmin", 12312000);
		Database.users.add(admin); 
		
		//      		  Courses
		Course OOP = new Course("Object-Oriented Programming and Design", 3, "CS1");
		Course ADS = new Course("Algorithms and Data Structures", 3, "CS2");
		Course DB = new Course("Databases", 3, "CS3");
		Course ICT = new Course("Information and Communication Technologies", 3, "CS4");
		Course PP2 = new Course("Programming principles 2", 4, "CS5");
		Course PP1 = new Course("Programming principles 1", 4, "CS6");
		Database.courses.add(PP1); Database.courses.add(PP2); Database.courses.add(OOP); Database.courses.add(DB); Database.courses.add(ADS); Database.courses.add(ICT);
		
		//                Saving data
		Database.save();
//		System.out.println(Database.getTeachers());
//		System.out.println(Database.getStudents());
		
		
		
//		Database.saveCourses();
//		Database.loadCourses();
		
		
//		System.exit(0);
		log();
	}

	

	
    public static void log() throws IOException {
    	while(true) {
    		//welcome message
    		String www = "Welcome to the Intranet System!";
    		System.out.print("			 ");
    		for (int i = 0; i <= www.length() + 1; i++) System.out.print("-");
    		System.out.println("\n			| " + www + " |");
    		System.out.print("			 ");
    		for (int i = 0; i <= www.length() + 1; i++) System.out.print("-");
    		//login process
			User u = signIn();
			if (u instanceof Student) {
				System.err.println("			  Welcome to Student's mode " + u.getFirstName() + "!\n");
				studentsMenu((Student) u);
				break;
			}
			else if (u instanceof Teacher) {
				System.err.println("		     Welcome to Teacher's mode " + u.getFirstName() + "!\n");
				teachersMenu((Teacher) u);
				break;
			}
			else if (u instanceof Manager) {
				System.err.println("			 Welcome to Manager's mode " + u.getFirstName() + "!\n");
				managersMenu((Manager) u);
				break;
			}
			else if (u instanceof Admin) {
				System.err.println("			 Welcome to Admin's mode " + u.getFirstName() + "!\n");
				adminsMenu((Admin) u);
				break;
			}
			else if (u instanceof TechSupportGuy) {
				System.err.println("			 Welcome to Executor's mode " + u.getFirstName() + "!\n");
				techSupportGuysMenu((TechSupportGuy) u);
				break;
			}
		}
	}

	// ---------------------------- T E A C H E R -----------------------------
	
	
	
	private static void teachersMenu(Teacher teacher) throws IOException {
		while (true) {
			System.out.println("                    ------------------------------------------------");
	    	System.out.println(   "		[1]         	Information about teacher\n"
	    						+ "		[2]         	View courses\n"
	    						+ "		[3]         	View course Files\n"
	    						+ "		[4]         	Add course file\n"
	    						+ "		[5]        	Delete course file\n"
	    						+ "		[6]         	Add course\n"
	    						+ "		[7]         	Create News\n"
	    						+ "		[8]         	\n"
	    						+ "		[9]         	Send Message\n"
	    						+ "		[10]        	Send Order to Executor\n"
	    						+ "		[11]        	View news\n"
	    						+ "		[12]         	Change password\n"
	    						+ "		[0]         	EXIT");
	    	System.out.println("                    ------------------------------------------------");
	    	int ans = 0;
	    	ans = Integer.parseInt(reader.readLine());
	    	switch(ans) {
	    		case 1: 
	    			System.err.println("Information about teacher: ");
	    			System.out.println(teacher.showInfo());
	    			break;
	    		case 2:
	    			System.out.println(teacher.viewCourses());
	    			break;
	    		case 3: 
	    			viewCourseFiles(teacher);
	    			break;
	    		case 4: 
	    			addCourseFile(teacher);
	    			break;
	    		case 5: 
	    			deleteCourseFile(teacher);
	    			break;
	    		case 6:
	    			System.out.println(addCourse(teacher));
	    			break;
	    		case 7:
	    			createNews(teacher);
	    			break;
	    		case 8:
	    			putMark(teacher);
	    			break;
	    		case 9:
	    			sendMessage(teacher);
	    			break;
	    		case 10:
	    			sendOrder(teacher);
	    			break;
	    		case 11: 
	    			viewNews();;
	    			break;
	    		case 12:
	    			changePassword(teacher);
	    			break;
	    		case 0:
	    			log();
	    			break;	
	    	}
		}
	}


	private static void putMark(Teacher teacher) throws NumberFormatException, IOException {
		System.out.println("Enter the ID of the student: ");
		String id = reader.readLine();
		Student student = null;
		for (User u: Database.users) {
			if (u instanceof Student) {
				if (((Student) u).getId().equals(id)) {
					student = (Student) u;
				}
			}
		}
		
		System.out.println("Enter course ID: ");
		String courseID = reader.readLine();
		Course course = null;
		for (Course c: Database.courses) {
			if (c.getCourseCode().equals(courseID)) {
				course = c;
			}
		}
		if (student.getCourses().contains(course)) {
			System.out.println("Choose number of mark's type: \n1. ATTESTATION 1\n2. ATTESTATION 2\n3. FINAL EXAM");
			int type = Integer.parseInt(reader.readLine());
			MarksType mark = null;
			switch(type) {
				case 1:
					mark = MarksType.ATTESTATION1; 
					break;
				case 2:
					mark = MarksType.ATTESTATION2; 
					break;	
				case 3:
					mark = MarksType.FINAL_EXAM; 
					break;
			}
			
			System.out.println("Enter the number of points: ");
			Double points = Double.parseDouble(reader.readLine());
			try {
				if (teacher.putMark(course, mark, points, student)) {
					System.out.println("Successfully done!");
					Database.save();
				}
				else {
					System.out.println("Error!");
				}
				
			} catch (DeadlineExpired e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Error!");
		}
	}

	//FOR ADMIN, TEACHER, MANAGER
	private static void createNews(Employee e) throws IOException {
		System.out.println("Enter the title of the news: ");
		String title = reader.readLine();
		System.out.println("Enter the text of the news: ");
		String text = reader.readLine();
		Date date = java.util.Calendar.getInstance().getTime(); 
		News n = new News(title, text, date, e);
		Database.news.add(n);
		if (e instanceof Teacher) {
			Teacher t = (Teacher) e;
			t.createNews(title, text, date, t);
		}
		else if (e instanceof Manager) {
			Manager t = (Manager) e;
			t.createNews(title, text, date, t);
		}
		else if (e instanceof Admin) {
			Admin t = (Admin) e;
			t.createNews(title, text, date, t);
		}
		Database.save();
	}
	
	//FOR TEACHER, MANAGER
	private static void sendMessage(Employee e) throws IOException {
		System.out.println("Enter the title of the message: ");
		String title = reader.readLine();
		System.out.println("Enter the text of the message: ");
		String text = reader.readLine();
		Date date = java.util.Calendar.getInstance().getTime(); 
		System.out.println("Enter the login of Manager/Teacher to send message: ");
		String login = reader.readLine();
		for(User u : Database.users) {
			if (u instanceof Manager || u instanceof Teacher) {
				if (u.getLogin().equals(login)) {
					if (e instanceof Teacher) {
						Teacher t = (Teacher) e;
						Message m = new Message(title, text, date, t);
						Employee sendTo = (Employee) u;
						Database.messages.add(m);
						t.sendMessage(m, sendTo);
					}
					else if (e instanceof Manager) {
						Manager t = (Manager) e;
						Employee sendTo = (Employee) u;
						Message m = new Message(title, text, date, t);
						Database.messages.add(m);
						t.sendMessage(m, sendTo);
					}
					Database.save();
				}
			}
		}
	}
	
	//FOR ADMIN TEACHER MANAGER
	private static void sendOrder(Employee e) throws IOException {
		System.out.println("Enter the problem: ");
		String problem = reader.readLine();
		System.out.println("Enter the text of the message: ");
		String text = reader.readLine();
		Date date = java.util.Calendar.getInstance().getTime(); 
		Order m = new Order(OrderStatus.NEW, text, date, e);
		System.out.println("Enter the name or login of Tech Support Guy to send order: ");
		String login = reader.readLine();
		Database.load();
		for(User u : Database.users) {
			if (u instanceof TechSupportGuy) {
				if (u.getLogin().equals(login) || u.getFirstName().equals(login)) {
					TechSupportGuy sendTo = (TechSupportGuy) u;
					Database.orders.add(m);
					Database.save();
					if (e instanceof Teacher) {
						Teacher t = (Teacher) e;
						t.sendOrder(problem, m, sendTo);
					}
					else if (e instanceof Manager) {
						Manager t = (Manager) e;
						t.sendOrder(problem, m, sendTo);
					}
					else if (e instanceof Admin) {
						Admin t = (Admin) e;
						t.sendOrder(problem, m, sendTo);
					}
					else {
						break;
					}
					System.out.println("Done!");
				}
			}
		}
	}
		

	private static String addCourse(Teacher teacher) throws IOException {
		System.out.println("Enter course ID: ");
		String c = reader.readLine();
		for(Course course: Database.courses) {
			if (course.getCourseCode().equals(c)) {
				teacher.addCourse(course);
				Database.save();
				return "New course successfully added!";
			}
		}
		return "Oops! No such course in KBTU";
	}

	private static void deleteCourseFile(Teacher teacher) throws IOException {
		System.out.println("Enter course ID to remove file of this course: ");
		String c = reader.readLine();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				if (course.courseFiles.size() >= 1) {
    					System.out.println("Enter the title of the file: ");
	    				String fileTitle = reader.readLine();
	    				for (File f : course.courseFiles) {
	    					if (f.getFileName().equals(fileTitle)) {
	    						course.courseFiles.remove(f);
	    						System.out.println("File successfully deleted\nCourse has " + course.courseFiles.size() + " files.");
	    						break;
	    					}
	    				}
    				}
    				else {
    					System.out.println("You have no files in this course;");
    				}
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}
	
	private static void addCourseFile(Teacher teacher) throws IOException {
		System.out.println("Enter course ID to add file to this course: ");
		String c = reader.readLine();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				System.out.println("Enter the title of the new file: ");
    				String fileTitle = reader.readLine();
    				System.out.println("Enter the description of the new file: ");
    				String fileDescription = reader.readLine();
    				if (teacher.addCourseFile(course, new File(fileTitle, course, teacher, fileDescription))) {
    					System.out.println("New file successfully added to " + course.getCourseName() + " course!\n");
    				}
    				break;
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}

	private static void viewCourseFiles(Teacher teacher) throws IOException {
		Database.load();
		System.out.println("Enter course ID to see the files of this course: ");
		String c = reader.readLine();
		if (teacher.getCourses().size() >= 1) {
			for (Course course: teacher.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				System.out.println(teacher.showCourseFiles(course));
    				break;
    			}
    		}
		}
		else {
			System.out.println("You have no courses");
		}
	}

	
	
	
	// ---------------------------- S T U D E N T -----------------------------
	
	
	
	private static void studentsMenu(Student student) throws NumberFormatException, IOException{
		while (true) {
			System.out.println("                    ------------------------------------------------");
	    	System.out.println(    " 		[1]		Information about student\n"
	    						+ "		[2]         	View courses\n"
	    						+ "		[3]         	View teachers\n"
	    						+ "		[4]         	View transcript\n"
	    						+ "		[5]         	View Marks\n"
	    						+ "		[6]         	View course files\n"
	    						+ "		[7]         	View news\n"
	    						+ "		[8]         	Registration for disciplines\n"
	    						+ "		[9]         	Change password\n"
	    						+ "		[0]        		EXIT\n");
	    	System.out.println("                    ------------------------------------------------");
	    	int ans = 0;
	    	ans = Integer.parseInt(reader.readLine());
	    	switch(ans) {
	    		case 1: 
	    			System.out.println("Information about student:");
	    			System.out.println(student.showInfo());
	    			break;
	    		case 2:
	    			System.out.println("Courses of " + student.getFirstName() + " " + 
	    					student.getLastName() + "\n" +  student.viewCourses());
	    			break;
	    		case 3: 
	    			System.out.println(student.showTeachers());
	    			break;
	    		case 4: 
	    			System.out.println(student.viewTranscript());
	    			break;
	    		case 5: 
	    			showMarks(student);
	    			break;
	    		case 6:
	    			showCourseFiles(student);
	    			break;
	    		case 7:
	    			viewNews();
	    			break;
	    		case 8:
	    			registerOnCourse(student);
	    			break;
	    		case 9:
	    			changePassword(student);
	    		default:
	    			log();
	    			break;	
	    	}
		}
	}

	private static void changePassword(User u) throws IOException {
		System.out.println("Enter old password: ");
		String old = reader.readLine();
		System.out.println("Enter new password: ");
		String neww = reader.readLine();
		if (u.changePassword(old, neww))
			System.out.println("Password successfully updated!");
		else System.out.println("Error!");
	}

	private static void showMarks(Student student) throws IOException {
		// TODO Auto-generated method stub
		Database.load();
		if (student.getCourses().size() == 0) {
			System.out.println("You have 0 courses");
			return;
		}
		System.out.println("Enter course id to see the marks of this course: ");
		String c = reader.readLine();
		if (student.getCourses() != null) {
			for (Course course: student.getCourses()) {
    			if (c.equals(course.getCourseCode())) {
    				student.viewMarks(course);
    				break;
    			}
    		}
		}
		System.out.println("Error");
	}
	
	private static void showCourseFiles(Student student) throws IOException {
		Database.load();
		if (student.getCourses().size() == 0) {
			System.out.println("You have 0 courses");
			return;
		}
		System.out.println("Enter course id to see the files of this course: ");
		String c = reader.readLine();
		for (Course course: student.getCourses()) {
			System.out.println(course.courseFiles);
			if (c.equals(course.getCourseCode())) {
				student.viewCourseFiles(course);
				break;
			}
		}
		System.out.println("Error");
	}
	
	private static void registerOnCourse(Student student) throws IOException {
		System.out.println("Enter ID of the course for registration: ");
		String c = reader.readLine();
		try {
			if (student.registerOnCourse(c)) {
				System.out.println("New course successfully added!");
			}
			else {
				System.out.println("Error!");
			}
		} catch (CreditsOverflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.save();
	}
	
	
	
	
	//----------------------------- A D M I N ---------------------------------------
	
	
	
	
	
	private static void adminsMenu(Admin admin) throws NumberFormatException, IOException {
		while (true) {
		System.out.println("                    ------------------------------------------------");
    	System.out.println(   "		[1]         	Add user\n"
    						+ "		[2]         	Remove user\n"
    						+ "		[3]         	Show info about admin\n"
    						+ "		[4]         	Create news\n"
    						+ "		[5]         	Add course\n"
    						+ "		[6]        	Send Order to Executor\n"
    						+ "		[7]         	View news\n"
    						+ "		[8]         	Change password\n"
    						+ "		[0]         		EXIT\n");
    	System.out.println("                    ------------------------------------------------");
    	int ans = 0;
    	ans = Integer.parseInt(reader.readLine());
    	switch(ans) {
    		case 1: 
    			addUser(admin);
    			break;
    		case 2:
    			removeUser(admin);
    			break;
    		case 3: 
    			System.out.println(admin.showInfo());
    		case 4: 
    			createNews(admin);
    			break;
    		case 5: 
    			addCourse(admin);
    			break;
    		case 6: 
    			sendOrder(admin);
    			break;
    		case 7: 
    			viewNews();
    			break;
    		case 8:
    			changePassword(admin);
    			break;
    		case 0:
    			log();
    			break;
    	}
		}
	}
	
	//for all users
	private static void viewNews() {
		Database.load();
		if (Database.news.size() == 0) {
			System.out.println("No news");
			return;
		}
		for (News n: Database.news) {
			n.showNewsInfo();
		}
	}

	private static void addCourse(Admin admin) throws NumberFormatException, IOException {
		System.out.println("Enter the name of the course: ");
		String name = reader.readLine();
		System.out.println("Enter the number of credits: ");
		int credits = Integer.parseInt(reader.readLine());
		System.out.println("Enter the ID of the course: ");
		String courseID = reader.readLine();
		admin.addCourse(name, credits, courseID);
		Course c = new Course(name, credits, courseID);
		Database.courses.add(c);
		Database.save();
	}

	private static void removeUser(Admin admin) throws IOException {
		System.out.println("Enter login of the user: ");
		String log = reader.readLine();
		System.out.println("Enter the email: ");
		String email = reader.readLine();
		Database.load();
		for (User u: Database.users) {
			if (u.getLogin().equals(log) && u.getEmail().equals(email)) {
				Database.users.remove(u);
				System.out.println("User successfully removed from KBTU.");
				Database.save();
			}
		}
		System.out.println("Error");
	}

	private static void addUser(Admin admin) throws NumberFormatException, IOException {
		System.out.println("		[1]		Add Student\n"
						 + " 		[2]		Add Teacher\n"
						 + " 		[3]		Add Manager\n"
						 + " 		[4]		Add TechSupportGuy\n"
						 + " 		[5]		Add Admin\n");
		Database.load();
		int res = Integer.parseInt(reader.readLine());
		System.out.println("Enter the first name: ");
		String firstName = reader.readLine();
		System.out.println("Enter the last name: ");
		String lastName = reader.readLine();
		System.out.println("Enter the email: ");
		String email = reader.readLine();
		switch(res) {
			case 1:
				System.out.println("Enter the year of study: ");
				int yearOfStudy = Integer.parseInt(reader.readLine());
				System.out.println("Enter the faculty: ");
				String fac = reader.readLine();
				Faculties f = getFacultiesss(fac);
				System.out.println("Enter the degree: ");
				String deg = reader.readLine();
				Degree d = null;
				switch(fac) {
					case "PHD": d = Degree.PHD; break;
					case "Masters": d = Degree.MASTERS; break;
					case "Bachelor": d = Degree.BACHELOR; break;
					default: d = Degree.BACHELOR; break;
				}
				
				admin.createStudent(firstName, lastName, email, yearOfStudy, f, d);
				System.out.println("New student successfully added!");
				Database.save();
				break;
			case 2:
				System.out.println("Enter the salary: ");
				int salary = Integer.parseInt(reader.readLine());
				
				System.out.println("Enter the faculty: ");
				String fac1 = reader.readLine();
				Faculties f1 = getFacultiesss(fac1);
				
				admin.createTeacher(firstName, lastName, email, salary, f1);
				System.out.println("New teacher successfully added!");
				Database.save();
				break;
				
			case 3:
				System.out.println("Enter the salary for manager: ");
				int salaryM = Integer.parseInt(reader.readLine());
				admin.createManager(firstName, lastName, email, salaryM);
				System.out.println("New manager successfully added!");
				Database.save();
				break;
			case 4:
				System.out.println("Enter the salary for executor: ");
				int salaryT = Integer.parseInt(reader.readLine());
				admin.createTechSupportGuy(firstName, lastName, email, salaryT);
				System.out.println("New executor successfully added!");
				Database.save();
				break;
			case 5:
				System.out.println("Enter the salary for administrator: ");
				int salaryA = Integer.parseInt(reader.readLine());
				admin.createAdmin(firstName, lastName, email, salaryA);
				System.out.println("New admin successfully added!");
				Database.save();
				break;
		}
	}
	
	
	
	
	// ------------------------- T E C H    S U P P O R T    G U Y ---------------------------------
	
	
	
	
	private static void techSupportGuysMenu(TechSupportGuy guy) throws NumberFormatException, IOException {
		while (true) {
		System.out.println("                    ------------------------------------------------");
		System.out.println(   "		[1]         	View new orders\n"
							+ "		[2]         	View accepted orders\n"
							+ "		[3]         	View rejected orders\n"
							+ "		[4]         	View finished orders\n"
							+ "		[5]         	View pending orders\n"
							+ "		[6]         	Delete all orders\n"
							+ "		[7]        	Manage new orders\n"
							+ "		[8]         	View all orders\n"
							+ "		[9]         	Finish order\n"
							+ "		[10]         	Show info about executor\n"
							+ "		[11]         	Change password\n"
							+ "		[0]         		EXIT\n");
		System.out.println("                    ------------------------------------------------");
		int ans = 0;
		ans = Integer.parseInt(reader.readLine());
		switch(ans) {
		case 1: 
			System.out.println(guy.view0rderByStatus(OrderStatus.NEW));
			break;
		case 2:
			System.out.println(guy.view0rderByStatus(OrderStatus.ACCEPTED));
			break;
		case 3: 
			System.out.println(guy.view0rderByStatus(OrderStatus.REJECTED));
			break;
		case 4: 
			System.out.println(guy.view0rderByStatus(OrderStatus.DONE));
			break;
		case 5: 
			System.out.println(guy.view0rderByStatus(OrderStatus.IN_PROGRESS));
			break;
		case 6: 
			guy.clearOrders();
			Database.orders.remove(guy);
			System.out.println("Now you have 0 orders.");
			break;
		case 7: 
			manageNewOrders(guy);
			break;
		case 8: 
			System.out.println(guy.view0rdersInfo());
			break;
		case 9: 
			finishOrder(guy);
			break;
		case 10: 
			System.out.println(guy.showInfo());
			break;
		case 11:
			changePassword(guy);
			break;
		case 0:
			log();
			break;	
		}
	}
	}

	private static void finishOrder(TechSupportGuy guy) throws NumberFormatException, IOException {
		int i = 1;
		System.out.println("Enter the number of order you want to finish.");
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
				System.out.println(i + ". " + order);
				i++;
			}
		}
		int k = 1;
		int res = Integer.parseInt(reader.readLine());
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
				k++;
				if (k == res) {
					guy.updateOrder(OrderStatus.DONE, order);
					System.out.println("You finished one order.");
				}
			}
		}
	}

	private static void manageNewOrders(TechSupportGuy guy) throws NumberFormatException, IOException {
		int cnt = 0;
		if (guy.getOrders().size() >= 1) {
			for(Order order: guy.getOrders()) {
				if (order.getOrderStatus().equals(OrderStatus.NEW)) {
					cnt++;
				}
			}
		}
		else {
			System.out.println("You have 0 new orders.");
			return;
		}
		System.out.println("You have to accept/reject " + cnt + " orders.");
		for(Order order: guy.getOrders()) {
			if (order.getOrderStatus().equals(OrderStatus.NEW)) {
				System.out.println(order);
				System.out.println("Choose 1 option:\n[1] Accept order\n[2] Reject order\n[3] Back");
				int ans = Integer.parseInt(reader.readLine());
				switch(ans) {
					case 1:
						guy.acceptOrder(order);
						System.out.println("You successfully accepted " + order);
						break;
					case 2:
						guy.rejectOrder(order);
						System.out.println("You successfully rejected " + order);
						break;
					case 3:
						return;
				}
			}
		}		
	}
	
	
	
	
	// ------------------------------ M A N A G E R ------------------------------
	
	
	
	
	
	private static void managersMenu(Manager manager) throws NumberFormatException, IOException {
		while (true) {
		System.out.println("                    ------------------------------------------------");
		System.out.println(   "		[1]         	Create course\n"
							+ "		[2]         	Open course for registration\n"
							+ "		[3]        	View news\n"
							+ "		[4]         	Create news\n"
							+ "		[5]         	Send order to executor\n"
							+ "		[6]         	Show info about manager\n"
							+ "		[7]         	Send message\n"
							+ "		[8]         	Change password\n"
							+ "		[0]         		EXIT\n");
		System.out.println("                    ------------------------------------------------");
		int ans = 0;
		ans = Integer.parseInt(reader.readLine());
		switch(ans) {
			case 1: 
				createCourse(manager);
				break;
			case 2: 
				openCourseForRegistration(manager);
				break;
			case 3: 
				viewNews();
				break;
			case 4: 
				createNews(manager);
				break;
			case 5: 
				sendOrder(manager);
				break;
			case 6: 
				System.out.println(manager.showInfo());
				break;
			case 7:
				sendMessage(manager);
			case 8:
				changePassword(manager);
				break;
			case 0:
				log();
				break;	
		}
	}
	}

	private static void createCourse(Manager manager) throws NumberFormatException, IOException {
		System.out.println("Enter the name of the course: ");
		String name = reader.readLine();
		System.out.println("Enter the number of credits: ");
		int credits = Integer.parseInt(reader.readLine());
		System.out.println("Enter the ID of the course: ");
		String courseID = reader.readLine();
		if (manager.createCourse(name, credits, courseID)) {
			Database.courses.add(new Course(name, credits, courseID));
			Database.save();
			System.out.println("Course successfully created!");
		}
		else System.out.println("Error");
		
	}

	private static void openCourseForRegistration(Manager manager) throws IOException {
		System.out.println("Enter course ID: ");
		String id = reader.readLine();
		Course course = null;
		
		for(Course c: Database.courses) {
			if (c.getCourseCode().equals(id)) {
				course = c;
			}
		}
		
		System.out.println("Enter faculty: ");
		String fac = reader.readLine();
		Faculties f = getFacultiesss(fac);
		if (manager.suggestCourse(course, f))
			System.out.println("Course is available now");
		else System.out.println("Error!");
	}
	
	private static Faculties getFacultiesss(String fac) {
		Faculties f = null;
		switch(fac) {
			case "FIT": f = Faculties.FIT; break;
			case "BS": f = Faculties.BS; break;
			case "ISE": f = Faculties.ISE; break;
			case "FGA": f = Faculties.FGA; break;
			case "FEOGI": f = Faculties.FEOGI; break;
			case "KMA": f = Faculties.KMA; break;
			case "MCM": f = Faculties.MCM; break;
		}
		return f;
	}
} 