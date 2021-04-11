package domain;

/**
 * This is my own implementation for ArrayDeque data structure.
 * Growing and shrinking are not yet implemented as they are most likely not
 * needed. At the moment, the program uses structures with max size 10, and
 * this is efficient enough.
 *
 * @author sallasal
 */
public class ArrayDeqImplementation {

    private String[] array;
    private int firstUsed;
    private int lastUsed;
    private int savedWords;

    /**
     * Create new ArrayDeqImplementation instance.
     */
    public ArrayDeqImplementation() {
        this.array = new String[10];
        this.firstUsed = 0;
        this.lastUsed = 9;
        this.savedWords = 0;
    }

    /**
     * Remove first string of the queue and return it.
     * 
     * @return removed string and null if no string exists.
     */
    public String remove() {
        String removed = null;

        if (array[firstUsed] != null) {
            removed = array[firstUsed];
            if (firstUsed == array.length - 1) {
                firstUsed = 0;
            } else {
                firstUsed++;
            }
        }

        savedWords--;

        return removed;
    }

    /**
     * Add new word at the end of the queue.
     * 
     * @param word the new word to be added.
     */
    public void addLast(String word) {
        if (lastUsed == array.length - 1) {
            array[0] = word;
            lastUsed = 0;
        } else {
            array[lastUsed + 1] = word;
            lastUsed++;
        }

        savedWords++;

        if (savedWords == array.length) {
            grow();
        }

    }

    /**
     * Get the size of the queue.
     * 
     * @return amount of saved words as int
     */
    public int size() {
        return this.savedWords;
    }

    /**
     * Method for growing the array. 
     * This will be done if the array is full.
     */
    private void grow() {
        String[] newArray = new String[array.length * 2];
        int newIndex = 0;
        
        for (int i = firstUsed; i < array.length; i++) {
            newArray[newIndex] = array[i];
            newIndex++;
        }
        
        for (int i = 0; i <= lastUsed; i++) {
            newArray[newIndex] = array[i];
            newIndex++;
        }
        
        firstUsed = 0;
        lastUsed = array.length - 1;
        array = newArray;
    }

}
