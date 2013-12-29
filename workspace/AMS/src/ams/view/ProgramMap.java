package ams.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import ams.controller.ProgramMapController;
import ams.model.Course;
import ams.model.facade.AMSModel;
/*
 * The program map view is our most important view in the AMS sytem - it will
 * display panels containing information regarding all courses in the program
 * as they are added and removed.
 */
@SuppressWarnings("serial")
public class ProgramMap extends JPanel {
    
	
    private AMSView frame;
    private AMSModel model;
    // the following three arrays keep track of some basic info regarding our
    // panels - i did try to create the panels as objects and it did work - 
    // however when it came to removing the customised panels they simply would
    // not remove from the view no matter what i tried and thus i ended up 
    // restarting the entire program map from scratch using this method which
    // worked perfectly.
    private Course [] courses;
    private JPanel[] panels;
    private String[] types;
    private boolean[] selected;
    private final Border cBdr = BorderFactory.createLineBorder(Color.BLACK, 10);
    private final Border eBdr = BorderFactory.createLineBorder(Color.BLACK, 1);
    
    //constructor
    public ProgramMap(AMSView amsView) {
        frame = amsView;
        model = frame.getModel();
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(1,0));
    }
    
    // the update program map method is the workhorse of the program map view
    // it is updated anytime the program is updated with addition or removal of
    // a course and does so by rebuilding the panel from scratch to avoid any
    // anomalies.
    public void updateProgramMap() {
    	
    	// initialise the view assuming that at this stage we have no or very
    	// few courses - initalise the layout to 1 row with unlimited columns 
    	// so the courses fill the screen when there are 4 or less
        boolean needEmpty = false;
        this.removeAll();
        this.setLayout(new GridLayout(1,0));
        
        // grab our array of current program courses
        courses = model.getAllCourses();
        
        // initialise our counter arrays to null
        panels = null;
        types = null;
        selected = null;
        
        // from here if our course is null we can skip most of the functionality
        if (courses != null) {
        	// setup our counter arrays
            panels = new JPanel[courses.length];
            types = new String[courses.length];
            selected = new boolean[courses.length];
            // if there are more than 4 courses we need to alter our gridlayout
            // to display them correctly.
            if (courses.length > 4) {
                this.setLayout(new GridLayout(0, 4));
                if ((courses.length % 4) != 0)
                    needEmpty = true;
            }
            
            // for every course in the program we setup a new panel and then 
            // add it to the program map.
            for (int i = 0; i < courses.length; i++) {
            	// get the details of the course
                String[] details;
                details = getDetails(courses[i]);
                JPanel newCourse = new JPanel();
                
                // initialise the parts required for each panel
                JScrollPane courseScrollPane = new JScrollPane();
                JLabel courseCode = new JLabel("Code: " + details[0]);
                JLabel courseTitle = new JLabel("Title: " + details[1]);
                JLabel courseCP = new JLabel("Credit Points: " + details[2]);
                JLabel coursePR = new JLabel("Prerequisites: " + details[3]);
                
                // set our font color to blue
                courseCode.setForeground(Color.BLUE);
                courseTitle.setForeground(Color.BLUE);
                courseCP.setForeground(Color.BLUE);
                coursePR.setForeground(Color.BLUE);

                // set the border according to type of course (core or elective)
                if (details[4].equals("CORE"))
                    newCourse.setBorder(cBdr);
                else
                    newCourse.setBorder(eBdr);
                
                // setup layout, colour and add various components
                newCourse.setLayout(new BoxLayout(newCourse, BoxLayout.Y_AXIS));
                newCourse.setBackground(Color.GRAY);
                newCourse.add(courseCode);
                newCourse.add(courseTitle);
                newCourse.add(courseCP);
                newCourse.add(coursePR);

                panels[i] = newCourse;
                selected[i] = false;
                
                // setup our Jscrollpane
                courseScrollPane.add(newCourse);
                add(courseScrollPane);
                courseScrollPane.setViewportView(newCourse);
                // based on whether it is a core or elective we need to tell
                // the controller for selection purposes
                if (details[4].equals("CORE")) {
                    courseScrollPane
                            .getViewport()
                            .getView()
                            .addMouseListener(
                                    new ProgramMapController(1, i, newCourse,
                                            this, courses[i]));
                    types[i] = "CORE";

                } else if (details[4].equals("ELECTIVE")) {
                    courseScrollPane
                            .getViewport()
                            .getView()
                            .addMouseListener(
                                    new ProgramMapController(2, i, newCourse,
                                            this, courses[i]));
                    types[i] = "ELECTIVE";

                }

            }
            // if we need empty spaces (ie there are more than 4 courses but 
            // we would otherwise have empty spaces left over) we need to fill
            // those with empty white boxes - this performs that for us
            if (needEmpty) {
                for (int i = 0; i < (4 - (courses.length % 4)); i++) {
                    JPanel empty = new JPanel();
                    Border border = BorderFactory.createLineBorder(Color.BLACK,
                            1);
                    empty.setBorder(border);
                    add(empty);
                }
            }
        }
        // finally validate and repaint the view to update.
        this.validate();
        this.repaint();
    }
    
    // getdetails method takes the course toString result and splits it up
    // into its various parts returning a string array to be used by the view.
    private String[] getDetails(Course course) {
        
        String d;
        String [] details = new String[5];
        d = course.toString();
        String [] split = d.split(":");
        
        details[0] = split[0];
        details[1] = split[1];
        
        if (course.getPreReqs() == null) {
            details[2] = split[2];
            details[3] = "None";
            details[4] = split[3];
        }
        else {
            details[2] = split[2];
            details[3] = split[3];
            details[4] = split[4];
        }
        
        return details;
    }
    
    // this method resets the borders of all the panels for use in selection
    public void resetBorders() {
        for (int i = 0; i < courses.length; i++) {
            selected[i] = false;
            if (types[i].equals("CORE")) {
                panels[i].setBorder(cBdr);
            }
            else
                panels[i].setBorder(eBdr);
        }
        this.repaint();
        this.validate();
        
    }
    
    // getter for the main frame.
    public AMSView getFrame() {
        return frame;
    }
    
    // helper functions for selection purposes
    public boolean isSelected(int s) {
        if (selected[s])
            return true;
        else
            return false;
    }
    public void setSelected(int s, boolean v) {
        selected[s] = v;
    }
}
