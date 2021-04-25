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
//        assertEquals("at", suggestions[0]);
//        assertEquals("eat", suggestions[3]);
//        assertEquals("lag", suggestions[9]);
    }
    
    @Test
    public void getWordsReturnsCorrectAmountOfWords() {
        String input = "This is the-test.input?that should return ten words.";
        String[] words = checkerService.getWords(input);
        assertEquals(10, words.length);
    }
}