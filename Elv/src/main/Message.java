package main;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
* @generated
*/
public class Message implements Serializable {
    
    private String title;
    private String text;
    private Date date;
    private Employee sender;
    
    public Message() {}
    
    public Message(String title, String text, Date date, Employee sender) {
    	this.title = title;
    	this.text = text;
    	this.date = date;
    	this.sender = sender;
    }
    
    public Message(String title, String text, Date date) {
    	this.title = title;
    	this.text = text;
    	this.date = date;
    }
    
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Employee getSender() {
        return this.sender;
    }
    
    public void setSender(Employee sender) {
        this.sender = sender;
    }
    
    

    //                          Operations                                  
 

	public void showMessageInfo() {
		Employee sender = this.getSender();
		System.out.println("Message Information:\n");
		System.out.println(String.format("Title: %s", title));
        System.out.println(String.format("Text: %s", text));
        System.out.println(String.format("Sender: %s [%s]", sender.getFirstName() + sender.getLastName(), sender.getLogin()));
        System.out.println(String.format("Date: %s", date));
	}

	@Override
	public String toString() {
		return "Message [title=" + title + ", text=" + text + ", date=" + date + ", sender=" + sender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, text, sender, date);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return title.equals(message.title) &&
                text.equals(message.text) &&
                sender.equals(message.sender) &&
                date.equals(message.date);
	}
}