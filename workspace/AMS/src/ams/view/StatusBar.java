package ams.view;

import java.awt.*;
import javax.swing.*;

import ams.controller.*;

// the statusbar for the AMS system displays the current program name, the
// number of core and elective courses - updated every time the program is
@SuppressWarnings("serial")
public class StatusBar extends JPanel {
    
    private StatusBarController sc;
    private AMSView mainView;
    private JLabel coreCourses;
    private JLabel electiveCourses;
    private JLabel programName;
    
    
    public StatusBar(AMSView mainView) {
    	
    	// assign mainview and setup the panel layout and colour
    	this.mainView = mainView;
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        // setup our labels
        programName = new JLabel("No Program Initiated");
        coreCourses = new JLabel("Core Courses : 0");
        electiveCourses = new JLabel("Elective Courses: 0");
        programName.setForeground(Color.YELLOW);
        coreCourses.setForeground(Color.YELLOW);
        electiveCourses.setForeground(Color.YELLOW);
        programName.setFont(programName.getFont().deriveFont(22f));
        coreCourses.setFont(programName.getFont().deriveFont(22f));
        electiveCourses.setFont(programName.getFont().deriveFont(22f));
        
        // add the labels with some spacing
        add(programName);
        Dimension minSize = new Dimension(5, 100);
        Dimension prefSize = new Dimension(5, 100);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);
        add(new Box.Filler(minSize, prefSize, maxSize));
        add(coreCourses);
        add(new Box.Filler(minSize, prefSize, maxSize));
        add(electiveCourses);
        
        // assign the controller
        sc = new StatusBarController(this);


    }

    /*
     * GETTERS
     */
    public AMSView getMainView() {
        return mainView;
    }

    public JLabel getCoreCourses() {
        return coreCourses;
    }

    public JLabel getElectiveCourses() {
        return electiveCourses;
    }
    public JLabel getProgramName() {
        return programName;
    }
    
    // updates the view every time the program map is changed.
    public void updateStatusBar() {
        sc.updateStatusBar();
    }
}
