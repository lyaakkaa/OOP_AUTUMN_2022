package menu;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import classes.Admin;
import classes.Database;
import classes.User;

public class MenuAdmin extends MenuUser{
	
	private Admin admin;
	
	public MenuAdmin() {
		super.setMenu("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				  "1.View users\n" + 
				  "2.Add user\n" + 
				  "3.Remove user\n"+
				  "4.Update user" + 
				  "5.View log files about user actions\n" +
				  "0.Exit\n" +  
				  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				);
	}
	
	public MenuAdmin(Admin admin) {
		this();
		this.admin = admin;
		this.hello();
	}

	@Override
	public void hello() {
		System.out.println("Login successfully, hello " + admin.getName());
		Database.getDatabase().addTimeOfSignIn("Admin " + admin.getName() + " " + admin.getSurname() + "logged in at " + new Date().toString());
	}


	@Override
	public boolean choosingAction(String act) throws IOException, InterruptedException {
		if(act.equals("1")) this.viewUsers();
		else if(act.equals("2")) this.addUser();
		else if(act.equals("3")) this.removeUser();
		else if(act.equals("4")) this.updateUser();
		else if(act.equals("5")) this.viewTimeOfSignIn();
		else if (act.equals("0")){
			System.out.println("Goodbye! " + admin.getName() + admin.getSurname());
            return false;
		}
		else {
			System.out.println("You chose the wrong action, try again");
			return true;
		}
		return true;
	}
	
	private User kindOfUser() throws IOException, InterruptedException{
		System.out.println("Choose type of user: ");
		System.out.println("1. Admin\n2. Manager\n3. Teacher\n4. Student\n5. Librarian");
		String chosenUser = Buffer.reader.readLine();
		String u = null;
		if(chosenUser.equals("1")) u = "admin";
		else if(chosenUser.equals("2")) u = "manager";
		else if(chosenUser.equals("3")) u = "teacher";
		else if(chosenUser.equals("4")) u = "student";
		else if(chosenUser.equals("5")) u = "librarian";
		UserFactory uf = new UserFactory();
		User newUser = uf.createNewUser(u);	
		return newUser;
	}
	
	public void viewUsers() {
		int index = 1;
		for(User u: admin.viewUsers()) {
			System.out.println(index + ")" + u);
		}
	}
	
	public void addUser() throws IOException, InterruptedException{
		admin.addUser(kindOfUser());
		System.out.println("User sucessfully added!");
	}
	
	public void removeUser() throws IOException, InterruptedException {
		admin.removeUser(kindOfUser());
		System.out.println("User sucessfully deleted!");
	}
	
	public void updateUser() throws IOException, InterruptedException {
		User updUser = kindOfUser();
		System.out.println("What do you want to update?: ");
        System.out.println("1. Password\n2. Login");
	    int choice = Integer.parseInt(Buffer.reader.readLine());
	    if(choice == 1) {
	    	System.out.println("Your current password: " + updUser.getPassword());
	        System.out.print("Enter a new password: ");
	        updUser.setPassword(Buffer.reader.readLine());
	        System.out.println("Password has been successfully updated!");
	    }
	    else if(choice == 2) {
	    	System.out.println("Your current login: " + updUser.getLogin());
	        System.out.print("Enter a new login: ");
	        updUser.setLogin(Buffer.reader.readLine());
	        System.out.println("Login has been successfully updated");
	    }
	}
	
	public void viewTimeOfSignIn() throws IOException {
		Vector<String> userActions = new Vector<String>(admin.getTimeOfSignIn());
		
		if(!userActions.isEmpty()) {
			System.out.println("Current user's log actions:");
			int index = 1;
	        for(String actions : userActions) {
	            System.out.println(index + ") " + actions);
	            index++;
	        }
		}else System.out.println("No users action:(");

	}

}
