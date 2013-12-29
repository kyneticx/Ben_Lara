package ams.view;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import ams.controller.ActionController;

// Custom Menubar for the AMS system 
@SuppressWarnings("serial")
public class AMSMenuBar extends JMenuBar {
    private JMenuBar menubar;
    private JMenu mainMenu;
    private JMenuItem newProgram;
    private JMenuItem addCourse;
    private JMenuItem removeCourse;
    private JMenuItem exitItem;
    @SuppressWarnings("unused")
    private AMSView mainView;

    public AMSMenuBar(AMSView mainView) {
        this.mainView = mainView;
        // create Menu Bar
        menubar = new JMenuBar();
        
        // create Menu
        mainMenu = new JMenu("Main Menu");
        mainMenu.setMnemonic(KeyEvent.VK_M);
        menubar.add(mainMenu);

        // create Menu Items
        newProgram = new JMenuItem("Initialise Program", KeyEvent.VK_N);
        newProgram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
            InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
        addCourse = new JMenuItem("Add Course", KeyEvent.VK_A);
        addCourse.setEnabled(false);
        removeCourse = new JMenuItem("Remove Course", KeyEvent.VK_R);
        removeCourse.setEnabled(false);
        exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke('X', 
        		InputEvent.ALT_MASK));

        // add MenuItems to the Menu
        mainMenu.add(newProgram);
        mainMenu.add(addCourse);
        mainMenu.add(removeCourse);
        mainMenu.addSeparator();
        mainMenu.add(exitItem);

        // and the Menu to the MenuBar
        menubar.add(mainMenu);

        // attach the MenuBar to the Frame
        mainView.setJMenuBar(menubar);
        
        // add action listener to MenuBar items
        ActionController action = new ActionController(mainView);
        newProgram.addActionListener(action);
        addCourse.addActionListener(action);
        removeCourse.addActionListener(action);
        exitItem.addActionListener(action);
        

    }
    
    // method to toggle add option on or off
    public void toggleAddOption() {
        if(addCourse.isEnabled())
            addCourse.setEnabled(false);
        else 
            addCourse.setEnabled(true);
    }
    
    // method to toggle remove option on or off
    public void toggleRemOption() {
        if(removeCourse.isEnabled())
            removeCourse.setEnabled(false);
        else 
            removeCourse.setEnabled(true);
    }
    // returns the initialise program menu item for manipulation
    public JMenuItem getNewProgram() {
        return newProgram;
    }
    // resets menu items to post program initialised state.
    public void resetItems() {
        addCourse.setEnabled(true);
        removeCourse.setEnabled(false);
    }
}
