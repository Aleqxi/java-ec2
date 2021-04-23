package dev;

import dev.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test CheckerService functions
 *
 * @author sallasal
 */
public class BU_CheckerServiceTest {

    BU_CheckerService checkerService;

    @Before
    public void setUp() {
        this.checkerService = new BU_CheckerService();
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