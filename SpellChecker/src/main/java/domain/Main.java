package domain;

import userinterface.*;

/**
 * Main class that just starts the user interface
 *
 * @author sallasal
 */
public class Main {

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.runUI();
        
//        This will be used when GUI is ready and dev classes are refactored. Hopefully this week (5).
//        SpellCheckerGUI.main(args);
    }

}
