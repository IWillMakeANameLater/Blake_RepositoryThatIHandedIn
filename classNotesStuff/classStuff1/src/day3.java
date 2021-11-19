public class day3 {
    public static void main(String[] args) {
        // Arrays
        // Fixed sizes and data types of what they hold
        String[] names = {"Bab", "Bab ", "Sa"};
        int[] firstPrimeNumbers = {2, 3, 5, 7, 9};

        // for-i loop
        // first variable is the variable of the loop (such as i)
        // second statement is always a boolean expression (checked every iteration)
        // third is the incrementation of i (how it changes)
        // iteration doesn't always need to be defined
        // but it will usually lead to an infinite loop
        for (int i = 0; i < names.length; i++) {

        }

        // for-each loop
        for (int firstPrimeNumber : firstPrimeNumbers){
            // firstPrimeNumber can be seen as firstPrimeNumbers[i]
        }

        // while loop
        // repeats a block of code until condition met
        // or loop is exited through other means
        // such as break;
        int number = 0;
        while (true) {
            if (number == 3) {
                number++;
                continue;
            }
            // without curly braces you can technically have one statement after the if statement
            if (number == 5){
                break;
            }
            number++;
        }

        //do-while loop
        //like while loop
        //but it always runs at least once
        //check happens at the end of the cycle
        //instead of at the start of a loop
        number = 0;
        do {
            number++;
        } while (number != 2);

        // multiple data types in an array
        // - there is a super class called "object"
        // an array of Object(s) can store anything
        Object[] objects = {true, null, "123", 456};
    }
}
