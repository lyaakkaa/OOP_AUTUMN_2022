package models;

import enums.FacultyName;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Faculty implements Serializable {
	private FacultyName name;
	private ArrayList<Speciality> specialties;

	public Faculty() {}

	public Faculty(FacultyName name, ArrayList<Speciality> specialties) {
		this.name = name;
		this.specialties = specialties;
	}

	public FacultyName getName() {
		return name;
	}
	
	public ArrayList<Speciality> getSpecialties() {
		return specialties;
	}

	@Override
	public String toString() {
		return name.toString();
	}
}