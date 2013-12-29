/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is a custom Exception used for errors when adding or removing subjects
 * to a Program.
 *****************************************************************************/
package ams.model.exception;

@SuppressWarnings("serial")
public class ProgramException extends AMSException {

	public ProgramException() {
		super("DEFAULT PROGRAM Exception");
	}

	public ProgramException(String message) {
		super(message);
	}
}
