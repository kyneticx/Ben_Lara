package ams.view;
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

import ams.controller.AMSViewController;
import ams.model.facade.AMSModel;


/*
 * The main window frame for the AMS system
 */

@SuppressWarnings("serial")
public class AMSView extends JFrame {
    
    private Container container;
    private ButtonPanel buttons;
    private StatusBar statusBar;
    private AMSMenuBar menubar;
    private ProgramMap programMap;
    private AMSModel model;
    

    // Constructor
    public AMSView(AMSModel model) {
    
    	// set the container and layout
        super("AMS Assignment 2 - Benjamin Wilson - s3406005");
        this.model = model;
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        
        // create our various subviews
        buttons = new ButtonPanel(this);
        statusBar = new StatusBar(this);
        menubar = new AMSMenuBar(this);
        programMap = new ProgramMap(this);
        
        // display subviews and add a window listener to the current frame
        displaySubViews();
        this.addWindowListener(new AMSViewController(this));
         
    }

    /*
     * GETTERS for our views
     */
    public AMSModel getModel() {
        return model;
    }
    public ButtonPanel getButtons() {
        return buttons;
    }
    
    public StatusBar getStatusBar() {
        return statusBar;
    }
    
    public AMSMenuBar getMenubar() {
        return menubar;
    }
    
    public ProgramMap getProgramMap() {
        return programMap;
    }
    
    // to display our subviews
    public void displaySubViews() {
        container.add(buttons, BorderLayout.WEST);
        container.add(statusBar, BorderLayout.SOUTH);
        container.add(programMap, BorderLayout.CENTER);
        container.add(menubar, BorderLayout.NORTH);
    }
    

    // to prevent data loss we ask user to confirm closing the program
    // when closing the window
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            int exit = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to exit?", 
                    "Yes to Exit, No to stay", 
                    JOptionPane.YES_NO_OPTION);
            if(exit == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else
                super.processWindowEvent(e);
    } 

}
