//***************************************************************************************************************************
// CLASS: Student.java
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
 * The Student class stores the grade information for one Student.
 */
public class Student implements Comparable<Student> {

    // Declare the instance variables.
    private String mFirstName;
    private String mLastName;
    private ArrayList<Integer> mExamList;
    private ArrayList<Integer> mHomeworkList;

            /**
             * Student()
             *
             * PSEUDOCODE:
             * Save pFirstName and pLastName.
             * Create mExamList
             * Create mHomeworkList
             */
    public Student(String pLastName, String pFirstName){
        mLastName = pLastName;
        mFirstName = pFirstName;
        mExamList = new ArrayList<>();
        mHomeworkList = new ArrayList<>();
    }

            /**
             * addExam()
             *
             * PSEUDOCODE:
             * Call add(pScore) on getExamList() to add a new exam score to the list of exam scores.
             */
    public void addExam(int pScore){
        getExamList().add(pScore);
    }

            /**
             * addHomework()
             *
             * PSEUDOCODE:
             * Call add(pScore) on getHomeworkList() to add a new homework score to the list of homework scores.
             */
    public void addHomework(int pScore){
        getHomeworkList().add(pScore);
    }

            /**
             * compareTo()
             *
             * PSEUDOCODE:
             * Return: -1 if the last name of this Student is < the last name of pStudent
             * Return:  0 if the last name of this Student is = the last name of pStudent
             * Return:  1 if the last name of this Student is > the last name of pStudent
             * Hint: the last names are Strings.
             */
    @Override
    public int compareTo(Student pStudent){
        int result = getLastName().compareToIgnoreCase(pStudent.getLastName());
        if (result < 0){
            result = -1;
        }
        if (result == 0){
            result = 0;
        }
        if (result > 0){
            result = 1;
        }
        return result;
    }

    /**
     * getExam()
     *
     * Accessor method to retreive an exam score from the list of exams.
     */
    public int getExam(int pNum) {
        return getExamList().get(pNum);
    }

    /**
     * getExamList()
     *
     * Accessor method for mExamList.
     */
    private ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * getFirstName()
     *
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * getHomework()
     *
     * Accessor method to retrieve a homework score from the list of homeworks.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    private ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * setExam()
     *
     * Mutator method to store an exam score into the list of exam scores.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * setExamList()
     *
     * Mutator method for mExamList.
     */
    private void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework scores.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    private void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * toString()
     *
     * Returns a String representation of this Student. The format of the returned string shall be such that the Student
     * information can be printed to the output file, i.e:
     *
     * lastname firstname hw1 hw2 hw3 hw4 exam1 exam2
     */
    @Override
    public String toString(){
        String student = getLastName() + " " + getFirstName() + " " + getHomework(0) + " "
                + getHomework(1) + " " + getHomework(2) + " " + getHomework(3)
                + " " + getExam(0) + " " + getExam(1);
        return student;
    }
}
