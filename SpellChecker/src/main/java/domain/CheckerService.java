package domain;

import dao.*;
import java.util.ArrayDeque;

/**
 * All the program functions are called through this class.
 *
 * @author sallasal
 */
public class CheckerService {

    private DictionaryDao initialize;
    private String[] dictionary;
    private Levenshtein levenshtein;
    private OptimalStringAlignment optimalStringAlignment;

    /**
     * Creates CheckerService instance and initializes the dictionary based on
     * the resource file
     */
    public CheckerService() {
        initialize = new FileDictionaryDao();
        this.dictionary = null;
        this.levenshtein = new Levenshtein();
        this.optimalStringAlignment = new OptimalStringAlignment();

        try {
            this.dictionary = initialize.initializeDictionary();
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
     * Calculates Levenshtein edit distance (basic one)
     *
     * @param word1 First word for Levenshtein edit distance
     * @param word2 Second word for Levenshtein edit distance
     * @return Levenshtein edit distance as integer
     */
    public int getLevenshteinDistance(String word1, String word2) {
        return this.levenshtein.levenshteinDistance(word1, word2);
    }

    /**
     * Calculates optimal string alignment distance
     *
     * @param word1 First word for OSA distance
     * @param word2 Second word for OSA distance
     * @return optimal string alignment distance as integer
     */
    public int getOptimalStringAlignmentDistance(String word1, String word2) {
        return this.optimalStringAlignment.optimalStringAlignment(word1, word2);
    }

    /**
     * Creates 10 best suggestions based on optimal string alignment distance
     *
     * @param wordFor the false word the distance is compared to
     * @return 10 best suggestions as String array
     */
    public String[] getSuggestions(String wordFor) {
        ArrayDeque<String> distance1 = new ArrayDeque<>();
        ArrayDeque<String> distance2 = new ArrayDeque<>();
        ArrayDeque<String> distance3 = new ArrayDeque<>();

        String[] suggestions = new String[10];
        for (int i = 0; i < 10; i++) {
            suggestions[i] = "-";
        }

        for (String word : dictionary) {
            int distance = this.getOptimalStringAlignmentDistance(wordFor, word);

            switch (distance) {
                case 1:
                    distance1.addLast(word);
                    break;
                case 2:
                    distance2.addLast(word);
                    break;
                case 3:
                    distance3.addLast(word);
                    break;
                default:
                    break;
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

        while (i < 10 && distance3.size() > 0) {
            suggestions[i] = distance3.remove();
        }

        return suggestions;
    }

}
