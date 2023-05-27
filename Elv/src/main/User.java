package main;


import java.io.Serializable;
import java.util.Objects;

/**
* @generated
*/
public class User implements Serializable, Comparable {
	
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    
    public User() {}

    public User(String firstName, String lastName, String email) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.login = this.firstName.substring(0, 1).toLowerCase() + "_" + this.lastName.toLowerCase();
    	this.password = "12345";
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }
  
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return this.login;
    }
    

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //                          Operations                                  
    

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
        	this.password = newPassword;
        	Database.save();
        	return true;
        }
    	return false;
    }
    
    @Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, email, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		User user = (User)o;
        return this.login.compareTo(user.login);
	}
	
	public String viewNews() {
		String s = "";
		for (News news: Database.news) {
			s += news + "\n";
		}
		return s;
	}
}