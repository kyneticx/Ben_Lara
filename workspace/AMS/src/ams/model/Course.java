/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the Course Interface to be implemented by any Course Classes.
 *****************************************************************************/
package ams.model;

public interface Course extends Visitable {
    // getCode must return a String of the current course code
    public String getCode();
    // getTitle must return a String of the current title
    public String getTitle();
    // getCreditPoints must return an int of the Course credit points
    public int getCreditPoints();
    // getPreReqs must return an array of Strings for required prerequisites
    public String [] getPreReqs();
}
