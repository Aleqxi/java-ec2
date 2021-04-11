/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sallasal
 */
public class OptimalStringAlignmentTest {

    private OptimalStringAlignment osa;

    @Before
    public void setUp() {
        this.osa = new OptimalStringAlignment();
    }

    @Test
    public void osaRecognizesTransposition() {
        int distance = this.osa.optimalStringAlignment("elephant", "eelphant");
        assertEquals(1, distance);
    }

    @Test
    public void osaRecognizesSmallDeletionDistance() {
        int distance = this.osa.optimalStringAlignment("moose", "mose");
        assertEquals(1, distance);
    }
    
    @Test
    public void osaRecognizesSmallAdditionDistance() {
        int distance = this.osa.optimalStringAlignment("hose", "horse");
        assertEquals(1, distance);
    }
    
    @Test
    public void osaRecognizesSmallSubstitionDistance() {
        int distance = this.osa.optimalStringAlignment("moose", "goose");
        assertEquals(1, distance);
    }
    
    @Test
    public void osaRecognizesSubstitutionAndTranspositionTogether() {
        int distance = this.osa.optimalStringAlignment("unicorn", "uincon");
        assertEquals(2, distance);
    }
}
