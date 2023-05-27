package LabWork1;

public class Person {
	
	private GenderOfPerson gender;
	
	Person(GenderOfPerson gender) {
		this.gender = gender;
	}
	
	public GenderOfPerson getGender() {
		return this.gender;
	}
	
	public String toString() {
		return gender.toString();
	}
}
