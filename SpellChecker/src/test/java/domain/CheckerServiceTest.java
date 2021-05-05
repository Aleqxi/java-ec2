package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test CheckerService functions
 *
 * @author sallasal
 */
public class CheckerServiceTest {

    CheckerService checkerService;

    @Before
    public void setUp() {
        this.checkerService = new CheckerService();
    }

    @Test
    public void wordIsFoundFromDictionary() {
        assertTrue(checkerService.checkWordFromDictionary("dictionary"));
    }

    @Test
    public void wordIsNotFoundFromDictionary() {
        assertFalse(checkerService.checkWordFromDictionary("dictonay"));
    }
    
    @Test
    public void osaDistanceCallWorks() {
        double distance = checkerService.getOptimalStringAlignmentDistance("unicorn", "uincon");
        assertEquals(1.362, distance, 0.001);
    }
    
    @Test
    public void getSuggestionsOffersLessThan10Correctly() {
        String[] suggestions = checkerService.getSuggestions("marvelous");
        assertEquals("marvellous", suggestions[0]);
        assertEquals("-", suggestions[2]);
    }
    
    @Test
    public void getSuggestionsOffersBest10Correctly() {
        String[] suggestions = checkerService.getSuggestions("lat");
        assertThat(suggestions[0], not("-"));
        assertThat(suggestions[3], not("-"));
        assertThat(suggestions[9], not("-"));
    }
    
    @Test
    public void getWordsReturnsCorrectAmountOfWords() {
        String input = "This is the-test.input?that should return ten words.";
        String[] words = checkerService.getWords(input);
        assertEquals(10, words.length);
    }
    
    @Test
    public void wordQualityCheckAcceptsGoodWord() {
        assertTrue(checkerService.wordQualityIsGood("Accep-table"));
    }
    
    @Test
    public void wordQualityCheckReturnsFalsesCorrectly() {
        assertFalse(checkerService.wordQualityIsGood("54.6"));
        assertFalse(checkerService.wordQualityIsGood(""));
        assertFalse(checkerService.wordQualityIsGood("k"));
    }
    
    @Test
    public void duplicateCheckReturnsTrueCorrectly() {
        String[] suggestions = checkerService.getSuggestions("sentece");
        assertTrue(checkerService.checkIfWordIsDuplicate("sentece"));
    }
    
    @Test
    public void duplicateCheckReturnsFalseCorrectly() {
        assertFalse(checkerService.checkIfWordIsDuplicate("new-word"));
    }
    
    @Test
    public void clearCheckedWordsWorks() {
        for (Integer i = 0; i < 30; i++) {
            checkerService.getSuggestions(i.toString());
        }
        ArrayDeqImplementation arrayDeq = checkerService.getCheckedWords();
        assertTrue(arrayDeq.size() > 20);
        checkerService.clearCheckedWords();
        arrayDeq = checkerService.getCheckedWords();
        assertEquals(0, arrayDeq.size());
    }
    
    @Test
    public void veryRareWordSuggestionsWork() {
        String[] suggestions = checkerService.getSuggestions("veryrareword");
        boolean suggestionFound = false;
        for (String word : suggestions) {
            if (!word.equals("-")) {
                suggestionFound = true;
            }
        }
        assertTrue(suggestionFound);
    }
}