package userinterface;

import java.util.*;
import domain.*;

/**
 * Text user interface is implemented in this class
 *
 * @author sallasal
 */
public class TextUI {

    private Scanner reader;
    private CheckerService checkerService;

    /**
     * Initializes all needed resources for user interface
     */
    public TextUI() {
        this.reader = new Scanner(System.in);
        this.checkerService = new CheckerService();
    }

    /**
     * Runs the user interface and calls methods based on user inputs
     */
    public void runUI() {
        welcome();
        askCommand();
    }

    /**
     * Asks the command for user, used for choosing the next function
     */
    private void askCommand() {
        System.out.println("Commands");
        System.out.println("c : check spelling!");
        System.out.println("l : get Levenshtein edit distance of two words");
        System.out.println("o : get optimal string alignment distance of two words");
        System.out.println("w : check if the word is in resource dicionary");
        System.out.println("q : quit");
        System.out.println("");

        while (true) {
            System.out.println("");
            System.out.println("Choose command:");
            String command = reader.nextLine();

            if (command.equals("c")) {
                checkSpelling();
            } else if (command.equals("l")) {
                devCalculateDistance("Levenshtein");
            } else if (command.equals("o")) {
                devCalculateDistance("optimalStringAlignment");
            } else if (command.equals("w")) {
                devCheckInput();
            } else if (command.equals("q")) {
                break;
            } else {
                System.out.println("Unspecified command, try again.");
            }
        }

        quit();

    }

    /**
     * UI method for asking input, preparing it and looping actual check
     */
    private void checkSpelling() {
        System.out.println("Insert the text for checking in one line:");
        String input = reader.nextLine();
        System.out.println("");

        String[] words = checkerService.getWords(input);

        boolean found = false;
        for (int i = 0; i < words.length; i++) {
            if (!checkerService.checkWordFromDictionary(words[i]) && !words[i].isEmpty()) {
                found = checkSpellingForWord(words[i]);
            }
        }
        
        if (found == false) {
            System.out.println("All good!");
        }
        
    }

    /**
     * Checks the spelling and prints 10 best suggestions
     *
     * @param word the word that needs to be checked
     */
    public boolean checkSpellingForWord(String word) {

        System.out.println("Check this word! Word: " + word);
        String[] suggestions = checkerService.getSuggestions(word);
        boolean found = false;
        System.out.println("\tSuggestions (best first): ");
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            if (!suggestions[i].equals("-")) {
                System.out.println("\t" + suggestions[i]);
                found = true;
            }

        }

        if (!found) {
            System.out.println("\tNo suggestions were found.");
        }
        return found;

    }

    /**
     * Exits from UI command loop and halts the execution
     */
    private void quit() {
        System.out.println("");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("The Spell Checker is now closed.");
        System.out.println("Thank you and welcome back!");
        System.out.println("**********");
        System.out.println("**********");
    }

    /**
     * First lines of user interface
     */
    private void welcome() {
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("Welcome to Spell Checker!");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("");
    }

    /**
     * Test method that calculates and prints the distance between two inserted
     * words.
     * Dev method, removed from final version.
     *
     * @param algorithm The algorithm that is used for calculation, Levenshtein
     * or OSA
     */
    private void devCalculateDistance(String algorithm) {
        System.out.println("Insert first word:");
        String word1 = reader.nextLine();
        System.out.println("Insert second word:");
        String word2 = reader.nextLine();
        double distance = -9999;

        if (algorithm.equals("Levenshtein")) {
            distance = checkerService.devGetLevenshteinDistance(word1, word2);
            System.out.println("");
            System.out.println("Levenshtein edit distance between words is " + distance);
            System.out.println("");
        } else if (algorithm.equals("optimalStringAlignment")) {
            distance = checkerService.getOptimalStringAlignmentDistance(word1, word2);
            System.out.println("");
            System.out.println("Optimal string alignment distance between words is " + distance);
            System.out.println("");
        }
    }

    /**
     * Checks if the input string is found from dictionary.
     * Dev method, removed from final version.
     *
     */
    private void devCheckInput() {
        System.out.println("Insert the word that is checked from dictionary:");
        String input = reader.nextLine();

        if (devTrim(input)) {
            if (checkerService.checkWordFromDictionary(input)) {
                System.out.println("The word is found from dictionary.");
            } else {
                System.out.println("The word is not found from dictionary.");
            }
        }
    }

    /**
     * Checks that input meets requirements. Dev method, removed from final
     * version. 
     */
    private boolean devTrim(String input) {
        if (input.length() > 15 || input.contains(" ")) {
            System.out.println("The input is longer than 15 characters "
                    + "or contains whitespace. These are not allowed.");
            return false;
        }

        return true;
    }

}
