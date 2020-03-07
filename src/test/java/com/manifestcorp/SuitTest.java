package com.manifestcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuitTest {

    @Test
    public void suitMapTest() {
        assertEquals("Should return Suit.DIAMONDS", Suit.DIAMONDS, Suit.createCardSuit('D'));
    }
}
