/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the ElectiveCourse Class which extends AbstractCourse- elective
 * Courses can have either 12 or 6 credit points 
 *****************************************************************************/
package ams.model;

public class ElectiveCourse extends AbstractCourse {

    // instance variable which holds the current credit points for the course.
    private int CP;
    
    // constructor takes Strings for course code and title, an int for credit
    // points and an array of String for prerequisites and assigns them to their
    // respective instance variables  
    public ElectiveCourse(String code, String title, int CP, String[] preReqs) {
        this.courseCode = code;
        this.title = title;
        this.CP = CP;
        this.preReqs = preReqs;
    }

    // returns the current credit points value as an int.
    @Override
    public int getCreditPoints() {
        return CP;
    }
    
    // toString method returns a String delimted by : characters of the current
    // courses code, title, prerequsites (if any) and the fact it is an ELECTIVE
    public String toString() {
        String s;
        if (this.preReqs != null ) {
            StringBuilder pr = new StringBuilder();
            for (int i = 0; i < this.preReqs.length; i++) {
                if (i == 0)
                    pr.append(this.preReqs[i]);
                else {
                    pr.append(',');
                    pr.append(this.preReqs[i]);
                }
            }
            s = this.courseCode + ":" + this.title + ":" + CP + ":" + pr 
            		+ ":ELECTIVE";
        }
        else
            s = this.courseCode + ":" + this.title + ":" + CP + ":ELECTIVE";
        return s;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
