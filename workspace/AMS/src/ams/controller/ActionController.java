package ams.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ams.model.CoreCourse;
import ams.model.Course;
import ams.model.ElectiveCourse;
import ams.model.Program;
import ams.model.exception.ProgramException;
import ams.model.facade.AMSModel;
import ams.view.AMSView;

/*
 * ActionController Class is used by our menubar and buttons to initialise/reset
 * the program and add and remove courses
 */
public class ActionController implements ActionListener {

    private AMSView frame;
    private AMSModel model;
    
    // constructor
    public ActionController(AMSView mainView) {
        frame = mainView;
        model = frame.getModel();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	// get the command
        String command = e.getActionCommand();
        
        // if it is exit confirm before exiting
        if (command.equals("Exit")) {
            int exit = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Press Yes to Exit, No to stay",
                    JOptionPane.YES_NO_OPTION);
            if(exit == JOptionPane.YES_OPTION)
                System.exit(0);    
        }
        // initialising the program we dont need to confirm as there is no 
        // information to lose at this point
        else if (command.equals("Initialise Program")) { 
            Program program;
            program = inputProgram();
            if (program != null) {
                model.addProgram(program);
                frame.getStatusBar().updateStatusBar();
                frame.getButtons().toggleAddButton();
                frame.getMenubar().toggleAddOption();
                frame.getButtons().getReset().setText("Reset Program");
                frame.getMenubar().getNewProgram().setText("Reset Program");
            }
        }
        // however if we are resetting the program we need to confirm as there
        // is the potential to lose all program and course information
        else if (command.equals("Reset Program")) {
            int yes = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want reset the Program??",
                    "Press Yes to Reset, No to Cancel",
                    JOptionPane.YES_NO_OPTION);
            if(yes == JOptionPane.YES_OPTION) {
                Program program;
                program = inputProgram();
                if (program != null) {
                    model.addProgram(program);
                    frame.getStatusBar().updateStatusBar();
                    frame.getProgramMap().updateProgramMap();
                    frame.getButtons().resetButtons();
                    frame.getMenubar().resetItems();
                }
            }
        }
        
        // to add a course we call the input course function 
        else if (command.equals("Add Course")) {
            Course course;
            course = inputCourse();
            
            // if the returned course is null the user has cancelled so dont
            // attempt to add
            if (course != null ) {
            	// otherwise attempt to add the course - we shouldnt get an
            	// exception as we have performed error checking when inputting
            	// the course so no exceptions should be thrown
            	try {
                	model.addCourse(course);
                	frame.getStatusBar().updateStatusBar();
                	frame.getProgramMap().updateProgramMap();
            	} catch (ProgramException e1) {
                	e1.printStackTrace();
            	}
            }
            
        }
        // to remove a course we must first confirm with the user they
        // wish to do so
        else if (command.equals("Remove Course")) {
            int yes = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want remove the selected Course??",
                    "Press Yes to Remove, No to Cancel",
                    JOptionPane.YES_NO_OPTION);
            // if they do they we attempt to remove the course - if an exception
            // is thrown the course isnt added and we dont need to update the 
            // other subviews as nothing has happened - however we do output
            // a warning message to the user to let them know why the course
            // was not removed.
            if(yes == JOptionPane.YES_OPTION) {
                Course course;
                course = frame.getButtons().getSelected();
                try {
                    model.removeCourse(course.getCode());
                    frame.getStatusBar().updateStatusBar();
                    frame.getProgramMap().updateProgramMap();
                } catch (ProgramException e1 ) {
                    String message;
                    message = e1.getMessage();
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
        }
    }
    
    
    // the input course method returns a course or null if user has cancelled
    public Course inputCourse() {
    	// setup our test variables and input variables
        boolean test1 = true, test2 = true, test3 = true;
        Course course = null;
        String code = null;
        String title = null;
        int CP = 12;
        String [] prereqs = null;
        Object[] prereqDialog = null;
        Object[] array = null;
        
        // intialise the various fields used in the input query
        JCheckBox checkbox = new JCheckBox("Prerequisites?");
        JTextField courseCode = new JTextField(6);
        JTextField courseTitle = new JTextField(30);
        JRadioButton core = new JRadioButton("Core");
        core.setSelected(true);
        JRadioButton elective = new JRadioButton("Elective");
        ButtonGroup group = new ButtonGroup();
        group.add(core);
        group.add(elective);
        Course [] courses = model.getAllCourses();
        
        // error fields to be used if the user has invalid inputs
        JLabel errorfield1 = new JLabel("");
        JLabel errorfield2 = new JLabel("");
        JLabel errorfield3 = new JLabel("");
        errorfield1.setForeground(Color.RED);
        errorfield2.setForeground(Color.RED);
        errorfield3.setForeground(Color.RED);
        
        // grabs the list of courses to be used in the prereqs dialog
        if (courses != null) {
             prereqDialog = new Object[courses.length];
             for (int i = 0; i < courses.length; i++) {
                 prereqDialog[i] = new JCheckBox(courses[i].getTitle());
             }
        }
        // if there are courses already we setup the dialog with a prereq option
        if (model.getAllCourses() != null) {
            Object[] tempArray = {
                errorfield1,
                errorfield2,
                errorfield3,
                new JLabel("Course Code: (6 AlphaNumeric Characters)"),
                courseCode,
                new JLabel("Course Title: (Minimum 2 characters"),
                courseTitle,
                new JLabel("Core or Elective:"),
                core,
                elective,
                checkbox
            };
            array = tempArray;
        }
        // otherwise it is the default view
        else {
               Object[] tempArray = {
                        errorfield1,
                        errorfield2,
                        errorfield3,
                        new JLabel("Course Code:"),
                        courseCode,
                        new JLabel("Course Title:"),
                        courseTitle,
                        new JLabel("Core or Elective:"),
                        core,
                        elective,
                    };
               array = tempArray;
        }
        // here we present the dialog to the user and ask for their inputs
        // and then check them to see they match the desired input validation
        int result;
        do {
            result = JOptionPane.showConfirmDialog(frame, array, 
                   "Please Enter Course Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
            	// grab the inputted text for validation
                code = courseCode.getText();
                title = courseTitle.getText();
                // validation tests
                if (code.length() > 0) {
                    test1 = isAlphaNumeric(code);
                    if (!test1)
                        errorfield1.setText("Course Code must be" +
                        		" alphanumeric!");
                    else
                        errorfield1.setText("");
                    if (code.length() != 8) {
                        test2 = false;
                        errorfield2.setText("Course Code must be exactly 8" +
                        		" characters long");
                    }
                    else {
                        test2 = true;
                        errorfield2.setText("");
                    }
                }
                else {
                    test2 = false;
                    errorfield2.setText("Course Code must be exactly 8" +
                    		" characters long");
                }
                if (title.length() > 0) {
                    if (title.length() < 2) {
                        test3 = false;
                        errorfield3.setText("Course title must be a minimum" +
                        		" of 2 characters");
                    }
                    else {
                        test3 = true;
                        errorfield3.setText("");
                    }
                }
                else {
                    test3 = false;
                    errorfield3.setText("Course title must be a minimum of" +
                    		" 2 characters");
                }
            }
            else {
                break;
            }
            // all tests must pass otherwise the input dialog will restart with
            // the new error messages
        } while(!test1 || !test2 || !test3);
        
        // if the course is an elective we present a small dialog for the
        // user to choose 6 or 12 credit points 
        if (result == JOptionPane.OK_OPTION && elective.isSelected()) {
            JRadioButton six = new JRadioButton("6");
            JRadioButton twelve = new JRadioButton("12");
            ButtonGroup elect = new ButtonGroup();
            elect.add(six);
            elect.add(twelve);
            twelve.setSelected(true);
            errorfield1.setText("");

            Object[] electiveInput = {
                    errorfield1,
                    six,
                    twelve
            };

            int result2 = JOptionPane.showConfirmDialog(
                frame,
                electiveInput,
                "Please Choose Number of Credit Points",
                JOptionPane.OK_CANCEL_OPTION );
            if (result2 == JOptionPane.OK_OPTION) {
                if (six.isSelected())
                    CP = 6;
                else if (twelve.isSelected())
                    CP = 12;
              }
        }
        // if the user has checked the prerequisites box then we present a list
        // of all the current subjects to add as prerequisites thus preventing
        // any errors with prerequisite codes
        if (result == JOptionPane.OK_OPTION && checkbox.isSelected()) {
            int result2 = JOptionPane.showConfirmDialog(frame, prereqDialog,
                    "Please select prerequisites",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result2 == JOptionPane.OK_OPTION) {
                String pr = null;
                for (int i = 0; i < courses.length; i++){
                    JCheckBox tempCB = (JCheckBox) prereqDialog[i];
                    if (tempCB.isSelected())
                        if (pr == null)
                            pr = courses[i].getCode() + ":";
                        else
                            pr += courses[i].getCode() + ":";
                }
                if (pr != null) {
                    prereqs = pr.split(":");
                }
            }
        }
        // finally we setup the course ready to return
        if (result == JOptionPane.OK_OPTION && core.isSelected()) {
            course = new CoreCourse(code, title, prereqs);
        }
        else if (result == JOptionPane.OK_OPTION && elective.isSelected()) {
            course = new ElectiveCourse(code, title, CP, prereqs);
        }
        // and return it
        return course;
    }
    
    // our input program method - very similar to the addcourse method but much'
    // simpler -  with input validation
    public Program inputProgram() {
    	
    	// test and input variables
        boolean test1 = true, test2 = true, test3 = true;
        Program program = null;
        String title;
        String code;
        
        // components for our dialog
        JTextField progCode = new JTextField(6);
        JTextField progTitle = new JTextField(30);
        JLabel errorfield1 = new JLabel("");
        JLabel errorfield2 = new JLabel("");
        JLabel errorfield3 = new JLabel("");
        errorfield1.setForeground(Color.RED);
        errorfield2.setForeground(Color.RED);
        errorfield3.setForeground(Color.RED);

        Object[] array = {
                errorfield1,
                errorfield2,
                new JLabel("Program Code:"),
                progCode,
                errorfield3,
                new JLabel("Program Title:"),
                progTitle,
            };
        
        // input dialog 
        do {
            int result = JOptionPane.showConfirmDialog(frame, array, 
                  "Please Enter Program Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.CANCEL_OPTION) {
                program = null;
                break;
            }
            if (result == JOptionPane.OK_OPTION) {
                code  = progCode.getText();
                title = progTitle.getText();
                if (code.length() > 0) {
                    test1 = isAlphaNumeric(code);
                    
                    // input testing
                    if (!test1)
                        errorfield1.setText("Program Code must be" +
                        		" alphanumeric!");
                    else
                        errorfield1.setText("");
                    if (code.length() != 6) {
                        test2 = false;
                        errorfield2.setText("Program Code must be exactly" +
                        		" 6 characters long");
                    }
                    else {
                        test2 = true;
                        errorfield2.setText("");
                    }
                }
                else {
                    test2 = false;
                    errorfield2.setText("Program Code must be exactly 6" +
                    		" characters long");
                }
                if (title.length() > 0) {
                    if (title.length() < 2) {
                        test3 = false;
                        errorfield3.setText("Program title must be a minimum" +
                        		" of 2 characters");
                    }
                    
                    else {
                        test3 = true;
                        errorfield3.setText("");
                    }
                }
                else {
                    test3 = false;
                    errorfield3.setText("Program title must be a minimum of" +
                    		" 2 characters");
                }
                if (test1 && test2 && test3) {
                    program = new Program(code, title);
                }
            }
            // continue until all tests pass
        }while((!test1 || !test2 || !test3));
        return program;
    }
    
    // simple alpha numeric test takes a string and returns true if it is alpha
    // numeric
    private boolean isAlphaNumeric(String s) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        boolean b = p.matcher(s).find();
        return !b;
    }
}
