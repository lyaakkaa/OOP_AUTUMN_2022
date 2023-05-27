package classes;

import java.io.Serializable;
import java.util.Map;


@SuppressWarnings("serial")
public class Transcript implements Serializable{
	private double overallGpa;
	
	
	public Transcript() {
		this.overallGpa = 0;
	}


	public double getOverallGpa() {
		return overallGpa;
	}

	public void setOverallGpa(double overallGpa) {
		this.overallGpa = overallGpa;
	}
 
}
