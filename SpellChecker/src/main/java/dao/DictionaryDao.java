
package dao;

/**
 * The dictionary file is accessed via this interface
 * @author sallasal
 */

public interface DictionaryDao {
    
    /**
     * Reads the resource file and builds a dictionary array
     * @return String array that contains the most common English words
     * @throws Exception
     */
    public String[] initializeDictionary() throws Exception;
    
}
