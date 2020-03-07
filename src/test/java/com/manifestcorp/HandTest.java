package com.manifestcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {

    @Test
    public void testGetPlayerName() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertEquals("Player name is Black", hand.getPlayerName(), "Black");
    }

    @Test
    public void testGetCards() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        assertEquals("Card array is returned", Rank.JACK, hand.getCards()[0].getRank());
        assertEquals("Card array is returned", Rank.ACE, hand.getCards()[1].getRank());
        assertEquals("Card array is returned", Rank.FOUR, hand.getCards()[2].getRank());
        assertEquals("Card array is returned", Rank.NINE, hand.getCards()[3].getRank());
        assertEquals("Card array is returned", Rank.TWO, hand.getCards()[4].getRank());

    }
    @Test
    public void testHandForHighCard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is HighCard", HandScore.HIGH_CARD, hand.getHandScore());
    }

    @Test
    public void testHandForSinglePair() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.FOUR, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is single pair", HandScore.PAIR, hand.getHandScore());
    }

    @Test
    public void testHandForTwoPairs() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.NINE, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is two pairs", HandScore.TWO_PAIRS, hand.getHandScore());
    }

    @Test
    public void testHandForThreeOfAKind() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.TWO, Suit.SPADES);
        Card cardFour = new Card(Rank.TWO, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is three of a kind", HandScore.THREE_OF_A_KIND, hand.getHandScore());
    }

    @Test
    public void testHandForStraight() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.QUEEN, Suit.SPADES);
        Card cardFour = new Card(Rank.TEN, Suit.HEARTS);
        Card cardFive = new Card(Rank.KING, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is straight", HandScore.STRAIGHT, hand.getHandScore());
    }

    @Test
    public void testHandForFlush() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardFour = new Card(Rank.NINE, Suit.DIAMONDS);
        Card cardFive = new Card(Rank.TWO, Suit.DIAMONDS);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Hand rank is flush", HandScore.FLUSH, hand.getHandScore());
    }

    @Test
    public void testHandForFullHouse() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.NINE, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.NINE, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is full house", HandScore.FULL_HOUSE, hand.getHandScore());
    }

    @Test
    public void testHandForFourOfAKind() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.FOUR, Suit.HEARTS);
        Card cardFive = new Card(Rank.FOUR, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is four of a kind", HandScore.FOUR_OF_A_KIND, hand.getHandScore());
    }

    @Test
    public void testHandForStraightFlush() {
        Card cardOne = new Card(Rank.FIVE, Suit.SPADES);
        Card cardTwo = new Card(Rank.SIX, Suit.SPADES);
        Card cardThree = new Card(Rank.SEVEN, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.SPADES);
        Card cardFive = new Card(Rank.EIGHT, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Handscore is straight flush", hand.getHandScore(), HandScore.STRAIGHT_FLUSH);
    }

    @Test
    public void testHandForLowAceStraight() {
        Card cardOne = new Card(Rank.TWO, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.THREE, Suit.HEARTS);
        Card cardFive = new Card(Rank.FIVE, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        assertEquals("Hand score should be straight", hand.getHandScore(), HandScore.STRAIGHT);
    }

    @Test
    public void testForTieOnHighcard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("Should be a tie", 0, hand.compareTo(hand2));
    }

    @Test
    public void testForStraightBeatsHighCard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        cardOne = new Card(Rank.SIX, Suit.DIAMONDS);
        cardTwo = new Card(Rank.FIVE, Suit.DIAMONDS);
        cardThree = new Card(Rank.FOUR, Suit.SPADES);
        cardFour = new Card(Rank.THREE, Suit.HEARTS);
        cardFive = new Card(Rank.TWO, Suit.SPADES);
        playerName = "White";
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand2.getScore();
        assertEquals("White should win with straight", -1, hand.compareTo(hand2));
    }

    @Test
    public void testForBlackBeatsWhiteWithThreeOfKindVsPair() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.JACK, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        cardThree = new Card(Rank.FOUR, Suit.SPADES);
        cardFour = new Card(Rank.FOUR, Suit.HEARTS);
        cardFive = new Card(Rank.TWO, Suit.SPADES);
        playerName = "White";
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand2.getScore();
        assertEquals("Black should win with Trips", 1, hand.compareTo(hand2));
    }

    @Test
    public void testForWhiteWinOnHighcard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        cardFive = new Card(Rank.THREE, Suit.SPADES);
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("Player two wins with highcard", -1, hand.compareTo(hand2));
    }

    @Test
    public void testForBlackWinOnHighcard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        cardTwo = new Card(Rank.THREE, Suit.SPADES);
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("Player one wins with highcard", 1, hand.compareTo(hand2));
    }

    @Test
    public void testForBlackWinOnHighcardWhenBothHavePairs() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.NINE, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        cardThree = new Card(Rank.THREE, Suit.SPADES);
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("Player one wins with pair/highcard", 1, hand.compareTo(hand2));
    }

    @Test
    public void testForWhiteWinOnTwoPairsWithHighCard() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.FOUR, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        cardFive = new Card(Rank.THREE, Suit.SPADES);
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("White wins with twopair/highcard", -1, hand.compareTo(hand2));
    }

    @Test
    public void testForWhiteWinOnFullHouseVsTwoPairs() {
        Card cardOne = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardTwo = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardThree = new Card(Rank.FOUR, Suit.SPADES);
        Card cardFour = new Card(Rank.FOUR, Suit.HEARTS);
        Card cardFive = new Card(Rank.TWO, Suit.SPADES);
        String playerName = "Black";
        Hand hand = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        cardOne = new Card(Rank.TWO, Suit.CLUBS);
        cardTwo = new Card(Rank.TWO, Suit.SPADES);
        cardThree = new Card(Rank.TWO, Suit.DIAMONDS);
        cardFour = new Card(Rank.THREE,Suit.DIAMONDS);
        cardFive = new Card(Rank.THREE, Suit.SPADES);
        playerName = "White";
        Hand hand2 = new Hand(playerName, cardOne, cardTwo, cardThree, cardFour, cardFive);
        hand.getScore();
        hand2.getScore();
        assertEquals("White wins with full house", -1, hand.compareTo(hand2));
    }
}
