import Day5.*;

public class Main {
    public static void main(String[] args) {
        Person arcadi = new Person("Arcadi", 16.2, "A+"); // Integers can be put into a double parameter without issues (will be auto converted)
        System.out.println(arcadi.name);
        arcadi.Introduce();
        Person.successCode++; // Static Public fields/methods can be interacted with outside of that class without making an instance of it
        System.out.println(arcadi.getName());

        Person ashley = new Person();
        System.out.println(ashley.BLOOD_TYPE);
        System.out.println(ashley.age);
    }
}
