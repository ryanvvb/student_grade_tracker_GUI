//***************************************************************************************************************************
// CLASS: GradebookWriter.java
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

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file name passed to the ctor.
 */
public class GradebookWriter extends PrintWriter {

    /**
     * GradebookWriter()
     * Call the super class ctor that takes a String.
     */
    public GradebookWriter(String pFname) throws FileNotFoundException {
        super(pFname);
    }

    /**
     * writeGradebook()
     * Writes the gradebook info to the file, which was opened in the ctor.
     * <p>
     * PSEUDOCODE:
     * EnhancedFor each student in pRoster.getStudentList() Do
     * Call println(student)
     * End For
     * Call close()
     */
    public void writeGradebook(Roster pRoster) {
        try {
            GradebookWriter writes = new GradebookWriter("Gradebook.txt");
            for (Student pStudent : pRoster.getStudentList()) {
                writes.println(pStudent);
            }
            writes.close();

        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
    }
}
