package ams.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ams.model.Course;
import ams.view.AMSView;
import ams.view.ProgramMap;


// program map controller one is assigned to each course panel that is added
// as a mouse listener for selection/removal purposes
public class ProgramMapController implements ActionListener, MouseListener {
    private final static Border BORDERT1 = 
    		BorderFactory.createLineBorder(Color.RED, 10);
    private final static Border BORDERT2 = 
    		BorderFactory.createLineBorder(Color.RED, 1);
    private final static Border BORDERD1 = 
    		BorderFactory.createLineBorder(Color.BLACK, 10);
    private final static Border BORDERD2 = 
    		BorderFactory.createLineBorder(Color.BLACK, 1);
    private JPanel coursePanel;
    private Course course;
    private AMSView frame;
    private int position;
    private int type;
    private Border border = null;


    // constructor
    public ProgramMapController(int a,int b, JPanel p, ProgramMap d, Course c) {
        coursePanel = p;
        course = c;
        frame = d.getFrame();
        type = a;
        position = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        // whenever the mouse is clicked on a particular panel this
    	// event is fired for selection/removal purposes
        if (frame.getProgramMap().isSelected(position)  && type == 1) {
            frame.getProgramMap().resetBorders();
            coursePanel.setBorder(BORDERD1);
            frame.getProgramMap().setSelected(position, false);
            if ((frame.getButtons().getRemove().isEnabled())) {
                frame.getButtons().toggleRemButton();
                frame.getMenubar().toggleRemOption();
            }
        }
        else if (frame.getProgramMap().isSelected(position) && type == 2) {
            frame.getProgramMap().resetBorders();
            coursePanel.setBorder(BORDERD2);
            frame.getProgramMap().setSelected(position, false);
            if ((frame.getButtons().getRemove().isEnabled())) {
                frame.getButtons().toggleRemButton();
                frame.getMenubar().toggleRemOption();
            }
        }
        else {
            frame.getProgramMap().resetBorders();
            if (type == 1) 
                border = BORDERT1;
            else
                border = BORDERT2;
            coursePanel.setBorder(border);
            frame.getProgramMap().setSelected(position, true);
            if (!(frame.getButtons().getRemove().isEnabled())) {
                frame.getButtons().toggleRemButton();
                frame.getMenubar().toggleRemOption();
            }
            frame.getButtons().setSelected(course);
        }
        
    }
}
