import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;

public class TextFileSentenceReader {

    //Fields
    private String currentFile;
    private ArrayList<Sentence> sentences;

    //Constructors

    public TextFileSentenceReader(String readFile) throws IOException {
        this.currentFile = readFile;
        sentences = new ArrayList<Sentence>();
        findSentencesInFile();
    }

    //Methods

    public String getFileName(){
        return this.currentFile;
    }

    public ArrayList<Sentence> getSentences(){
        return this.sentences;
    }

    public void setFile(String fileName) throws IOException {
        this.currentFile = fileName;
        findSentencesInFile();
    }

    // No direct setter for sentences because the sentences are based on the file itself

    private void findSentencesInFile () throws IOException {
        this.sentences.clear();
        String currentString = "";
        boolean readingSentence = false;
        boolean readingParenthesis = false; // A parenthesis never starts or ends a sentence, but often contain short fragments that may confuse the program to think it is an entirely new sentence
        FileInputStream readFile = new FileInputStream(this.currentFile);
        int c;
        while ((c = readFile.read()) != -1){
            char currentChar = (char)c;
            if(currentChar == '\n' || currentChar == '\r'){
                continue;
            }
            if (!readingParenthesis && currentChar == '('){
                readingParenthesis = true;
            }
            if (readingParenthesis && currentChar == ')'){
                readingParenthesis = false;
            }
            if (!readingParenthesis){
                if (Character.isUpperCase(c)){
                    readingSentence = true;
                }
                if (currentChar == '.'){
                    readingSentence = false;
                    currentString += currentChar;
                    this.sentences.add(new Sentence(currentString));
                    currentString = "";
                }
            }
            if (readingSentence){
                currentString += currentChar;
            }
        }
    }

    //Returns the sentence object instead of just a position in case the caller wants to do something with the sentence itself
    public HashMap<Sentence, Integer> searchForWord(String word){
        HashMap<Sentence, Integer> wordFoundLocations = new HashMap<>();
        for(Sentence sentence : this.sentences){
            ArrayList<Integer> incidencePositions = sentence.searchForWord(word);
            for(Integer incidencePos : incidencePositions){
                wordFoundLocations.put(sentence, incidencePos);
            }
        }
        return wordFoundLocations;
    }
}
