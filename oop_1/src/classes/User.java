package classes;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class User implements Serializable, Comparable <User>, Cloneable{
	private String name;
    private String surname;
    private String login;
    private String password;
    
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

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, name, password, surname);
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
		return Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(surname, other.surname);
	}
	
	public Object clone() throws CloneNotSupportedException{
		User user = (User) super.clone();
		user.name = name;
		user.surname = surname;
		user.login = login;
		user.password = password;
		return user;
	}
	
	public int compareTo(User u) {
		return this.login.compareTo(u.login);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
    
    

}
