package userInterface;

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
                calculateDistance("Levenshtein");
            } else if (command.equals("o")) {
                calculateDistance("optimalStringAlignment");
            } else if (command.equals("w")) {
                checkInput();
            } else if (command.equals("q")) {
                break;
            } else {
                System.out.println("Unspecified command, try again.");
            }
        }

        quit();

    }

    /**
     * Test method that calculates and prints the distance between two inserted
     * words
     *
     * @param algorithm The algorithm that is used for calculation, Levenshtein
     * or OSA
     */
    private void calculateDistance(String algorithm) {
        System.out.println("Insert first word:");
        String word1 = reader.nextLine();
        System.out.println("Insert second word:");
        String word2 = reader.nextLine();
        int distance = -9999;

        if (algorithm.equals("Levenshtein")) {
            distance = checkerService.getLevenshteinDistance(word1, word2);
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
     * Checks if the input string is found from dictionary
     *
     */
    private void checkInput() {
        System.out.println("Insert the word that is checked from dictionary:");
        String input = reader.nextLine();

        if (trimInput(input)) {
            if (checkerService.checkWordFromDictionary(input)) {
                System.out.println("The word is found from dictionary.");
            } else {
                System.out.println("The word is not found from dictionary.");
            }
        }
    }

    /**
     * Checks the spelling for inserted word and calls the checker service to
     * print best options
     */
    private void checkSpelling() {
        System.out.println("Insert the word for checking:");
        String input = reader.nextLine();
        System.out.println("");

        if (trimInput(input)) {
            checkerService.checkSpelling(input);
        }
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
     * Checks that input meets requirements
     */
    private boolean trimInput(String input) {
        if (input.length() > 15 || input.contains(" ")) {
            System.out.println("The input is longer than 15 characters "
                    + "or contains whitespace. These are not allowed.");
            return false;
        }

        return true;
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

}
