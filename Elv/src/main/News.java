package main;


import java.util.Date;
import java.util.Objects;

/**
* @generated
*/
public class News extends Message {
	
    private Faculties faculty;
    private Manager manager;
  
    public News() {}
    
    
    public News(String title, String text, Date date, Employee sender) {
        super(title, text, date, sender);
    }
    
    public Faculties getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }
    
    public Manager getManager() {
        return this.manager;
    }
    
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    

    //                          Operations                                  
    
    
    public String showNews() {
    	String s = "";
        for (News n: Database.news) {
        	s += n + "\n";
        }
        return s;
    }

	@Override
	public String toString() {
		return "News [faculty=" + faculty + ", manager=" + manager + "]";
	}
    
	public void showNewsInfo() {
        Employee sender = this.getSender();
        System.out.println(String.format("Title: %s [%s]", this.getTitle(), faculty));
        System.out.println(String.format("Text: %s", this.getText()));
        System.out.println(String.format("Sender: %s [%s]", sender.getFirstName() + sender.getLastName(), sender.getLogin()));
        System.out.println(String.format("Date: %s", this.getDate()));
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        if (!super.equals(o)) return false;
        News news = (News) o;
        return faculty == news.faculty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }
    
}