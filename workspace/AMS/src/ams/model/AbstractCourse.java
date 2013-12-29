/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is an Abstract object which implements the Course interface to be 
 * extended for Core and Elective Courses.
 *****************************************************************************/
package ams.model;

public abstract class AbstractCourse implements Course {
    
    // instance variables - String for Course Code, title and array of Strings
    // for prerequisite subject codes.
    protected String courseCode;
    protected String title;
    protected String[] preReqs;
    
    // abstract method to return course credit points.
    public abstract int getCreditPoints();

    // returns a String of the current Course Code
    @Override
    public String getCode() {
        return courseCode;
    }
    
    // returns a String of the current title.
    @Override
    public String getTitle() {
        return title;
    }
    
    // returns an array of Strings of the current prerequisites.
    @Override
    public String[] getPreReqs() {
        return preReqs;
    }

}
