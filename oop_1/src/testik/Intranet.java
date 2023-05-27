package testik;

import java.io.IOException;
import java.util.Map;

import classes.*;
import exceptions.*;
import menu.*;



public class Intranet {
	
	public Intranet() throws InterruptedException {
        helloMessage();
//        Database.loading();
    }
	
	public void helloMessage() throws InterruptedException{
		System.out.println("𝐖𝐞𝐥𝐜𝐨𝐦𝐞 𝐭𝐨 𝐢𝐧𝐭𝐫𝐚𝐧𝐞𝐭 𝐬𝐲𝐬𝐭𝐞𝐦 🌈");
	}
	
	public void run() throws IOException, WrongLoginException, InterruptedException{
		String user = selectTypeOfUser();
		try {
			logInSystem(user);
		}
		catch(WrongLoginException exc) {
            System.out.println(exc.getMessage());
            run();
        }
	}
	
	public String selectTypeOfUser() throws IOException, InterruptedException{
		System.out.println("\nSelect the type of user you want to log in with: ");
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println("1.Admin");
		System.out.println("2.Manager");
		System.out.println("3.Librarian");
		System.out.println("4.Teacher");
		System.out.println("5.Student");
		System.out.println("0.Exit");
		System.out.println("~~~~~~~~~~~~~~~~~");
		
		String type = Buffer.reader.readLine();
		
		String selectTypeOfUserr = "";
		
		if(type.equals("1")) selectTypeOfUserr = "admin";
		else if(type.equals("2")) selectTypeOfUserr = "manager";
		else if(type.equals("3")) selectTypeOfUserr = "librarian";
		else if(type.equals("4")) selectTypeOfUserr = "teacher";
		else if(type.equals("5")) selectTypeOfUserr = "student";
		else if(type.equals("0")) {
			this.ending();
			selectTypeOfUserr = "finish";
			return selectTypeOfUserr;
		}
		else {
			selectTypeOfUserr = "notUser";
		}
		return selectTypeOfUserr;

	}
	
	
	 public void ending() throws InterruptedException, IOException {
	        System.out.print("Exiting the UNI system");
	        Thread.sleep(800);
	        System.out.println("Goodbye dear user!");
	        Database.refresh();
	        System.exit(0);
	 }
	 
	 public void logInSystem(String user) throws IOException, WrongLoginException, InterruptedException {
	        if(user.equals("notUser")) {
	            throw new WrongLoginException("Non-existent user, please try again.");
	        }
	        User newUser = null;
	        boolean succeeded = false;

	        System.out.println("You are log in as " + user + ".");
	        System.out.print("Enter login: ");
	        String login = Buffer.reader.readLine();
	        System.out.print("Enter password: ");
	        String password = Buffer.reader.readLine();

	        for(User u : Database.getDatabase().getUsers()) {
	        	if(u.getLogin().equals(login)) {
	        		if(u.getPassword().equals(password)) {
	        			newUser = u;
	        			succeeded = true;
	        		}
	        		else {
	        			throw new WrongLoginException("Wrong password, please try again!");
	        		}
	        	}
	        }
	        if(!succeeded) {
	            throw new WrongLoginException("User with this login was not found");
	        }
	        if(beginUser(newUser)) {
	            run();
	        } else {
	            ending();
	        }
	}
	 
	 public boolean beginUser(User u) throws InterruptedException, IOException {
	        MenuUser menu = null;

	        if(u instanceof Admin) {
	            menu = new MenuAdmin((Admin) u);
	        }
	        else if(u instanceof Manager) {
	            menu = new MenuManager((Manager) u);
	        }
	        else if(u instanceof Teacher) {
	            menu = new MenuTeacher((Teacher) u);
	        }
	        else if(u instanceof Student) {
	            menu = new MenuStudent((Student) u);
	        }
	        else if(u instanceof Librarian) {
	            menu = new MenuLibrarian((Librarian) u);
	        }

	        assert(menu != null);
	        return menu.run();
	  }
	 
	 
	 
	 
	 

	


}
