package models;

import enums.Grade;
import java.io.Serializable;

public class Mark implements Serializable {
	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;
	private double overallDigital;
	private Grade overallLetter;
	private double gpa;

	public Mark() {}

	private Grade determineLetter() {
		if(overallDigital <= 100 && overallDigital >= 95) {
			return Grade.A;
		}
		else if(overallDigital >= 90) {
			return Grade.A_MINUS;
		}
		else if(overallDigital >= 85) {
			return Grade.B_PLUS;
		}
		else if(overallDigital >= 80) {
			return Grade.B;
		}
		else if(overallDigital >= 75) {
			return Grade.B_MINUS;
		}
		else if(overallDigital >= 70) {
			return Grade.C_PLUS;
		}
		else if(overallDigital >= 65) {
			return Grade.C;
		}
		else if(overallDigital >= 60) {
			return Grade.C_MINUS;
		}
		else if(overallDigital >= 55) {
			return Grade.D_PLUS;
		}
		else if(overallDigital >= 50) {
			return Grade.D;
		} else {
			return Grade.F;
		}
	}

	private double determineGpa() {
		switch(overallLetter) {
			case A -> { return 4.00; }
			case A_MINUS -> { return 3.67; }
			case B_PLUS -> { return 3.33; }
			case B -> { return 3.00; }
			case B_MINUS -> { return 2.67; }
			case C_PLUS -> { return 2.33; }
			case C -> { return 2.00; }
			case C_MINUS -> { return 1.67; }
			case D_PLUS -> { return 1.33; }
			case D -> { return 1.00; }
			default -> { return 0.00; }
		}
	}

	public double getFirstAttestation() {
		return firstAttestation;
	}

	public double getSecondAttestation() {
		return secondAttestation;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public double getOverallDigital() {
		return overallDigital;
	}

	public Grade getOverallLetter() {
		return overallLetter;
	}

	public double getGpa() {
		return gpa;
	}

	public void setFirstAttestation(double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public void setSecondAttestation(double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public void setMarks(double firstAttestation, double secondAttestation, double finalExam) {
		if((firstAttestation + secondAttestation > 60) || finalExam > 40
				|| (firstAttestation == secondAttestation && secondAttestation == finalExam && finalExam < 0)) {
			throw new IllegalArgumentException("Illegal values for attestations!");
		}
		setFirstAttestation(firstAttestation);
		setSecondAttestation(secondAttestation);
		setFinalExam(finalExam);
		overallDigital = finalExam + secondAttestation + firstAttestation;
		overallLetter = determineLetter();
		gpa = determineGpa();
	}

	@Override
	public String toString() {
		return (firstAttestation + "  " + secondAttestation + "  " + finalExam + "  " + overallDigital
				+ "  " + overallLetter + "  " + gpa);
	}
}