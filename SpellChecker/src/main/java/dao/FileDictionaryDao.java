/**
 *
 * @author sallasal
 */

package dao;

import java.io.*;

/**
 * This class contains the details of the resource file access
 * @author sallasal
 */

public class FileDictionaryDao implements DictionaryDao {
    
    private String[] dictionary;
    
    /**
     * Initializes the data access object and class variables
     */
    public FileDictionaryDao() {
        dictionary = new String[58111];
    }

    /**
     * Reads a resource file and initializes a dictionary array
     * @return String array that contains the most common English words
     * @throws Exception
     */
    @Override
    public String[] initializeDictionary() throws Exception {
        
        InputStream inputStream = null;

        try {
            
            ClassLoader classLoader = this.getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream("words58K.txt");
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
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dictionary;
    }

}
