/******************************************************************************
 * Benjamin Peter Wilson
 * Student # 3406005
 * Assignment 1 - AMS System 
 * This is the CoreCourse Class which extends AbstractCourse- all core Courses 
 * have a fixed Credit point value of 12.
 *****************************************************************************/
package ams.model;

public class CoreCourse extends AbstractCourse {
    
    private static final int CP = 12;

    // constructor takes String for course code and title and an array of
    // Strings for prerequisites and sets these values to their respective
    // instance variables.
    public CoreCourse(String courseCode, String title, String[] preReqs) {
        this.courseCode = courseCode;
        this.title = title;
        this.preReqs = preReqs;
    }

    // returns the current credit points as an int.
    @Override
    public int getCreditPoints() {
        return CP;
    }
    
    // toString method builds a String containing course code, title and 
    // prerequisites delimted by : characters.
    @Override
    public String toString() {
        String s;
        // if there are prerequisites we must separate them with a comma
        if (this.preReqs != null) {
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
            		+ ":CORE";
        }
        // otherwise we just build the string.
        else
            s = this.courseCode + ":" + this.title + ":" + CP + ":CORE";
        return s;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
