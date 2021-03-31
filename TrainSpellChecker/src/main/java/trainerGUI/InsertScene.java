/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainerGUI;

import java.util.ArrayList;
import javafx.scene.Node;
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
        BorderPane insertLayout = new BorderPane();

        VBox elements = new VBox();
        VBox answers = new VBox();

        elements.setSpacing(20);

        TextArea inputText = new TextArea("Add the text here.");

        Button readButton = new Button("Read!");

        elements.getChildren().add(new Label("Add the text for teaching:"));
        elements.getChildren().add(inputText);
        elements.getChildren().add(readButton);

        readButton.setOnAction((event) -> {
            trainer.clearPairs();
            clearTextFields();
            clearWords1();
            answers.getChildren().clear();

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
            answers.getChildren().add(teachButton);
            
            teachButton.setOnAction((teachEvent) -> {
                for (int i = 0; i < this.words1.length; i++) {
                    String word2 = this.textFields[i].getText().toLowerCase();
                    trainer.addPair(this.words1[i], word2);
                    // This can be removed when continued
                    System.out.println(this.words1[i] + " -> " + word2);
                }
                // Add here print to file
            });

            elements.getChildren().remove(answers);
            elements.getChildren().add(answers);
        });

        insertLayout.setCenter(elements);

        return new Scene(insertLayout);
    }

    public void clearWords1() {
        this.words1 = new String[0];
    }

    private void clearTextFields() {
        this.textFields = new TextField[0];
    }

    private String[] getWords1() {
        return words1;
    }

    private void setWords1(String[] words1) {
        this.words1 = words1;
    }

    private TextField[] getTextFields() {
        return textFields;
    }

    private void setTextFields(TextField[] textFields) {
        this.textFields = textFields;
    }

}
