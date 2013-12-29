package ams.controller;

import ams.model.facade.*;
import ams.view.StatusBar;

// statusbar controller simply is updated whenever 
public class StatusBarController {

    private AMSModel model;
    private StatusBar statusBar;
    private String program;
    private int core;
    private int elective;
    
    public StatusBarController(StatusBar sb) {
        statusBar = sb;
        this.model = sb.getMainView().getModel();
    }
    // called whenever changes are performed to the system - updates
    // labels to reflect changes to the system.    
    public void updateStatusBar() throws NullPointerException { 

        try {
            core = model.countCoreCourses();
        } catch (Exception e) {
            core = 0;
        }
        
        try {
            elective = model.countElectiveCourses();
        } catch (Exception e) {
            elective = 0;
        }
        String [] split = model.getProgram().toString().split(":");
        program = split[1];
        statusBar.getProgramName().setText("Program : " + program);
        statusBar.getCoreCourses().setText("Core Courses : " + core);
        statusBar.getElectiveCourses().setText("Elective Courses : "+ elective);
    }

}
