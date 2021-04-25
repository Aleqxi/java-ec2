package domain;

import dao.*;
import java.util.regex.Pattern;

/**
 * All the program functions are called through this class.
 *
 * @author sallasal
 */
public class CheckerService {

    private DictionaryDao initDictionary;
    private String[] dictionary;
    private OptimalStringAlignment optimalStringAlignment;

    /**
     * Creates CheckerService instance and initializes the dictionary based on
     * the resource file
     */
    public CheckerService() {
        initDictionary = new FileDictionaryDao();
        this.dictionary = null;
        this.optimalStringAlignment = new OptimalStringAlignment();

        try {
            this.dictionary = initDictionary.initializeDictionary();
        } catch (Exception ex) {
            System.out.println("Initializing the dictionary did not succeed. Program is halted.");
        }
    }

    /**
     * Checks if the input word is found from dictionary
     *
     * @param input the user input
     * @return true, if the input matches to word in dictionary, false otherwise
     */
    public boolean checkWordFromDictionary(String input) {
        for (String word : this.dictionary) {
            if (input.equals(word)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Calculates optimal string alignment distance
     *
     * @param word1 First word for OSA distance
     * @param word2 Second word for OSA distance
     * @return optimal string alignment distance as integer
     */
    public double getOptimalStringAlignmentDistance(String word1, String word2) {
        return this.optimalStringAlignment.weightedOSA(word1, word2);
    }

    /**
     * Creates 10 best suggestions based on optimal string alignment distance
     *
     * @param wordFor the false word the distance is compared to
     * @return 10 best suggestions as String array
     */
    public String[] getSuggestions(String wordFor) {
        ArrayDeqImplementation distance1 = new ArrayDeqImplementation();
        ArrayDeqImplementation distance2 = new ArrayDeqImplementation();

        String[] suggestions = new String[10];
        for (int i = 0; i < 10; i++) {
            suggestions[i] = "-";
        }

        for (String word : dictionary) {

            double distance = 10;

            if (!(word == null)) {
                distance = this.getOptimalStringAlignmentDistance(wordFor, word);
            }

            if (distance <= 1) {
                distance1.addLast(word);
            } else if (distance > 1 && distance <= 2) {
                distance2.addLast(word);
            }
        }

        int i = 0;

        while (i < 10 && distance1.size() > 0) {
            suggestions[i] = distance1.remove();
            i++;
        }

        while (i < 10 && distance2.size() > 0) {
            suggestions[i] = distance2.remove();
        }

        return suggestions;
    }

    /**
     * Splits input to word array, sanitizes the input.
     *
     * @param input Input string for splitting
     * @return String array that contains single words
     */
    public String[] getWords(String input) {

        input = input.toLowerCase().replaceAll("\\?|\\t|\\n|\"|\'|\\@|\\%|[.,!:;-]", " ");

        String[] words = input.split(" ");

        return words;
    }

    /**
     * Checks the word quality for user interface.
     * Skips the empty words, one-character words and numeric words.
     *
     * @param input the user input
     * @return true, if the input meets the requirements, false otherwise.
     */
    public boolean wordQualityIsGood(String input) {
        return !(input.isEmpty()) && input.length() > 1 && !wordIsNumeric(input);
    }

    /**
     * Checks if the input is numeric.
     *
     * @param input the user input
     * @return true, if the input is numeric value, false otherwise
     */
    private boolean wordIsNumeric(String input) {
        Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return numericPattern.matcher(input).matches();
    }

    /**
     * Prints the duration of the checking round to the console (as nanoseconds).
     * Used for testing purposes.
     *
     * @param startTime the execution start time as nanoseconds (system time)
     */
    public void printDuration(long startTime) {
        long duration = System.nanoTime() - startTime;
        System.out.println("Checking spelling took " + duration + "ns");
    }

}
