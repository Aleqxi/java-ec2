package domain;

import dao.*;

/**
 * All the program functions are called through this class.
 *
 * @author sallasal
 */
public class CheckerService {

    private DictionaryDao initialize;
    private String[] dictionary;
    private Levenshtein levenshtein;

    /**
     * Creates CheckerService instance and initializes the dictionary based on
     * the resource file
     */
    public CheckerService() {
        initialize = new FileDictionaryDao();
        this.dictionary = null;
        this.levenshtein = new Levenshtein();

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

}
