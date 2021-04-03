/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainerDomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sallasal
 */
public class TrainerService {

    private String[] dictionary;
    private PrintStream resultWriter;

    public TrainerService() {
        this.dictionary = new String[15000];
        
        try {
            this.resultWriter = new PrintStream(new FileOutputStream("results.csv", true));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrainerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream inputStream;

        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream("words15K.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String row;
            int i = 0;
            while ((row = reader.readLine()) != null) {
                if (row.trim().length() == 0) {
                    continue;
                }

                dictionary[i] = row;
                i++;
            }

            reader.close();
            inputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            File resultFile = new File("results.csv");
            if (resultFile.createNewFile()) {
                System.out.println("File created to the project root folder.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList checkInput(String input) {
        ArrayList falseWords = new ArrayList<String>();

        input = input.replace("\n", " ").replace("\t", " ");

        String[] words = input.split(" ", 0);

        for (String word : words) {
            word = word.toLowerCase().replace(".", "").replace(",", "")
                    .replace("!", "").replace("?", "").replace(":", "");

            if (!word.equals("") && !checkWordFromDictionary(word)) {
                falseWords.add(word);
            }
        }

        return falseWords;
    }

    public boolean checkWordFromDictionary(String input) {
        for (String word : this.dictionary) {
            if (input.equals(word)) {
                return true;
            }
        }

        return false;
    }

    public void writeResultToFile(String result) {
        try {
            resultWriter.print(result);
            resultWriter.print(System.lineSeparator());
            System.out.println("Results are written to the file.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
