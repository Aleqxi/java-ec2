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
public class ArrayDeqImplementationTest {

    private ArrayDeqImplementation arrayDeq;

    @Before
    public void setUp() {
        this.arrayDeq = new ArrayDeqImplementation();
        arrayDeq.addLast("zero");
        arrayDeq.addLast("one");
        arrayDeq.addLast("two");
        arrayDeq.addLast("three");
        arrayDeq.addLast("four");
        arrayDeq.addLast("five");
        arrayDeq.addLast("six");
        arrayDeq.addLast("seven");
    }

    @Test
    public void returnsSizeCorrectly() {
        assertEquals(8, arrayDeq.size());
    }

    @Test
    public void indexesWorkCorrectly() {
        assertEquals("zero", arrayDeq.getFromIndex(0));
        assertEquals("four", arrayDeq.getFromIndex(4));
    }

    @Test
    public void addingNewWordsGrowTheSize() {
        arrayDeq.addLast("eight");
        arrayDeq.addLast("nine");
        assertEquals(10, arrayDeq.size());
    }

    @Test
    public void addingNewWordsAddsThemToCorrectIndexes() {
        arrayDeq.addLast("eight");
        arrayDeq.addLast("nine");
        assertEquals("eight", arrayDeq.getFromIndex(8));
        assertEquals("nine", arrayDeq.getFromIndex(9));
    }

    @Test
    public void growingAllowsToAddMoreWords() {
        arrayDeq.addLast("eight");
        arrayDeq.addLast("nine");
        arrayDeq.addLast("ten");
        arrayDeq.addLast("eleven");
        assertEquals("ten", arrayDeq.getFromIndex(10));
        assertEquals("eleven", arrayDeq.getFromIndex(11));
    }

}
