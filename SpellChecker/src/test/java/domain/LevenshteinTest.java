/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sallasal
 */
public class LevenshteinTest {
    
    private Levenshtein levenshtein;
    
    public LevenshteinTest() {
    }
    
    @Before
    public void setUp() {
        this.levenshtein = new Levenshtein();
    }

    @Test
    public void levenshteinRecognizesSmallDeletionDistance() {
        int distance = this.levenshtein.levenshteinDistance("moose", "mose");
        assertEquals(1, distance);
    }
    
    @Test
    public void levenshteinRecognizesSmallAdditionDistance() {
        int distance = this.levenshtein.levenshteinDistance("mose", "moose");
        assertEquals(1, distance);
    }
    
    @Test
    public void levenshteinRecognizesSmallSubstitutionDistance() {
        int distance = this.levenshtein.levenshteinDistance("moose", "goose");
        assertEquals(1, distance);
    }
    
    @Test
    public void levenshteinDoesNotRecognizeTransposition() {
        int distance = this.levenshtein.levenshteinDistance("unicorn", "uincon");
        assertEquals(3, distance);
    }
}
