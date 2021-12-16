

// This class contains a set of integers that are unique

// Examples of sets {1,2,3,4,5}
// Example of non sets {1,2.5,3,} , {1,2,3,4,3,}

import java.util.ArrayList;


/**
 * Banana
 */
public class IntegerSet {

    private ArrayList<Integer> integers;

    // old way
    //requires: parameters and restrictions (e.g. unique integer)
    //modifies: objects being modified (e.g. this, integers arraylist)
    //effects: what the method does ( if the number is unique (not in the set) add it to the set
    public void addNumber(int num){

    }

    /**
     * Retrieves and removes a number from the integer set.
     * @param num that is contained within the set
     *
     * @return the number, or null if it is not in the set
     */
    public Integer retrieve(int num){
        for(Integer i: integers){
            if(i.equals(num)){
                return i;
            }
        }
        return null;
    }

    public int size(){
        return -1;
    }

    public boolean contains(int num){
        return false;
    }

}
