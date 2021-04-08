package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test CheckerService functions
 *
 * @author sallasal
 */
public class CheckerServiceTest {

    CheckerService checkerService;

    public CheckerServiceTest() {
    }

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
    public void levenshteinDistanceCallWorks() {
        int distance = checkerService.devGetLevenshteinDistance("unicorn", "uincon");
        assertEquals(3, distance);
    }
    
    @Test
    public void osaDistanceCallWorks() {
        int distance = checkerService.getOptimalStringAlignmentDistance("unicorn", "uincon");
        assertEquals(2, distance);
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
        assertEquals("at", suggestions[0]);
        assertEquals("eat", suggestions[3]);
        assertEquals("lag", suggestions[9]);
    }
    
    @Test
    public void getWordsReturnsCorrectAmountOfWords() {
        String input = "This is the-test.input?that should return ten words.";
        String[] words = checkerService.getWords(input);
        assertEquals(10, words.length);
    }
}