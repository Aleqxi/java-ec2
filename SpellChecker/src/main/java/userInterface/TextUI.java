/**
 *
 * @author sallasal
 */

package userInterface;

import java.util.*;
import domain.*;

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
        readInput();
    }

    private void readInput() {
        String input = reader.nextLine();

        while (!input.equals("quit")) {
            checkInput(input);
            
            System.out.println("");
            System.out.println("**********");
            System.out.println("To stop, insert 'quit'. To continue, insert new word.");
            input = reader.nextLine();
        }
        
        quit();
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
        System.out.println("To start, insert a word that needs to be checked:");
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
