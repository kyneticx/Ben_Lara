/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is a custom exception which extends the AMS Exception class for problems
 * when attempting to enroll into or withdraw from a course.
 *****************************************************************************/
package ams.model.exception;

@SuppressWarnings("serial")
public class EnrollmentException extends AMSException {

	public EnrollmentException() {
		super("DEFAULT Enrollment Exception");
	}

	public EnrollmentException(String message) {
		super(message);
	}

}
