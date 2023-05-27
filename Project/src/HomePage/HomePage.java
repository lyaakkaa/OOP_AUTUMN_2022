package HomePage;

import java.io.*;

import users.*;


public class HomePage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String title = """
               --------------------------------kbtu-kazakh british technical university--------------------------------
               Weclome!
               1. Login
               2. Logout""";
		
		Student s1 = new Student("Amina", "Seidakhmetova", "amina123", 2, "21B03043", Degree.BACHELOR, Faculty.FIT, "IS");
		Database.users.add(s1);
		
		while(true) {
			
			System.out.println(title);
	        System.out.println("Press q to quit");
	        System.out.println("Enter login: ");
	        String input = reader.readLine();
	        if (input.equals("q")) {
	        	System.out.println("Bye!");
	        	System.exit(0);
	        }
	        for(User u: Database.users) {
		        if (u.getLogin().equals(input) == true) {
		        	System.out.println("Enter password: ");
		        	String password = reader.readLine();
		  
		        	if (u.getPassword().equals(password)) {
		        		System.out.println("Successfully authorized!");
		        	}
		        	else {
		        		System.out.println("Error! Wrong password!");
		        	}
		        }
		        else {
		        	System.out.println("Login entered incorrectly");
		        }
	        }
	   
		}

	}

}
