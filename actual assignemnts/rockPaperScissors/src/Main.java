import java.util.*; // why not import the entire library instead of just scanner in case i need to use other utilities (but it's probably slower this way)

public class Main {
    public static void main(String[] args) {
        Scanner userActionInput = new Scanner(System.in); // Set up a scanner to take user input.
        boolean isPlaying = true;

        // Keep running the game until the person closes the game
        while (isPlaying){

            int gameState = 0; // 1 = win, 0 = tie, -1 = lose
            int computerAction = (int)Math.ceil(Math.random()*3); // Integer that determines the action that the CPU chooses. Honestly, credits to Justin for this idea.

            System.out.println(" Choose an action. 1 = Rock, 2 = Paper, 3 = Scissors.");

            int userAction = 0;
            try{
                userAction = (int)userActionInput.nextInt(); // Take the user's action (as an int, hopefully)
            } catch (Exception e) {
                System.out.println("Input was not an integer."); // If it's not an int for some reason
            }

            if (userAction != computerAction){ // Checks if the actions are different (they're always a tie if they are the same)
                switch (userAction) {
                    case 1 -> { // Rock
                        System.out.println("You chose rock.");
                        if (computerAction == 3) { // Rock vs Scissors
                            gameState = 1;
                        } else {
                            gameState = -1;
                        }
                    }
                    case 2 -> { // Paper
                        System.out.println("You chose Paper.");
                        if (computerAction == 1) { // Paper vs Rock
                            gameState = 1;
                        } else {
                            gameState = -1;
                        }
                    }
                    case 3 -> { // Scissors
                        System.out.println("You chose Scissors.");
                        if (computerAction == 2) { // Scissors vs Paper
                            gameState = 1;
                        } else {
                            gameState = -1;
                        }
                    }
                    default -> {
                        System.out.println("No actions selected (input was out of bounds)."); // If they're a bad player
                        gameState = -2; // This is a state that is neither a tie, win, or loss, since the user's action isn't valid
                    }
                }
            }

            switch (computerAction) { // Print what the computer chose to do.
                case 1 -> System.out.println("The computer chose rock.");
                case 2 -> System.out.println("The computer chose paper.");
                case 3 -> System.out.println("The computer chose scissors.");
                default -> System.out.println("the computer somehow picked an action that isn't possible."); // Just in case
            }

            switch(gameState){ // Print based on if the user win, lost, or tied
                case -1:
                    System.out.println("You lose");
                    break;
                case 0:
                    System.out.println("You tied!");
                    break;
                case 1:
                    System.out.println("Yay! You won!");
                    break;
                default: // This currently only happens in gameState == -2
                    System.out.println("Something went wrong with this game. Try again.");
                    break;
            }

            char keepPlaying = '?'; // char that stores the user's input when asked if they want to keep playing

            while (keepPlaying == '?'){ // keeps asking them until they say yes (y) or no (n)
                System.out.println("Do you want to play again? (y or n)");
                try{
                    keepPlaying = (char)userActionInput.next().charAt(0); // never trust the user
                }catch (Exception e){
                    System.out.println("Something went wrong, please try again.");
                    keepPlaying = '?'; // restart loop if they decide to do the stupid
                }
                switch (keepPlaying) {
                    case 'y' -> // restarts the game loop (by basically doing nothing but printing a message)
                            System.out.println("Restarting game.");
                    case 'n' -> { // closes the loop by setting isPlaying to false
                        System.out.println("Closing game");
                        isPlaying = false;
                    }
                    default -> {
                        System.out.println("Invalid input, please try again.");
                        keepPlaying = '?'; // restarts the asking loop again
                    }
                }
            }
        }
    }
}
