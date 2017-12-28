//***************************************************************************************************************************
// CLASS: Roster.java
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

import java.util.ArrayList;

/**
 * The Roster class encapsulates an ArrayList<Student> which stores the information for each student in the gradebook.
 */
public class Roster {

    // Declare mStudentList
    private ArrayList<Student> mStudentList;

    /**
     * Roster()
     * <p>
     * PSEUDOCODE:
     * Create mStudentList.
     */
    public Roster() {
        mStudentList = new ArrayList<>();
    }

    /**
     * addStudent()
     * <p>
     * PSEUDOCODE:
     * Add (append) pStudent to mStudentList.
     */
    public void addStudent(Student pStudent) {
        mStudentList.add(pStudent);
    }

    /**
     * getStudent()
     * Searches mStudentList for a Student with pLastName.
     * <p>
     * PSEUDOCODE:
     * index = Call Searcher.search(getStudentList(), pLastName)
     * If index == -1 Then Return null
     * Else return the Student object in mStudentList at index
     */
    public Student getStudent(String pLastName) {
        int index = Searcher.search(getStudentList(), pLastName);
        if (index == -1){
            return null;
        }
        else {
            return mStudentList.get(index);
        }
    }

    /**
     * getStudentList()
     * Accessor method for mStudentList.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * setStudentList()
     * Mutator method for mStudentList.
     */
    public void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster()
     * Called to sort the roster by last name.
     *
     * PSEUDOCODE:
     * Call Sorter.sort() passing the list of students
     */
    public void sortRoster(){
        Sorter.sort(getStudentList());
    }

    /**
     * Returns a String representation of this Roster. Handy for debugging.
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) result += student + "\n";
        return result;
    }
}
