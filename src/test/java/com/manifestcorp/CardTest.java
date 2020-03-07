package com.manifestcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void testAceBeatsTwoInHighCard() {
        Card winningCard = new Card(Rank.ACE, Suit.CLUBS);
        Card losingCard = new Card(Rank.TWO, Suit.CLUBS);
        assertEquals("winningCard should be greater than losingCard", 1, winningCard.compareTo(losingCard));
    }

    @Test
    public void testKingTiesKingInHighCard() {
        Card winningCard = new Card(Rank.KING, Suit.CLUBS);
        Card losingCard = new Card(Rank.KING, Suit.CLUBS);
        assertEquals("cards should be equal", 0, winningCard.compareTo(losingCard));
    }

    @Test
    public void testTenBeatsSevenInHighCard() {
        Card winningCard = new Card(Rank.TEN, Suit.CLUBS);
        Card losingCard = new Card(Rank.SEVEN, Suit.CLUBS);
        assertEquals("losingCard should be less than winningCard", -1, losingCard.compareTo(winningCard));
    }

    @Test
    public void testCardSuit() {
        Card card1 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card2 = new Card(Rank.TWO, Suit.HEARTS);
        Card card3 = new Card(Rank.TWO, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.CLUBS);

        assertEquals("Card should be Diamonds", Suit.DIAMONDS, card1.getSuit());
        assertEquals("Card should be Hearts", Suit.HEARTS, card2.getSuit());
        assertEquals("Card should be Spades", Suit.SPADES, card3.getSuit());
        assertEquals("Card should be Clubs", Suit.CLUBS, card4.getSuit());

    }

}
