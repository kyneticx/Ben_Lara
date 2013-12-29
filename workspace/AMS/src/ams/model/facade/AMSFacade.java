/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the AMSModel class which implements the AMSFacade interface so as to
 * correctly test and implement all needed methods within the AMS system.
 *****************************************************************************/
package ams.model.facade;

import ams.model.*;
import ams.model.exception.*;

public class AMSFacade implements AMSModel {
	
	// only one instance variable required - a university object
	University uni = new University();

	// addStudent method takes a student as a parameter and then uses the
	// setStudent method of univerity to add that student.
	@Override
	public void addStudent(Student newStudent) {
		uni.setStudent(newStudent);
	}
	// getStudent method returns a Student using the univerity getStudent method
	@Override
	public Student getStudent() {
		return uni.getStudent();
	}
	// addProgram method takes a Program as a parameter and uses the addProgram
	// method of University to add that program.
	@Override
	public void addProgram(Program program) {
		uni.addProgram(program);
	}
	
	// getProgram returns a Program using the University getProgram method.
	@Override
	public Program getProgram() {
		return uni.getProgram();
	}
	
	// addCourse takes a Course as parameter and then uses the University 
	// addCourse method to add that course to the program - can throw a 
	// ProgramException exception.
	@Override
	public void addCourse(Course course) throws ProgramException {
		uni.addCourse(course);
	}
	
	// removeCourse takes a String for the required course ID to be removed 
	// and then passes that to the University removeCourse method - can throw
	// a ProgramException exception.
	@Override
	public void removeCourse(String courseId) throws ProgramException {
		uni.removeCourse(courseId);
	}
	
	// getCourse returns a Course using the University getCourse method - takes
	// a String for the required courseID as a parameter
	@Override
	public Course getCourse(String courseCode) {
		return uni.getCourse(courseCode);
	}
	
	// getAllCourses returns an array of Course's using the University 
	// getAllCourses method.
	@Override
	public Course[] getAllCourses() {
		return uni.getProgramCourses();
	}
	
	// addResult takes a Result as parameter and then adds that to the students
	// current results using the University addStudentResult method. returns
	// a boolean value depending on outcome.
	@Override
	public boolean addResult(Result result) {
		return uni.addStudentResult(result);
	}
	
	// getResults returns an array of Results using the University 
	// getStudentResults method.
	@Override
	public Result[] getResults() {
		return uni.getStudentResults();
	}

	// returns a Course array using the University getCurrentStudentEnrollment
	// method 
	@Override
	public Course[] getCurrentEnrollment() {
		return uni.getCurrentStudentEnrollment();
	}
	
	// enrolls current student into a course using the University 
	// enrollStudentIntoCourse method - takes the required Course ID as
	// a parameter - may throw EnrollmentException exception.
	@Override
	public void enrollIntoCourse(String courseID) throws EnrollmentException {
		Course course = uni.getCourse(courseID);
		uni.enrollStudentIntoCourse(course);
	}
	
	// withdraws current student from a course using a String for the required
	// course ID as a parameter
	@Override
	public void withdrawFromCourse(String courseID) throws EnrollmentException {
		uni.withdrawStudentFromCourse(courseID);
	}
	
	// returns the current students load as an int using the University
	// calculateCurrentStudent method.
	@Override
	public int calculateCurrentLoad() {
		return uni.calculateCurrentStudentLoad();
	}
	
	// returns the current students career points as an int using the University
	// calculateTotalCareerPoints method.
	@Override
	public int calculateCareerPoints() {
		return uni.calculateTotalCareerPoints();
	}
	public int countCoreCourses() 
	{
	return uni.getProgram().countCoreCourses();
	}
	public int countElectiveCourses() 
	{
	return uni.getProgram().countElectiveCourses();
	}

}
