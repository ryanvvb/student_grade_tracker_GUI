//***************************************************************************************************************************
// CLASS: Searcher.java
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

public class Searcher {
 public static int search(ArrayList<Student> pList, String pKey) {
        int pLow = 0;
        int pHigh = pList.size() - 1;
        int result = Searcher.binarySearch(pList, pKey, pLow, pHigh);
        return result;
    }

    public static int binarySearch(ArrayList<Student> pList, String pKey, int pLow, int pHigh){

        // Base Case
        if (pLow > pHigh){
            return -1;
        }

        int middle = (pLow + pHigh) / 2;

        if (pKey.compareTo(pList.get(middle).getLastName()) == 0){
            return middle;
        }
        else if (pKey.compareTo(pList.get(middle).getLastName()) < 1){
            return binarySearch(pList, pKey, pLow, middle -1);
        }
        else {
            return binarySearch(pList, pKey, middle + 1, pHigh);
        }
    }
}