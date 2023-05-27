package main;

import java.util.Date;

/**
* @generated
*/
public class DeadlineExpired extends Exception {

    public DeadlineExpired(Date deadline) {
        super(String.format("Error! You forgot about the deadline " + deadline));
    }
    
}