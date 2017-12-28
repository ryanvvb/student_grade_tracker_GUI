//***************************************************************************************************************************
// CLASS: View.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2017
// Project 3
//
// AUTHOR
//
// Ryan Van Valkenburg
//***************************************************************************************************************************
package p03;

import sun.plugin.dom.core.CoreConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH  = 500;
    public static final int FRAME_HEIGHT = 250;

    // Declare instance variables
    private JButton mClearButton;
    private JTextField[] mExamText;
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private Main mMain;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mSearchText;
    private Student mStudent;


    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the frame visible at the end.
     */
    public View(Main pMain){

        // Save a reference to the Main object pMain in mMain.
        mMain = pMain;

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout.
        // Add a JLabel "Student Name: " to panelSearch
        // Create mSearchText and make the field 25 cols wide
        // Add mSearchText to the panel
        // Create mSearchButton
        // Make this View the action listener for the button
        // Add the button to the panel
        JPanel panelSearch = new JPanel();
        JLabel name = new JLabel("Student Name: ");
        panelSearch.add(name);
        panelSearch.setLayout(new FlowLayout());
        mSearchText = new JTextField(25);
        panelSearch.add(mSearchText);
        mSearchButton = new JButton("Search");
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);



        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout.
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of CourseConstants.NUM_HOMEWORKS JTextFields
        // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
        //     Create textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        JPanel panelHomework = new JPanel();
        JLabel homework = new JLabel("Homework");
        panelHomework.add(homework);
        panelHomework.setLayout(new FlowLayout());
        mHomeworkText = new JTextField[CourseConstants.NUM_HOMEWORKS];
        for (int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            mHomeworkText[i] = new JTextField(5);
            panelHomework.add(mHomeworkText[i]);
        }

        // Create the exam panel which contains the "Exam: " label and the two exam text fields. The pseudocode is omitted
        // because this code is very similar to the code that creates the panelHomework panel.
        JPanel panelExam = new JPanel();
        JLabel exam = new JLabel("Exam");
        panelExam.add(exam);
        panelExam.setLayout(new FlowLayout());
        mExamText = new JTextField[CourseConstants.NUM_EXAMS];
        for (int i = 0; i<= CourseConstants.NUM_EXAMS - 1; i++){
            mExamText[i] = new JTextField(5);
            panelExam.add(mExamText[i]);
        }

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout.
        // Create the Clear button mClearButton.
        // Make this View the action listener for mClearButton.
        // Add the  Clear button to the panel.
        // Repeat the three above statements for the Save button.
        // Repeat the three above statements for the Exit button.
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);


        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout.
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain.
        // Add panelExam to panelMain.
        // Add panelButtons to panelMain.
        JPanel panelMain = new JPanel();
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        // Initialize the remainder of the frame, add the main panel to the frame, and make the frame visible.
        setTitle("Gradebookulator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelMain);
        setVisible(true);
    }

    /**
     * actionPerformed()
     *
     * Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
     *
     * PSEUDOCOODE:
     * If the source of the event was the Search button Then
     *     lastName = retrieve the text from the mSearchText text field.
     *     If lastName is the empty string Then
     *         Call messageBox() to display "Please enter the student's last name."
     *     Else
     *         student = Call mMain.search(lastName)
     *         If student is null Then
     *             Call messageBox() to display "Student not found. Try again."
     *         Else
     *             Call displayStudent(student)
     *         End if
     *     End If
     * Else if the source of the event was the Save button Then
     *     If mStudent is not null Then Call saveStudent(mStudent)
     * Else if the source of the event was the Clear button Then
     *     Call clear()
     * Else if the source of the event was the Exit button Then
     *     If mStudent is not null Then Call saveStudent(mStudent)
     *     Call mMain.exit() to terminate the application
     * End If
     */
    @Override
    public void actionPerformed(ActionEvent pEvent){
        if (pEvent.getSource() == mSearchButton){
            String lastname = mSearchText.getText();
            mStudent = mMain.search(mSearchText.getText());
            if (lastname.equals("")){
                messageBox("Please enter a student's last name.");
            }
            else{
                mStudent = mMain.search(lastname);
                if(mStudent == null){
                    messageBox("Student was not found. Try again.");
                }
                else{
                    displayStudent(mStudent);
                }
            }
        }
        if (pEvent.getSource() == mSaveButton){
            if (mStudent!= null){
                saveStudent(mStudent);
            }
        }
        if (pEvent.getSource() == mClearButton){
            clear();
        }
        if (pEvent.getSource() == mExitButton){
            if (mStudent != null){
                saveStudent(mStudent);
                mMain.exit();
            }

        }
    }

            /**
             * clear()
             *
             * Called when the Clear button is clicked. Clears all of the text fields by setting the contents to the empty string.
             * After clear() returns, no student information is being edited or displayed.
             *
             * PSEUDOCODE:
             * Set the mSearchText text field to ""
             * Set each of the homework text fields to ""
             * Set each of the exam text fields to ""
             * Set the mStudent reference to null
             */
    private void clear(){
        mSearchText.setText("");
        for (int i = 0; i <= CourseConstants.NUM_HOMEWORKS-1; i++){
            mHomeworkText[i].setText("");
        }
        for (int i = 0; i <= CourseConstants.NUM_EXAMS-1; i++){
            mExamText[i].setText("");
        }
        mStudent = null;

    }

            /**
             * displayStudent()
             *
             * Displays the homework and exam scores for a student in the mHomeworkText and mExamText text fields.
             *
             * PSEUDOCODE:
             * For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
             *     int hw = pStudent.getHomework(i)
             *     String hwstr = convert hw to a String (Hint: Integer.toString())
             *     mHomeworkText[i].setText(hwstr)
             * End For
             * Write another for loop similar to the one above to place the exams scores into the text fields
             */
    public void displayStudent(Student pStudent){
        for (int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            int hw = pStudent.getHomework(i);
            String hwstr = Integer.toString(hw);
            mHomeworkText[i].setText(hwstr);

        }
        for (int i = 0; i<= CourseConstants.NUM_EXAMS - 1; i++){
            int exam = pStudent.getExam(i);
            String examstr = Integer.toString(exam);
            mExamText[i].setText(examstr);
        }
    }

    /**
     * messageBox()
     *
     * Displays a message box containing some text.
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent()
     *
     * Retrieves the homework and exam scores for pStudent from the text fields and writes the results to the Student record
     * in the Roster.
     *
     * PSEUDOCODE:
     * For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
     *     String hwstr = mHomeworkText[i].getText()
     *     int hw = convert hwstr to an int (Hint: Integer.parseInt())
     *     Call pStudent.setHomework(i, hw)
     * End For
     * Write another for loop similar to the one above to save the exam scores
     */
    public void saveStudent(Student pStudent){
        mStudent = mMain.search(mSearchText.getText());
        for (int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }
        for (int i = 0; i <= CourseConstants.NUM_EXAMS - 1; i++){
            String examstr = mExamText[i].getText();
            int exam = Integer.parseInt(examstr);
            pStudent.setExam(i, exam);
        }
    }

}
