package domain;

/**
 * This class implements optimal string alignment distance algorithm
 *
 * @author sallasal
 */
public class OptimalStringAlignment {

    /**
     * Calculate optimal string alignment distance between two words
     * @param word1 the first word used for OSA calculation
     * @param word2 the second word used for OSA calculation
     * @return optimal string alignment distance as int
     */
    public int optimalStringAlignment(String word1, String word2) {
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
                
                if ((row > 1) && (column > 1) 
                        && (word2.charAt(row - 1) == word1.charAt(column - 2) 
                        && (word1.charAt(column - 1) == word2.charAt(row - 2)))) {
                    if (substringTable[row][column] >= substringTable[row - 2][column - 2] + 1) {
                        substringTable[row][column] = substringTable[row - 2][column - 2] + 1;
                    }
                }

            }
        }

        return substringTable[word2.length()][word1.length()];
    }
}
