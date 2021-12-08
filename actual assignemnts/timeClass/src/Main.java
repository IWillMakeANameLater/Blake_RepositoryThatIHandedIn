public class Main {
    public static void main(String[] args) {
        Time test = new Time(0, 0, 0); // Initial time
        System.out.println(test);

        for (int i = 0; i < 3600; i++){ // Go up a second for an hour
            test.nextSecond();
            System.out.println(test);
        }

        for (int i = 0; i < 3601; i++){ // Go back a second for an hour and a second ( to test how it fares against situations where time would be less than 00:00:00 )
            test.previousSecond();
            System.out.println(test);
        }

    }
}
