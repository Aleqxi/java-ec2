package userinterface;

import domain.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This class creates the scene where user can check the spelling of the text input.
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
            falseWords.getChildren().clear();

            String[] words = checkerService.getWords(inputText.getText());

            String[] suggestions = new String[10];
            cleanArray(suggestions);

            boolean found = false;
            for (int i = 0; i < words.length; i++) {
                if (!checkerService.checkWordFromDictionary(words[i]) 
                        && !words[i].isEmpty() 
                        && !checkerService.wordIsNumeric(words[i])) {
                    suggestions = checkerService.getSuggestions(words[i]);

                    GridPane suggestionsPane = new GridPane();
                    suggestionsPane.setHgap(20);
                    suggestionsPane.setPadding(new Insets(10, 10, 10, 10));
                    ColumnConstraints columnWidth = new ColumnConstraints();
                    columnWidth.setMinWidth(60);
                    suggestionsPane.getColumnConstraints().add(columnWidth);

                    suggestionsPane.add(new Label(words[i]), 0, 0);

                    for (int j = 0; j < 10; j++) {
                        if (!suggestions[j].equals("-")) {
                            suggestionsPane.add(new Label(suggestions[j]), 1, j);
                        }
                    }

                    try {
                        falseWords.getChildren().add(suggestionsPane);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    found = true;
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
