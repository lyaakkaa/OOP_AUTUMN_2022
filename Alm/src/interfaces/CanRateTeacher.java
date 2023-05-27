package interfaces;

import exceptions.IllegalOperationException;
import models.*;

public interface CanRateTeacher {
	void rateTeacher(Teacher teacher, double rating) throws IllegalOperationException;
}