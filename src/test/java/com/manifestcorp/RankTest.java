package com.manifestcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RankTest {

    @Test
    public void testRankMap() {
        Rank rank = Rank.createCardRank('T');
        assertEquals(Rank.TEN, rank);
    }
}
