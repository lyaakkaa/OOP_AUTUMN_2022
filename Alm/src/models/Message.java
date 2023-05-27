package models;


import enums.MessageType;
import utils.Util;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private Employee from;
	private Employee to;
	private MessageType type;
	private String content;
	private boolean signed;
	private Date postDate;

	public Message() {}

	public Message(Employee from, Employee to, MessageType type, String content, boolean signed, Date postDate) {
		this.from = from;
		this.to = to;
		this.type = type;
		this.content = content;
		this.signed = signed;
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}
	
	public Date getPostDate() {
		return postDate;
	}

	public MessageType getType() {
		return type;
	}

	public boolean isSigned() {
		return signed;
	}

	public Employee fromWho() {
		return from;
	}

	public Employee toWho() {
		return to;
	}

	@Override
	public String toString() {
		return (
				"From " + fromWho().getName() + " " + fromWho().getSurname() + ", " + fromWho().getClass().getSimpleName() +
				"\nMessage type: " + Util.COLOR_RED + type + Util.COLOR_RESET + "\nIs signed by the dean: " +
				(signed ? "Yes\n" : "No\n") + "Post date: " + postDate + "\nMessage content: " + content + "\n"
		);
	}
}