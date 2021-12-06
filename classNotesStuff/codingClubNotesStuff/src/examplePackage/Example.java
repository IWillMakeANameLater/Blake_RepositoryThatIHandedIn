package examplePackage;

public class Example {

    // Accessible by other objects
    public static void publicTest(){

    }
    
    // Accessible when imported as a package
    static void packagePrivateTest(){

    }

    // Accessible only by self
    private static void privateTest(){

    }
}
