package main;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Mark {
	private double points;
    private Date deadline;
    private double attestation1;
	private double attestation2;
	private double finalEx;
    private Course courseName;
    private double totalGrade;
    private double courseGPA;
    private String GPAletter;
    
    public Mark() {
    	this.totalGrade = 0;
    	this.attestation1 = 0;
    	this.attestation2 = 0;
    	this.finalEx = 0;
    }
    
    public Mark(double points, MarksType marksType) {
    	this.points = points;
		switch (marksType) {
        case ATTESTATION1:
        	this.setAttestation1(points);
            break;
        case ATTESTATION2:
        	this.setAttestation2(points);
            break;
        case FINAL_EXAM:
        	this.setFinalEx(points);
            break;
		}
    }
    
    public Mark(double points, Course courseName, double totalGrade, List<Mark> marks) {
    	this.points = points;
    	this.courseName = courseName;
    	this.totalGrade = totalGrade;
    }
    
    public double getPoints() {
        return this.points;
    }
    
    public void setPoints(double points) {
        this.points = points;
    }
    
    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public Course getCourseName() {
        return this.courseName;
    }
    
    private void setCourseName(Course courseName) {
        this.courseName = courseName;
    }
    
    public double getTotalGrade() {
        return this.totalGrade;
    }
    
    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }
    
    public double getCourseGPA() {
        return this.courseGPA;
    }
    
    public void setCourseGPA(double courseGPA) {
        this.courseGPA = courseGPA;
    }
    public double getAttestation1() {
		return attestation1;
	}

	public void setAttestation1(double attestation1) {
		this.attestation1 = attestation1;
		totalGrade += attestation1;
	}

	public double getAttestation2() {
		return attestation2;
	}

	public void setAttestation2(double attestation2) {
		this.attestation2 = attestation2;
		totalGrade += attestation2;
	}

	public double getFinalEx() {
		return finalEx;
	}

	public final void setFinalEx(double finalEx) {
		this.finalEx = finalEx;
		totalGrade += finalEx;
	}
	
	// operations
	
	public String gradeToLetter() {
    	if(totalGrade < 50) {
			courseGPA = 0; GPAletter = "F";
		}
		else if(totalGrade < 55) {
			courseGPA = 1.0; GPAletter = "D";
		}
		else if(totalGrade < 60) {
			courseGPA = 1.33; GPAletter = "D+";
		}
		else if(totalGrade < 65) {
			GPAletter = "C-"; courseGPA = 1.67;
		}
		else if(totalGrade < 70) {
			GPAletter = "C"; courseGPA = 2;
		}
		else if(totalGrade < 75) {
			GPAletter = "C+"; courseGPA = 2.33;
		}
		else if(totalGrade < 80) {
			GPAletter = "B-"; courseGPA = 2.67;
		}
		else if(totalGrade < 85) {
			GPAletter = "B"; courseGPA = 3.0;
		}
		else if(totalGrade < 90) {
			GPAletter = "B+"; courseGPA = 3.33;
		}
		else if(totalGrade < 95) {
			GPAletter = "A-"; courseGPA = 3.67;
		}
		else if(totalGrade < 100) {
			GPAletter = "A"; courseGPA = 4;
		}
    	return GPAletter;
    }

	@Override
	public String toString() {
		return "Mark [points=" + points + ", deadline=" + deadline + ", attestation1=" + attestation1
				+ ", attestation2=" + attestation2 + ", finalEx=" + finalEx + ", courseName=" + courseName +  ", totalGrade=" + totalGrade + ", courseGPA=" + courseGPA + ", GPAletter=" + GPAletter + "]";
	}
    
	public void updatePoints(double addingPoints) throws DeadlineExpired{
    	Date now = Calendar.getInstance().getTime();
        if (now.compareTo(deadline) <= 0) {
            this.points += addingPoints;
        }
        else {
            throw new DeadlineExpired(deadline);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(points, GPAletter);
	}

	@Override
	public boolean equals(Object obj) {
		Mark other = (Mark) obj;
		if (GPAletter == null) {
			if (other.GPAletter != null)
				return false;
		} else if (!GPAletter.equals(other.GPAletter))
			return false;
		if (Double.doubleToLongBits(totalGrade) != Double.doubleToLongBits(other.totalGrade))
			return false;
		return true;
	}
}