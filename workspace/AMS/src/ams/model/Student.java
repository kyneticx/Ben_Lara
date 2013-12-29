/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the Student Interface which extends the Enrollable interface which
 * allows us to polymorphically contain both post grad and under grad students.
 *****************************************************************************/
package ams.model;

public interface Student extends Enrollable {
    
    // must return the students fullname as a String 
    public String getFullName();
    // must return the student ID as an int
    public int getStudentId();
    // must return an array of current results or null for none
    public Result[] getResults();
    // must take a Result as parameter to add to students results - returns
    // boolean based on success
    public boolean addResults(Result results);
    // must return an array of courses based on students current enrollment
    public Course[] getCurrentEnrollment();
    // must return the students current load as an int value
    public int calculateCurrentLoad();
    // must return the students total career points as an int value
    public int calculateCareerPoints();
    // must construct and return a string value containing all important 
    // student information
    public String toString();
    
}
