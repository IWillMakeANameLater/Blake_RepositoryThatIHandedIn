public class Main {

    public static void print(String line) {
        System.out.println(line);
    }

    // calculate the square root of a perfect square integer
    public static double sqrt(double sqrt) {
        double low = 0;
        double high = sqrt;
        double mid = (high + low)/2;
        double epsilon = .1;
        while((Math.abs(((mid*mid) - sqrt)) >= epsilon && mid < sqrt )){
            if (mid > sqrt){
                mid = -1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,3));
        // Class Notes:
        // println is a method and so is pow
        // Naming Convention: only Classes and Constants are capitalized (at the start?)
        // Methods are like functions of the object
        // They can take arguments/parameters (additional information)
        // the main method is a method that is run by java when the program is run

        // method signatures are an unique indentification of a method

        // public - can be accessed internally and externally (access type)

        // static methods are methods that are part of a class and
        // do not require an instance of that class (called an object)

        // return type
        // void - returns nothing
        // specifiying a data type in place of void makes Java expect the method to return that type of data type

        // regardless of where it is in the method, a return statement
        // will stop the method from being continued
        // and returns the specified value to wherever it was called

        // methods don't run until they are called
        // they can be called an indefinete amount of times (as long as the rate isn't bigger than the
        // bandwith, otherwise you would get a stack overflow

        print("Python style printing");
    }

}
