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

    private void askCommand() {
        System.out.println("Commands");
        System.out.println("l : get levenshtein edit distance of two words");
        System.out.println("w : check if the word is in resource dicionary");
        System.out.println("q : quit");
        System.out.println("");

        while (true) {
            System.out.println("");
            System.out.println("Choose command:");
            String command = reader.nextLine();

            if (command.equals("l")) {
                compareWords();
            } else if (command.equals("w")) {
                readInput();
            } else if (command.equals("q")) {
                break;
            } else {
                System.out.println("Unspecified command, try again.");
            }
        }

        quit();

    }

    private void compareWords() {
        System.out.println("Insert first word:");
        String word1 = reader.nextLine();
        System.out.println("Insert second word:");
        String word2 = reader.nextLine();

        System.out.println("");
        System.out.println("Levenshtein edit distance between word is "
                + checkerService.getLevenshteinDistance(word1, word2));
        System.out.println("");
    }

    private void readInput() {
        System.out.println("Insert the word that is checked from dictionary:");
        String input = reader.nextLine();
        checkInput(input);
    }

    private void checkInput(String input) {
        if (input.length() > 15 || input.contains(" ")) {
            System.out.println("The input is longer than 15 characters "
                    + "or contains whitespace. These are not allowed.");
        } else {
            if (checkerService.checkWordFromDictionary(input)) {
                System.out.println("The word is found from dictionary.");
            } else {
                System.out.println("The word is not found from dictionary.");
            }
        }
    }

    private void welcome() {
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("Welcome to Spell Checker!");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("");
    }

    private void quit() {
        System.out.println("");
        System.out.println("**********");
        System.out.println("**********");
        System.out.println("The Spell Checker is now closed.");
        System.out.println("Thank you and welcome back!");
        System.out.println("**********");
        System.out.println("**********");
    }

}
