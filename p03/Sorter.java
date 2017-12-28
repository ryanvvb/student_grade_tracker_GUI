//***************************************************************************************************************************
// CLASS: Sorter.java
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

public class Sorter {

    public static void sort(ArrayList<Student> pList) {
        quickSort(pList, 0, pList.size() - 1);
    }

    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        int i = pFromIdx - 1;
        int j = pToIdx + 1;
        Student pivot = pList.get(pFromIdx);

        while (i < j) {
            i++;
            while (pList.get(i).compareTo(pivot) < 0) {
                i++;
            }
            j--;
            while (pList.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i < j) {
                swap(pList, i, j);
            }
        }
        return j;
    }

    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx >= pToIdx) {
            return;
        }

        int pIdx = partition(pList, pFromIdx, pToIdx);
        quickSort(pList, pFromIdx, pIdx);
        quickSort(pList, pIdx + 1, pToIdx);
    }

    /**
     * Simple swap method
     */

    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    }
}