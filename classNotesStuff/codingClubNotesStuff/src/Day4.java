// Importing Scanners
// Which is part of a package
import java.util.Scanner;
import examplePackage.Example;

// methods and everything else: lowerCamelCase e.g. hitOn
// classes: Capitalised e.g. Student

public class Day4 {
    public static void main(String[] args) {
        System.out.println(test("Hello", '.'));
        Example.publicTest();
    }

    // Structure of a method
    // Access   Other       Return                      Method
    // Modifier Keywords    Type (Of Data, or Void)     Name (parameter(s))     { method code }

    private static String test(String msg, char add){
        System.out.println("test method will return \"" + msg + add + "!\"");
        return msg + add + "!";
    }

    private static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, My name is java! What's yours? \nEnter here: ");
        String input = scanner.next();
        System.out.println("Nice to meet you, " + input);

        // next() vs nextLine
        // next only reads 1 word
        // nextLine reads the entire input including spaces
    }
}
