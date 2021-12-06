import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car aCar = new Car();

        // setters: e.g.
        aCar.setName("Bad Car"); // returns Void

        // getters: e.g.
        aCar.getSpeed(); // return Int

        System.out.println(aCar);

        Car car2 = new Car(3,3, 999, "car2");
        System.out.println(car2);

        car2.owner = new Owner("Paul");
        car2.owner.getAngry();

        ArrayList<Owner> owners = new ArrayList<>();
        owners.add(new Owner("Johnny"));
        for(int i = 0; i < 10; i++){
            owners.add(new Owner("Owner"+i));
        }
        owners.get(0).getAngry();
        owners.indexOf()
    }
}
