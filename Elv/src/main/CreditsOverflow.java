package main;


public class CreditsOverflow extends Exception {
    
	public CreditsOverflow(Course course, int lim) {
        super(String.format("Error! Can't add this course with " + course.getCredits() + " credits. Limit of credits is " + lim));
    }
}