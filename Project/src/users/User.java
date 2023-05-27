package users;

import java.util.Objects;

import other.News;


public abstract class User implements Comparable <User>{
	private String name;
    private String surname;
    private String login;
    private String password;
    private boolean isLogged;
    
	public User() {}
    
    public User(String name, String surname, String password) {
    	this.name = name;
    	this.surname = surname;
    	this.login = this.name.substring(0, 1).toLowerCase() + "_" + this.surname.toLowerCase();
    	this.password = password;
    }
   
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public boolean isLogged() {
		return isLogged;
	}
	
	@Override
	public String toString() {
		return "User [ name=" + name + ", surname=" + surname + ", login=" + login + ", password="
				+ password + ", isLogged=" + isLogged + "]";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(isLogged, login, name, password, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return isLogged == other.isLogged && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(surname, other.surname);
	}
	
	
	public int compareTo(User u) {
		return name.compareTo(u.name);
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if(oldPassword == this.password){
			this.password = newPassword;
			return true;
		}
		return false;
	}
	
	public boolean logIn(String login, String password) {
        if(login.equals(this.login) && password.equals(this.password)) {
        	this.isLogged = true;
            return true;
        }
        return false;
    }
	
	public void logOut() {
		this.isLogged = false;
	}
	
	
//	public void viewNews() {
//		if(!this.isLogged) System.out.println("You are not authorized!");
//		else {
//			for(int i=0;i<Database.getNews().size();i++) {
//				System.out.println(db.getNews().get(i));
//			}
//		}
//	}
	
	
	public String viewNews() {
		String s = "";
		for (News news: Database.news) {
			s += news + "\n";
		}
		return s;
	}
	
	
	
	
	
	
	
	
}
