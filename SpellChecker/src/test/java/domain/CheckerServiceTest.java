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
    public void levenshteinDistanceCallWorksWithEqualLengthStrings() {
        int distance = checkerService.getLevenshteinDistance("cat", "cat");
        assertEquals(0, distance);
    }
    
    @Test
    public void levenshteinDistanceCallWorksWithDifferentLengthStrings() {
        int distance = checkerService.getLevenshteinDistance("ros", "horse");
        assertEquals(3, distance);
    }
}
