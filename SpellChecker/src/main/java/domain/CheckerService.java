/**
 *
 * @author sallasal
 */
package domain;

import dao.*;

public class CheckerService {

    private DictionaryDao initialize;
    private String[] dictionary;

    /**
     * Creates CheckerService instance and initializes the dictionary based on the resource file
     */
    public CheckerService() {
        initialize = new FileDictionaryDao();
        this.dictionary = null;

        try {
            this.dictionary = initialize.initializeDictionary();
        } catch (Exception ex) {
            System.out.println("Initializing the dictionary did not succeed. Program is halted.");
        }
    }

    /**
     * Checks if the input word is found from dictionary
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

}
