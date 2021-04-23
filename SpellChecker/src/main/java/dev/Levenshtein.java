
package dev;

import java.lang.Math.*;

/**
 * This class implements default Levenshtein algorithm
 * 
 * @author sallasal
 */
public class Levenshtein {
    
    /**
     * Calculate original, restricted Levenshtein distance for two words
     * 
     * @param word1 The first string to calculate the Levenshtein distance
     * @param word2 The second string to calculate the Levenshtein distance
     * @return Levenshtein distance (basic edit distance) as an integer
     */
    public int levenshteinDistance(String word1, String word2) {
        int[][] substringTable = new int[word2.length() + 1][word1.length() + 1];
        
        for (int column = 0; column <= word1.length(); column++) {
            substringTable[0][column] = column;
        }
        
        for (int row = 0; row <= word2.length(); row++) {
            substringTable[row][0] = row;
        }
        
        for (int row = 1; row <= word2.length(); row++) {
            for (int column = 1; column <= word1.length(); column++) {
                
                int substitutionCost = 1;
                
                if (word1.charAt(column - 1) == word2.charAt(row - 1)) {
                    substitutionCost = 0;
                }
                
                int deletionDistance = substringTable[row][column - 1] + 1;
                int additionDistance = substringTable[row - 1][column] + 1;
                int substitutionDistance = substringTable[row - 1][column - 1] + substitutionCost;
                
                int smallestOperationDistance;
                
                if (deletionDistance <= additionDistance && deletionDistance <= substitutionDistance) {
                    smallestOperationDistance = deletionDistance;
                } else if (additionDistance <= deletionDistance && additionDistance <= substitutionDistance) {
                    smallestOperationDistance = additionDistance;
                } else {
                    smallestOperationDistance = substitutionDistance;
                }
                
                substringTable[row][column] = smallestOperationDistance;
                
            }
        }
        
        return substringTable[word2.length()][word1.length()];
    }
    
}
