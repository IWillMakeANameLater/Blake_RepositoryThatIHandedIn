import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Problem 1
        System.out.println("------------Problem 1------------");
        int[] randArray = new int[20];
        int occuranceTimes = 0;
        for (int i = 0; i < randArray.length; i++ ){
            int randValue = (int)(Math.random()*6);
            randArray[i] = randValue;
            if (randValue == 1){
                occuranceTimes++;
            }
        }
        System.out.println("Number of 1's in the Array: " +occuranceTimes);

        // Problem 2
        System.out.println("------------Problem 2------------");
        int[] randArray2 = new int[10];
        for (int i = 0; i < randArray2.length; i++){
            randArray2[i] = (int)(Math.random()*100);
        }
        float arrayAverage = 0f;
        for (int i = 0; i < randArray2.length; i++){
            arrayAverage += randArray2[i];
        }
        arrayAverage = arrayAverage/randArray2.length;
        System.out.println("Average of Array: " + arrayAverage);

        // Problem 3
        System.out.println("------------Problem 3------------");
        System.out.println("First Index of Array: " + randArray2[0] + ", Last Index of Array: " + randArray2[randArray2.length - 1]);
        int firstInt = randArray2[0];
        randArray2[0] = randArray2[randArray2.length - 1];
        randArray2[randArray2.length - 1] =  firstInt;
        System.out.println("First Index of Array: " + randArray2[0] + ", Last Index of Array: " + randArray2[randArray2.length - 1]);

        // Problem 4
        System.out.println("------------Problem 4------------");
        System.out.println("Original Array: ");
        for (int i = 0; i < randArray2.length; i++){
            System.out.print(randArray2[i]);
            if (i == randArray2.length-1){
                break;
            }
            System.out.print(", ");
        }
        for (int i = 0; i < randArray2.length/2; i++){
            int firstNum = randArray2[i];
            randArray2[i] = randArray2[randArray2.length - (1 + i)];
            randArray2[randArray2.length - (1 + i)] = firstNum;
        }
        System.out.println("\nFlipped Array: ");
        for (int i = 0; i < randArray2.length; i++){
            System.out.print(randArray2[i]);
            if (i == randArray2.length-1){
                break;
            }
            System.out.print(", ");
        }
    }
}
