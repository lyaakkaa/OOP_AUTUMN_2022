package other;

import java.util.Objects;

import users.User;

public class Message {
	private String title;
	private User sender;
	private User receiver;
	
	public Message(){
		
	}

	public Message(String title, User sender, User receiver) {
		super();
		this.title = title;
		this.sender = sender;
		this.receiver = receiver;
	}

	@Override
	public int hashCode() {
		return Objects.hash(receiver, sender, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(receiver, other.receiver) && Objects.equals(sender, other.sender)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Message [title=" + title + ", sender=" + sender + ", receiver=" + receiver + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	
}
