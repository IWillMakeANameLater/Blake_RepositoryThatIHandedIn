package Day5;

public class Person {

    // Fields
    public static int successCode = 0; // Static makes the field/method tied to the class itself instead of an object or an instance of that class

    public String name; // Not initialised
    public double age;
    public final String BLOOD_TYPE; // finalised, cannot be changed, can use enumerations (enums) for this


    public Person(String name, double age, String bloodType) { // Access modifier and class name, a private constructor leads to an object that cannot be instatiated normally, can only be created with polymorphism
        BLOOD_TYPE = bloodType; // because it is a FINAL value, you don't need a "this"
        this.age = age; // "this" refers to the object instance itself
        this.name = name;
    }

    public Person(){
        name = "Ashley";
        age = 17;
        BLOOD_TYPE = "A+";
    }

    // Methods

    public void Introduce() {
        System.out.println("Hello! My name is " +  name + " and I am " + (int)Math.floor(this.age) + " years old!"); // You will not have a type error as Java auto converts data types in print
    }

    public void Introduce(String )
    
    // Getters and setters

    public String getName(){
        return this.name;
    }
}
