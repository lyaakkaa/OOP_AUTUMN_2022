package LabWork1;

public class Course {
	private String name;
	private String description;
	private int credits;
	private String prerequisite;
	
	Course(String name, String description, int credits) {
		this.name = name;
		this.description = description;
		this.credits = credits;
	}
		
	Course(String name, String description, int credits, String prerequisite) {
		this(name, description, credits);
		this.prerequisite = prerequisite;
	}
	
	public String toString() {
		return "Course name: " + name + "\n" + "Description: " + description + "\nCredits: " + credits + "\nPrerequisite: " + prerequisite;
	}

}
