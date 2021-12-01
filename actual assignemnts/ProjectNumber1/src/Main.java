public class Main {

    // takes a source string, position(int) to search for and a char to search for
    // and checks for the char at the specified index in the original string
    // if it's equal to the target char (the needle) then it returns true
    // if the search index iss out of bounds or it doesn't equal the needle then it returns false
    static boolean stringContainsCharAt(String baseString, int searchIndex, char searchChar){
        boolean isContain = false;
        if (searchIndex <= baseString.length() - 1 && searchChar == baseString.charAt(searchIndex)) {
            isContain = true;
        }
        return isContain;
    }

    // checks if a char is in an array of chars with an offset
    static boolean charIsInSearchArray(char inputChar, char[] searchArray, int offset){
        boolean isContain = false;

        for(int i = offset; i < searchArray.length; i++){
            if ( inputChar == searchArray[i]){
                isContain = true;
                break;
            }
        }

        return isContain;
    }

    // find the first alphabetical sequence in a string and returns it
    static String findFirstCharSequence( String baseString, char[] searchForSequence){
        int sequenceStartPosition = -1;
        int sequenceRange = 0;

        iterateThroughString: for (int i = 0; i < baseString.length(); i++){
            for (int j = 0; j < searchForSequence.length; j++){
                char patternChar = searchForSequence[j];
                if (stringContainsCharAt( baseString, i, patternChar )){
                    sequenceStartPosition = (sequenceStartPosition != -1) ?sequenceStartPosition :i;
                    int repeatTimes = 0;
                    char nextCharInSequence = (j == searchForSequence.length -1) ?searchForSequence[j] :searchForSequence[j+1];
                    while (true) {
                        if (!stringContainsCharAt(baseString, i + repeatTimes, patternChar)){
                            sequenceRange += repeatTimes;
                            i += repeatTimes;
                            if( i < baseString.length() && !charIsInSearchArray(baseString.charAt(i), searchForSequence, j)){
                                break iterateThroughString;
                            }
                            break;
                        }
                        repeatTimes++;
                    }
                }
            }
        }
        return baseString.substring(sequenceStartPosition, sequenceStartPosition + sequenceRange);
    }

    // takes a given string
    // and returns the number of times
    // a vowel appears in the string
    static int problemOne(String s){
        char[] searchFor = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < searchFor.length; j++){
                if (stringContainsCharAt(s, i, searchFor[j])){
                    count++;
                }
            }
        }

        return count;
    }

    // takes a given string
    // returns an integer equal to how many times char sequence 'bob' shows up in the string
    static int problemTwo(String s){
        int count = 0;

        boolean completedSearch = false;

        while (completedSearch == false){
            for (int i = 0; i < s.length(); i++){
                if (stringContainsCharAt(s, i, 'b')){
                    String stringPart = s.substring(i);
                    if (stringContainsCharAt(stringPart, 1, 'o') && stringContainsCharAt(stringPart, 2, 'b')){
                        count++;
                        s = stringPart.substring(1);
                        break;
                    }
                }
                if (i == s.length()-1) {
                    completedSearch = true;
                }
            }
        }

        return count;
    }

    // takes a string
    // and returns the longest alphabetical substring in it
    static String problemThree(String s){
        char[] searchFor = {'a', 'b', 'c', 'd' , 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        String longestCharSequence = "";

        boolean completedSearch = false;

        while (!completedSearch){
            for (int i = 0; i < s.length(); i++){
                String currentStringSequence = findFirstCharSequence(s, searchFor);

                if (currentStringSequence.length() > longestCharSequence.length()){
                    longestCharSequence = currentStringSequence;
                }

                s = s.substring(currentStringSequence.length());

                if (s.length() == 0) {
                    completedSearch = true;
                    break;
                }
            }
        }

        return longestCharSequence;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
