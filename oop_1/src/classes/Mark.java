package classes;

import java.io.Serializable;

import enums.TimeOfAttestation;


@SuppressWarnings("serial")
public class Mark implements Serializable{
	private double attestation1;
	private double attestation2;
	private double finalExam;
	private double gpa;

	public Mark() {
		this.attestation1 = 0;
		this.attestation2 = 0;
		this.finalExam = 0;
	}
	
	public Mark(double point, TimeOfAttestation timeAtt) {
		if(timeAtt == TimeOfAttestation.ATTESTATION1) {
			this.setAttestation1(point);
		}
		if(timeAtt == TimeOfAttestation.ATTESTATION2) {
			this.setAttestation2(point);
		}
		if(timeAtt == TimeOfAttestation.FINAL) {
			this.setFinalExam(point);
		}
	}
	
	 
	public double getAttestation1() {
		return attestation1;
	}
	
	public void setAttestation1(double point) {
		if(this.attestation1 > 30) {
			System.out.println("You cannot add more than 30");
		}
		this.attestation1 += point ;
	}

	public double getAttestation2() {
		return attestation2;
	}
	
	public void setAttestation2(double point) {
		if(this.attestation2 > 30) {
			System.out.println("You cannot add more than 30");
		}
		this.attestation2 += point ;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double point) {
		this.finalExam += point ;
	}

	public double getTotal() {
		return this.attestation1 + this.attestation2 + this.finalExam;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
	public String totalMark() {
		String letter = "";
		if (this.getTotal() >= 95 && this.getTotal() <= 100) 
            letter = "A";
            if (this.getTotal() >= 90)
            	letter = "A-"; 
            if (this.getTotal() >= 85) 
            	letter = "B+"; 
            if (this.getTotal() >= 80) 
            	letter = "B"; 
            if (this.getTotal() >= 75) 
            	letter = "B-"; 
            if (this.getTotal() >= 70) 
            	letter = "C+"; 
            if (this.getTotal() >= 65) 
            	letter = "C"; 
            if (this.getTotal() >= 60) 
            	letter = "C-"; 
            if (this.getTotal() >= 55) 
            	letter = "D+"; 
            if (this.getTotal() >= 50) 
            	letter = "D"; 
            else letter = "F";
            
         return letter;
	}
	
	public void calcGpa() {
		if(this.totalMark() == "A") this.gpa = 4.00;
		else if(this.totalMark() == "A-") this.gpa = 3.67;
		else if(this.totalMark() == "B+") this.gpa = 3.33;
		else if(this.totalMark() == "B") this.gpa = 3.00;
		else if(this.totalMark() == "B-") this.gpa = 2.67;
		else if(this.totalMark() == "C+") this.gpa = 2.33;
		else if(this.totalMark() == "C") this.gpa = 2.00;
		else if(this.totalMark() == "C-") this.gpa = 1.67;
		else if(this.totalMark() == "D+") this.gpa = 1.33;
		else if(this.totalMark() == "D") this.gpa = 1.00;
		else this.gpa = 0.00;	
	}


	@Override
	public String toString() {
		return "Mark [attestation1=" + attestation1 + ", attestation2=" + attestation2 + ", finalExam=" + finalExam
				+ ", gpa=" + gpa + "]";
	}

	public static Mark addMarks(Mark m1, Mark m2) {
		Mark m = new Mark();
		m.attestation1 = m1.attestation1 + m2.attestation1;
		m.attestation2 = m1.attestation2 + m2.attestation2;
		m.finalExam = m1.finalExam + m2.finalExam;
		
		return m;
	}
	
	
	public Mark addMarks(Mark m1) {
		return Mark.addMarks(m1, this);
	}
	

}
