
import java.util.ArrayList;

public class Sentence {
    //Fields

    private String sentence;
    private String[] words;

    //Constructor

    public Sentence (String sentence){
        this.sentence = sentence;
        updateSentenceWords();
    }

    //Methods

    public String getSentence(){
        return this.sentence;
    }

    public String[] getWords(){
        return this.words;
    }

    public void setSentence(String sentence){
        this.sentence = sentence;
        updateSentenceWords();
    }

    // No direct setter for words because words is based on the sentence itself

    public ArrayList<Integer> searchForWord(String lookFor){
        ArrayList<Integer> incidencePositions = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String currentWord = this.words[i];
            if(currentWord.contains(lookFor)){
                incidencePositions.add(i);
            }
        }
        return incidencePositions;
    }

    private void updateSentenceWords(){
        this.words = this.sentence.split(" ");
    }

    @Override
    public String toString(){
        return this.sentence;
    }
}
