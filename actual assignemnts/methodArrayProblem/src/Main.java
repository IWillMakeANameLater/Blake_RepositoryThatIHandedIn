public class Main {

    // Copies an array's contents on to a new array then returns the new array
    // It only iterates up to the length of the smaller array
    // In order to avoid any index out-of-bounds error
    static int[] arrayCopy(int[] oldArray, int[] newArray){
        int iterationLimit = Math.min(oldArray.length, newArray.length);
        for(int i = 0; i < iterationLimit; i++){
                newArray[i] = oldArray[i];
            }
        return newArray;
    }

    // Appends a value to the end of a copy of a given array and then returns the cloned array
    static int[] arrayAppend(int[] inputArray, int appendVar){
        int[] newArray = arrayCopy(inputArray, new int[inputArray.length+1]);
        newArray[newArray.length-1] = appendVar;
        return newArray;
    }

    // Takes a given array and removes the last variable from a copy of it, then returns a copy
    // Note this doesn't return the removed variable that other pop methods may return
    static int[] arrayPop(int[] inputArray){
        int[] newArray = arrayCopy(inputArray, new int[inputArray.length-1]);
        return newArray;
    }

    static int[] arrayInsert(int[] inputArray, int insertVar, int insertPos){
        int[] newArray = arrayCopy(inputArray, new int[insertPos]);
        newArray = arrayAppend(newArray, insertVar);
        for(int i = insertPos; i < inputArray.length; i++){
            newArray = arrayAppend(newArray, inputArray[i]);
        }
        return newArray;
    }

    // Main method
    public static void main(String[] args) {
        int[] baseIntArray = {1,2,3,4,5};
        int[] appendedArray = arrayAppend(baseIntArray, 6);
        int[] poppedArray = arrayPop(baseIntArray);
        int[] insertedArray = arrayInsert(baseIntArray, 7, 2);
    }
}

/*

 */