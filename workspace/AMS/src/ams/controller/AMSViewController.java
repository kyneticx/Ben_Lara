package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import ams.view.AMSView;

// Main view controller simply prevents accidental closure of the program
// by confirming the user wants to exit before closing
public class AMSViewController extends WindowAdapter implements ActionListener {
    
    private AMSView frame;

    public AMSViewController(AMSView frame) {
        this.frame = frame;
    }    
        
    @Override
    public void windowClosing(WindowEvent e) {
        confirmExit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirmExit();
    }
    
    public void confirmExit() {
        int exit = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit?",
                "Press Yes to Exit, No to stay",
                JOptionPane.YES_NO_OPTION);

        if(exit == JOptionPane.YES_OPTION)
            System.exit(0);    
    }    
}
