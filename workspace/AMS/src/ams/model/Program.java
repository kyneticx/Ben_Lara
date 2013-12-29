/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the Program Class - it is essentially a container for courses which
 * has rules around the adding to and removing of said courses.
 *****************************************************************************/
package ams.model;

import ams.model.exception.*;
import java.util.*;

public class Program {

    // instance variables for program code, title and our list of courses.
    private String progCode;
    private String title;
    private List<Course> course = new ArrayList<Course>();
    
    // constructor simply takes two strings for program code and title.
    public Program(String string, String string2) {
        this.progCode = string;
        this.title = string2;
    }
    // attempts to add a course to the current program - may throw an exception
    // from within this method.
    public void addCourse(Course c) throws ProgramException {
        // first check if there is a duplicate course code in the program - if
        // so then we assume it is an updated version of the course so we remove
        // the old one and add the new one.
        boolean isDupe = false;
        Course dupe = null;
        Iterator<Course> itera = course.iterator();
        while (itera.hasNext()) {
            Course e = (Course) itera.next();
            if (e.getCode().equals(c.getCode()) ) {
                isDupe = true;
                dupe = e;
            }
        }
        if (isDupe)
            course.remove(dupe);
        // if there are no prerequsites we can safely add the course
        if (c.getPreReqs() == null)
            course.add(c);
        // otherwise we must check to see that the program already contains
        // those prerequisite subjects - if it does - add the course - if not
        // throw a ProgramException exception.
        else {
            // first get the number of prerequisites
            int num = 0;
            int check = 0;
            String[] ids = c.getPreReqs();
            num = ids.length;
            // count the number of prereqs in the program by looping through and
            // comparing each course in the program to the list of prerequisites
            Iterator<Course> iter = course.iterator();
            while (iter.hasNext()) {
                Course e = (Course) iter.next();
                for (int i = 0; i < ids.length; i++)   {
                    if (ids[i].equals(e.getCode()))
                        check++;
                }
            }
            // if we have the required # of prereqs we can safely add the course
            if (num == check)
                course.add(c);
            // otherwise throw an exception
            else
                throw new ProgramException("Prerequisites not found in " +
                                        "current Program");
        }
    }
    // attempts to remove a course based on given course id - may throw an 
    // exception from within this method.
    public void removeCourse(String courseId) throws ProgramException {
        // set check prerequisite variable to false and grab the course using
        // the course id.
        boolean isPR = false;
        Course c = this.getCourse(courseId);
        Iterator<Course> iter = course.iterator();
        // check that the course is not a prerequisite for any others in program
        // and if it is set isPr to true.
        while (iter.hasNext()) {
            Course e = (Course) iter.next();
            String[] prereqs = e.getPreReqs();
            if (prereqs != null) {
                for (int i = 0; i < prereqs.length; i++) {
                    if (courseId.equals(prereqs[i]))
                        isPR = true;
                }
            }
        }
        // if this subject isnt a prereq for any others in the program we can
        // safely add it - otherwise we throw an exception
        if (!isPR) {
            course.remove(c);
        }
        else
            throw new ProgramException("Cannot remove this course as it is a" +
                    " prerequisite for others in this program");
        
    }
    // returns a Course based on a String parameter of course id by iterating
    // through our current program of courses and returning the matching course
    public Course getCourse(String courseID) {
        Iterator<Course> iter = course.iterator();
        while (iter.hasNext()) {
            Course e = (Course) iter.next();
            if (e.getCode().equals(courseID))
                return e;
        }
        //if we get to this point then a course matching courseID was not found
        return null;
    }
    
    // returns all of the programs current courses as an array of courses
    public Course[] getAllCourses() {
        // if program is empty return a null array
        if (course.isEmpty())
            return null;
        // otherwise convert our list of courses to an array ready to return
        else {
            Course[] c = course.toArray(new Course[0]);
            return c;
        }
    }
    
    // simple toString method returns program code and title delimited by :
    public String toString() {
        String s = this.progCode + ":" + this.title;
        return s;
    }
    public int countElectiveCourses() {
        Course [] courses = getAllCourses();  
        CountingVisitor visitor = new CountingVisitor (); 

        // loop through all the courses in the system
        for (int i=0; i<courses.length; i++)
            courses[i].accept(visitor);
        return visitor.getElectiveCount();
    }    
    public int countCoreCourses() {
        Course [] courses = getAllCourses();  
        CountingVisitor visitor = new CountingVisitor (); 

        // loop through all the courses in the system
        for (int i=0; i<courses.length; i++)
            courses[i].accept(visitor);
        return visitor.getCoreCount();
    }    


}
