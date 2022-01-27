import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        TextFileSentenceReader testReader = new TextFileSentenceReader("ProgrammingHistory.txt");
        ArrayList<Sentence> fileSentences = testReader.getSentences();

        Scanner lookForWord = new Scanner(System.in);

        System.out.println("Type a word to search for in the file 'ProgrammingHistory.txt'.");
        String search = lookForWord.next();

        HashMap<Sentence, Integer> foundLocations = testReader.searchForWord(search);

        foundLocations.forEach((k, v) ->{
            System.out.println( "Found in : Sentence " + fileSentences.indexOf(k) + ", Word " + v);
        });
    }
}
