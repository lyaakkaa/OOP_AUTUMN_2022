package models;

import java.io.Serializable;
import java.util.*;

public class News implements Serializable {
	private String title;
	private String content;
	private ArrayList<String> comments;
	private Date postDate;

	public News() {}

	public News(String title, String content, ArrayList<String> comments, Date postDate) {
		this.title = title;
		this.content = content;
		this.comments = comments;
		this.postDate = postDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}
}