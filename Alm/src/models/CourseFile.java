package models;

import utils.Util;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CourseFile implements Serializable {
	private String name;
	private Date creationDate;

	public CourseFile() {}

	public CourseFile(String name, Date creationDate) {
		this.name = name;
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return Util.COLOR_BLUE + name + Util.COLOR_RESET + ". Created at " + creationDate;
	}
}