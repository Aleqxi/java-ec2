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
    public void weightedRecognizesTransposition() {
        double distance = this.osa.weightedOSA("elephant", "eelphant");
        assertEquals(0.825, distance, 0.001);
    }

    @Test
    public void osaRecognizesSmallDeletionDistance() {
        int distance = this.osa.optimalStringAlignment("moose", "mose");
        assertEquals(1, distance);
    }

    @Test
    public void weightedRecognizesSmallDeletionDistance() {
        double distance = this.osa.weightedOSA("moose", "mose");
        assertEquals(0.537, distance, 0.001);
    }

    @Test
    public void osaRecognizesSmallAdditionDistance() {
        int distance = this.osa.optimalStringAlignment("hose", "horse");
        assertEquals(1, distance);
    }

    @Test
    public void weightedRecognizesSmallAdditionDistance() {
        double distance = this.osa.weightedOSA("hose", "horse");
        assertEquals(0.796, distance, 0.);
    }

    @Test
    public void osaRecognizesSmallSubstitionDistance() {
        int distance = this.osa.optimalStringAlignment("moose", "goose");
        assertEquals(1, distance);
    }

    @Test
    public void weightedRecognizesSmallSubstitionDistance() {
        double distance = this.osa.weightedOSA("moose", "goose");
        assertEquals(0.841, distance, 0.001);
    }

    @Test
    public void osaRecognizesDeletionAndTranspositionTogether() {
        int distance = this.osa.optimalStringAlignment("unicorn", "uincon");
        assertEquals(2, distance);
    }

    @Test
    public void weightedRecognizesDeletionAndTranspositionTogether() {
        double distance = this.osa.weightedOSA("unicorn", "uincon");
        assertEquals(1.362, distance, 0.001);
    }
    
    @Test
    public void weightedRecognizesSubstitutionAndAdditionTogether() {
        double distance = this.osa.weightedOSA("oliphant", "uliphhant");
        assertEquals(1.637, distance, 0.001);
    }
}
