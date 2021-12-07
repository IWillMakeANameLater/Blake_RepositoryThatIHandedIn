public class Main {
    // Static methods can only refer to static variables
    public static int outSideMain = 10; // This is a global variable, can be accessed anywhere

    // This variable only exists when an instance of this class is made
    // Trying to access these using a static method
    // could lead to a Null Pointer Exception
    public int objectVarOnly = 20; // This is not a global variable

    public static void aMethod(){
        insideMain = 20;    // insideMain doesn't exist in aMethod's scope, since it only exists in main's scope
    }
    
    public static void main(String[] args) {
        // Scope, Stack
        // Lifespan of variables and where they exist
        // Levels of existence
        // Primitives

        int insideMain = 10;
        //Variables made in methods only exists in methods and nowhere else

        if(true){
            insideMain = 15;
        }
    }
}
