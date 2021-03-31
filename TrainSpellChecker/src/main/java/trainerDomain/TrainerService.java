/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainerDomain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javafx.scene.control.*;


/**
 *
 * @author sallasal
 */
public class TrainerService {

    private String[] dictionary;
    private ArrayList<Pair> pairs;

    public TrainerService() {
        this.dictionary = new String[15000];
        this.pairs = new ArrayList<Pair>();
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
    }

    public ArrayList checkInput(String input) {
        ArrayList falseWords = new ArrayList<String>();

        String[] words = input.split(" ", 0);

        for (String word : words) {
            word = word.toLowerCase().replace(".", "").replace(",", "")
                    .replace("!","").replace("?","");
            
            if (!checkWordFromDictionary(word)) {
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
    
    public void clearPairs() {
        this.pairs.clear();
    }
    
    public void addPair(String falseWord, String correctWord) {
        this.pairs.add(new Pair(falseWord, correctWord));
    }
    
    

}
