package classes;

import java.util.Objects;
import java.util.Vector;

public class News {
	private String title;
	private String text;
	private Vector <String> comments;
	
	public News() {}
	
	public News(String title, String text) {
		super();
		this.title = title;
		this.text = text;
		
	}


	public News(String title, String text, Vector<String> comments) {
		super();
		this.title = title;
		this.text = text;
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Vector<String> getComments() {
		return comments;
	}

	public void setComments(Vector<String> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", text=" + text + ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(comments, text, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(comments, other.comments) && Objects.equals(text, other.text)
				&& Objects.equals(title, other.title);
	}
	
}
