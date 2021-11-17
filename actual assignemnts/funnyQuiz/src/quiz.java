import java.util.*;

public class quiz {
    public static void main(String[] args) {
        System.out.println("Time for quiz. You can't say no to this.");
        int correctChoice;
        int score = 0;
        int inputAnswer;

        Scanner answerQuery = new Scanner(System.in);

        // Question 1

        System.out.println("Question 1 - King age");
        System.out.println(" 1 - around 8");
        System.out.println(" 2 - over 9000 ");
        System.out.println(" 3 - still 0");
        System.out.println(" 4 - 18 in dog years");
        correctChoice = 1;
        inputAnswer = answerQuery.nextInt();

        if (inputAnswer == correctChoice){
            System.out.println("Yes");
            score++;
        }else{
            System.out.println("Wrong");
        }

        // Question 2

        System.out.println("Question 2 - Hooty consequence");
        System.out.println(" 1 - Lumity");
        System.out.println(" 2 - Hootsifer");
        System.out.println(" 3 - Edaine");
        System.out.println(" 4 - Hootlingo");
        correctChoice = 1;
        inputAnswer = answerQuery.nextInt();

        if (inputAnswer == correctChoice){
            System.out.println("Yes");
            score++;
        }else{
            System.out.println("Wrong");
        }

        // Question 3

        System.out.println("Question 3 - Camillia Tool");
        System.out.println(" 1 - La Chancla");
        System.out.println(" 2 - Belt");
        System.out.println(" 3 - Spoon");
        System.out.println(" 4 - Ruler");
        correctChoice = 1;
        inputAnswer = answerQuery.nextInt();

        if (inputAnswer == correctChoice){
            System.out.println("Yes");
            score++;
        }else{
            System.out.println("Wrong");
        }

        if (score == 3){
            System.out.println("You either know what this quiz is based on or are very lucky");
        }else if (score > 0){
            System.out.println("Meh");
        }else {
            System.out.println("Go back to elementary. Oh and watch more TV");
        }
    }
}
