package ams.view;

import java.awt.*;

import javax.swing.*;

import ams.controller.ActionController;
import ams.model.Course;

/*
 * Button panel for the AMS system - contains our reset/initialise, add and
 * remove course buttons.
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
    
    private AMSView frame;
    private JButton reset;
    private JButton addcourse;
    private JButton remcourse;
    private Course selected;
    
    // constructor
    public ButtonPanel(AMSView amsView) {
    	
    	// setup color and layout
        frame = amsView;
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(0,1,0,20));
        
        // setup our buttons
        reset = new JButton("Initialise Program");
        addcourse = new JButton("Add Course");
        addcourse.setEnabled(false);
        remcourse = new JButton("Remove Course");
        remcourse.setEnabled(false);
        
        // add them to the view
        add(reset);
        add(addcourse);
        add(remcourse);
        
        // initialise actionlisteners to our custom Actioncontroller class
        ActionController action = new ActionController(frame);
        reset.addActionListener(action);
        addcourse.addActionListener(action);
        remcourse.addActionListener(action);
    }

    /*
     * GETTERS
     */
    public JButton getReset() {
        return reset;
    }
    public JButton getRemove() {
        return remcourse;
    }
    public void setSelected(Course c) {
        selected = c;
    }
    public Course getSelected() {
        return selected;
    }
    
    /*
     * Toggles for our buttons and reset to new program state.
     */
    public void toggleAddButton() {
        if (addcourse.isEnabled()) 
            addcourse.setEnabled(false);
        else 
            addcourse.setEnabled(true);
    }
    public void toggleRemButton() {
        if (remcourse.isEnabled()) 
            remcourse.setEnabled(false);
        else 
            remcourse.setEnabled(true);
    }

    public void resetButtons() {
        remcourse.setEnabled(false);
    }
}
