/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainerGUI;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import trainerDomain.*;

/**
 *
 * @author sallasal
 */
public class InsertScene {

    private Scene insert;
    private String[] words1;
    private TextField[] textFields;

    public void setInsertScene(Scene scene) {
        this.insert = scene;
        this.words1 = new String[0];
        this.textFields = new TextField[0];

    }

    public Scene getInsertScene(Stage window, TrainerService trainer) {
        ScrollPane scrollable = new ScrollPane();
        BorderPane insertLayout = new BorderPane();

        VBox elements = new VBox();
        VBox answers = new VBox();
        elements.setPadding(new Insets(10, 10, 10, 10));
        answers.setPadding(new Insets(10, 10, 10, 10));

        elements.setSpacing(20);

        TextArea inputText = new TextArea();
        inputText.setWrapText(true);

        Button readButton = new Button("Read!");

        elements.getChildren().add(new Label("Add the text for teaching. You can add a text even if you didn't teach previous results."));
        elements.getChildren().add(inputText);
        elements.getChildren().add(readButton);

        readButton.setOnAction((event) -> {
            clearTextFields();
            clearWords1();
            answers.getChildren().clear();

            answers.getChildren().add(new Label("To skip the word, leave default value."));

            ArrayList<String> falseWords = trainer.checkInput(inputText.getText());

            this.textFields = new TextField[falseWords.size()];
            this.words1 = new String[falseWords.size()];

            for (int i = 0; i < falseWords.size(); i++) {
                TextField textField = new TextField("-");
                String word = falseWords.get(i);

                this.textFields[i] = textField;
                this.words1[i] = word;

                HBox row = new HBox();
                row.setSpacing(20);
                row.getChildren().add(new Label(word));
                row.getChildren().add(textField);
                try {
                    answers.getChildren().add(row);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            Button teachButton = new Button("Teach!");
            answers.getChildren().add(new Label("Program writes to result file when teaching."));
            answers.getChildren().add(new Label("After that, you can insert a new text snippet."));
            answers.getChildren().add(teachButton);

            teachButton.setOnAction((teachEvent) -> {
                for (int i = 0; i < this.words1.length; i++) {
                    String word2 = this.textFields[i].getText().toLowerCase();
                    if (!word2.equals("-")) {
                        trainer.writeResultToFile(this.words1[i] + "," + word2);
                    }

                }
                clearTextFields();
                clearWords1();
                inputText.setText("");
                answers.getChildren().clear();
            });

            elements.getChildren().remove(answers);
            elements.getChildren().add(answers);
        });

        insertLayout.setCenter(elements);
        scrollable.setContent(insertLayout);

        return new Scene(scrollable);
    }

    public void clearWords1() {
        this.words1 = new String[0];
    }

    private void clearTextFields() {
        this.textFields = new TextField[0];
    }
}
