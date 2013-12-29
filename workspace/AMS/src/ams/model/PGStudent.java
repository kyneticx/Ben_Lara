/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the PG Student class which extends the AbstractStudent Class - it is
 * for Post grad students - post grad students have a fixed maximum load of 48
 *****************************************************************************/
package ams.model;
import java.util.Iterator;

import ams.model.exception.*;

public class PGStudent extends AbstractStudent {
    
    private static final int MAX_LOAD = 48;
    
    // constructor takes int for id and string for name assigns to IV.
    public PGStudent(int id, String name) {
        this.studentId = id;
        this.fullName = name;
    }
    
    // toString method returns a String delimted by : characters of the current
    // students id, name and max load.
    @Override
    public String toString() {
        String s = this.studentId + ":" + this.fullName + ":" + MAX_LOAD;
        return s;
    }
    
    // attempts to enroll student into a given Course taken in as a parameter
    // may throw an EnrollmentException exception within this method.
    @Override
    public void enrollIntoCourse(Course course) throws EnrollmentException {
        // first calculate the total credit points (load) for the student and
        // grab our course prerequisites (if any) from course.
        int CP = course.getCreditPoints() + this.calculateCurrentLoad();
        String[] preReqs = course.getPreReqs();
        // if the student is currently enrolled in this course throw exception
        if (courses.contains(course))
            throw new EnrollmentException("Already enrolled in this Course");
        // check to see student has not already passed the subject and if so
        // throw an exception
        Iterator<Result> itera = results.iterator();
        while (itera.hasNext()) {
            Result r = (Result) itera.next();
            if (r.getCourse().equals(course) && r.getResult())
                throw new EnrollmentException("Cannot Enroll in course as it" +
                        " was previously passed");
        }
        // if there are prerequisites we must ensure the student has passed at
        // least one of them - if not throw exception
        if (preReqs != null) {
            int noPassed = 0;
            Iterator<Result> iter = results.iterator();
            while (iter.hasNext()) {
                Result r = (Result) iter.next();
                for (int i = 0; i < preReqs.length; i++) {
                    if (r.getCourse().getCode().equals(preReqs[i]) 
                            && r.getResult())
                    noPassed++;
                }
            }
            if (noPassed < 1)
                throw new EnrollmentException("No prerequisites passed for " +
                        "this subject");
        }
        
        // if student has exceeded their maximum load we first say they are 
        // unable to enroll - however if the load is only exceeded by 6 or less
        // then we check to see if the student has passed all previous subjects
        // if they havent - throw an exception - if they have passed all their
        // previous subjects we can say they are able to enroll which will then
        // prevent the exceeded load exception from being thrown.
        if ( CP > MAX_LOAD) {
            boolean enrollable = false;
            
            if ( CP <= MAX_LOAD + 6) {
                Iterator<Result> iter = results.iterator();
                while (iter.hasNext()) {
                    Result r = (Result) iter.next();
                    if (!r.getResult())
                        throw new EnrollmentException("Student has not" +
                        		" passed all subjects - overload not allowed");
                }
                enrollable = true;
            }
            if (!enrollable)
                throw new EnrollmentException("Subject would exceed maximum" +
                		" load");
        }
        // if we get to this point we can safely add the course as all checks
        // have been completed.
        this.courses.add(course);
    }
}
