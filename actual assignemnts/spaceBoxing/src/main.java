import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner planetQuery = new Scanner(System.in);
        double relativeMultiplier;

        System.out.println("What is your weight on Earth?");
        double earthWeight = planetQuery.nextDouble();

        System.out.println("Select a planet:");
        System.out.println("1 - Venus, 2 - Mars, 3 - Jupiter");
        System.out.println("4 - Saturn, 5 - Uranus, 6 - Neptune");

        System.out.println("What planet are you going to?");
        int planet = planetQuery.nextInt();

        switch(planet){
            case 1: // Venus
                relativeMultiplier = 0.78;
                break;
            case 2: // Mars
                relativeMultiplier = 0.39;
                break;
            case 3: // Jupiter
                relativeMultiplier = 2.65;
                break;
            case 4: // Saturn
                relativeMultiplier = 1.17;
                break;
            case 5: // Uranus
                relativeMultiplier = 1.05;
                break;
            case 6: // Neptune
                relativeMultiplier = 1.23;
                break;
            default:
                System.out.println("Planet not found! Assuming weight based on Earth");
                relativeMultiplier = 1.0;
                break;
        }
        System.out.println("Your weight is going to be " + relativeMultiplier * earthWeight + " pounds.");
    }
}
