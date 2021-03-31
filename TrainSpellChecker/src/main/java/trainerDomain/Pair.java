package trainerDomain;

/**
 *
 * @author sallasal
 */
public class Pair {

    private String falseWord;
    private String correctWord;

    public Pair(String falseWord, String correctWord) {
        this.falseWord = falseWord;
        this.correctWord = correctWord;
    }

    public String getFalseWord() {
        return falseWord;
    }

    public void setFalseWord(String falseWord) {
        this.falseWord = falseWord;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }

}
