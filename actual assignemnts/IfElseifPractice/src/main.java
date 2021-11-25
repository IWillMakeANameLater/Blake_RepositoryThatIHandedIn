import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner ageInput = new Scanner(System.in);

        System.out.println("Input age");
        int age = ageInput.nextInt();

        List<String> possibleActions = new ArrayList<String>();

        if (age <= 0){
            System.out.println("You aren't even alive yet!");
        }
        else{
            possibleActions.add("You can breathe");

            if (age > 5){
                possibleActions.add("You can go to school");
            }
            if (age > 16){
                possibleActions.add("You can get a job");
            }
            if (age > 18){
                possibleActions.add("You can live alone without a parent as well as a lot of other stuff");
            }
            if (age > 19){
                possibleActions.add("You can drink in Canada");
            }

            System.out.println("You can do the following:");
            for(String action : possibleActions){
                System.out.print("\n - " + action);
            }
        }
    }
}
