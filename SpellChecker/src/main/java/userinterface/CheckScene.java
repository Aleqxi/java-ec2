package userinterface;

import domain.*;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This creates the scene where user can check the spelling of the text input.
 * Still on dev, not used in main program yet!
 *
 * @author sallasal
 */
public class CheckScene {

    public Scene getCheckScene(Stage window, CheckerService checkerService) {
        ScrollPane scrollable = new ScrollPane();
        BorderPane checkerLayout = new BorderPane();

        VBox elements = new VBox();
        VBox falseWords = new VBox();
        elements.setPadding(new Insets(10, 10, 10, 10));
        falseWords.setPadding(new Insets(10, 10, 10, 10));

        elements.setSpacing(20);

        TextArea inputText = new TextArea();
        inputText.setWrapText(true);

        Button checkButton = new Button("Check spelling!");

        elements.getChildren().add(new Label("Add the text for spell checking!"));
        elements.getChildren().add(inputText);
        elements.getChildren().add(checkButton);

        checkButton.setOnAction((event) -> {
            String[] words = checkerService.getWords(inputText.getText());

            String[] suggestions = new String[10];
            cleanArray(suggestions);

            boolean found = false;
            for (int i = 0; i < words.length; i++) {
                if (!checkerService.checkWordFromDictionary(words[i]) && !words[i].isEmpty()) {
                    //found = checkSpellingForWord(words[i]);
                }
            }

            if (found == false) {
                falseWords.getChildren().add(new Label("All good!"));
            }
        });

        elements.getChildren().remove(falseWords);
        elements.getChildren().add(falseWords);

        checkerLayout.setCenter(elements);
        scrollable.setContent(checkerLayout);

        return new Scene(scrollable);

    }

    private String[] cleanArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "-";
        }

        return array;
    }

}
