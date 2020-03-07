package com.manifestcorp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PokerTest {

    ByteArrayOutputStream baos;
    PrintStream ps;
    PrintStream previous = System.out;

    @Before
    public void setUp() {
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        System.setOut(ps);
    }
    @After
    public void tearDown() {
        System.out.flush();
        System.setOut(previous);
//        System.out.println(" ! ! " + baos.toString());
    }

    @Test
    public void testCardCreation() {
        String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card card4 = new Card(Rank.NINE, Suit.CLUBS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand1 = new Hand("Black", card1, card2, card3, card4, card5);
        card1 = new Card(Rank.TWO, Suit.CLUBS);
        card2 = new Card(Rank.THREE, Suit.HEARTS);
        card3 = new Card(Rank.FOUR, Suit.SPADES);
        card4 = new Card(Rank.EIGHT, Suit.CLUBS);
        card5 = new Card(Rank.ACE, Suit.HEARTS);
        Hand hand2 = new Hand("White", card1, card2, card3, card4, card5);
        Hand[] returnedHands = Poker.stringParser(input);
        assertEquals("Parser should return two hands of cards", hand1.getCards()[0].getRank(), returnedHands[0].getCards()[0].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[1].getRank(), returnedHands[0].getCards()[1].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[2].getRank(), returnedHands[0].getCards()[2].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[3].getRank(), returnedHands[0].getCards()[3].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[4].getRank(), returnedHands[0].getCards()[4].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[0].getRank(), returnedHands[1].getCards()[0].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[1].getRank(), returnedHands[1].getCards()[1].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[2].getRank(), returnedHands[1].getCards()[2].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[3].getRank(), returnedHands[1].getCards()[3].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[4].getRank(), returnedHands[1].getCards()[4].getRank());

    }

    @Test
    public void testCardCreationTwo() {
        String input = "Black: 2H 7H 2D 3C 3D  White: 2H 7H 7D 7C 7S";
        Card card1 = new Card(Rank.TWO, Suit.HEARTS);
        Card card2 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card3 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card4 = new Card(Rank.THREE, Suit.CLUBS);
        Card card5 = new Card(Rank.THREE, Suit.DIAMONDS);
        Hand hand1 = new Hand("Black", card1, card2, card3, card4, card5);
        card1 = new Card(Rank.TWO, Suit.HEARTS);
        card2 = new Card(Rank.SEVEN, Suit.HEARTS);
        card3 = new Card(Rank.SEVEN, Suit.DIAMONDS);
        card4 = new Card(Rank.SEVEN, Suit.CLUBS);
        card5 = new Card(Rank.SEVEN, Suit.SPADES);
        Hand hand2 = new Hand("White", card1, card2, card3, card4, card5);
        Hand[] returnedHands = Poker.stringParser(input);
        assertEquals("Parser should return two hands of cards", hand1.getCards()[0].getRank(), returnedHands[0].getCards()[0].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[1].getRank(), returnedHands[0].getCards()[1].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[2].getRank(), returnedHands[0].getCards()[2].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[3].getRank(), returnedHands[0].getCards()[3].getRank());
        assertEquals("Parser should return two hands of cards", hand1.getCards()[4].getRank(), returnedHands[0].getCards()[4].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[0].getRank(), returnedHands[1].getCards()[0].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[1].getRank(), returnedHands[1].getCards()[1].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[2].getRank(), returnedHands[1].getCards()[2].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[3].getRank(), returnedHands[1].getCards()[3].getRank());
        assertEquals("Parser should return two hands of cards", hand2.getCards()[4].getRank(), returnedHands[1].getCards()[4].getRank());
    }

    @Test
    public void testPoker1() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
        String result = baos.toString().trim();
        assertEquals("White wins with HIGH_CARD", result);
    }

    @Test
    public void testPoker2() {
        Poker.playPoker("Black: 2H 7H 2D 3C 3D  White: 2H 7H 7D 7C 7S");
        String result = baos.toString().trim();
        assertEquals("White wins with FOUR_OF_A_KIND", result);
    }

    @Test
    public void testPoker3() {
        Poker.playPoker("Black: TH JH QH KH AH  White: 4H 4S KS 5D TS");
        String result = baos.toString().trim();
        assertEquals("Black wins with STRAIGHT_FLUSH", result);
    }

    @Test
    public void testPoker4() {
        Poker.playPoker("Black: QC 9C 7C 6C 4C  White: AD AH 7C 6C 4C");
        String result = baos.toString().trim();
        assertEquals("Black wins with FLUSH", result);
    }

    @Test
    public void testPoker5() {
        Poker.playPoker("Black: 2C 4C 6C 8C AD  White: 2C 4C 6C 8C TD");
        String result = baos.toString().trim();
        assertEquals("Black wins with HIGH_CARD", result);
    }

    @Test
    public void testPoker6() {
        Poker.playPoker("Black: 2C 2C 4C 4C TD  White: 2C 2C 4C 4C JD");
        String result = baos.toString().trim();
        assertEquals("White wins with TWO_PAIRS", result);
    }

    @Test
    public void testPoker7() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 2H 4S 8C AH");
        String result = baos.toString().trim();
        assertEquals("White wins with PAIR", result);
    }

    @Test
    public void testPoker8() {
        Poker.playPoker("Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S");
        String result = baos.toString().trim();
        assertEquals("Black wins with FULL_HOUSE", result);
    }

    @Test
    public void testPoker9() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH");
        String result = baos.toString().trim();
        assertEquals("Black wins with HIGH_CARD", result);
    }

    @Test
    public void testPoker10() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 2H 4S 8C AH");
        String result = baos.toString().trim();
        assertEquals("White wins with PAIR", result);
    }

    @Test
    public void testPoker11() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH");
        String result = baos.toString().trim();
        assertEquals("White wins with HIGH_CARD", result);
    }

    @Test
    public void testPoker12() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH");
        String result = baos.toString().trim();
        assertEquals("It's a tie!", result);
    }

    @Test
    public void testPoker13() {
        Poker.playPoker("Black: 2H 3D 5S 4C AD  White: 2D 3H 5C 9S KH");
        String result = baos.toString().trim();
        assertEquals("Black wins with STRAIGHT", result);
    }

    @Test
    public void testPoker14() {
        Poker.playPoker("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH");
        String result = baos.toString().trim();
        assertEquals("Black wins with HIGH_CARD", result);
    }

    @Test
    public void testPoker15() {
        Poker.playPoker("Black: 2H 2H 3D 3D 5S White: 6D 6D 6D 2H AH");
        String result = baos.toString().trim();
        assertEquals("White wins with THREE_OF_A_KIND", result);
    }
}