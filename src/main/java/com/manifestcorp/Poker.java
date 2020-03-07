package com.manifestcorp;

import java.util.Arrays;

public class Poker {

    public static void playPoker(String input) {
        Hand[] hands = stringParser(input);
        Hand Black = hands[0];
        Hand White = hands[1];
        printWinner(Black, White);
    }

    public static Hand[] stringParser(String input) {
        Hand[] hands = new Hand[2];
        String[] tempString = input.trim()
                .replaceAll("\\s{2}", " ")
                .replaceAll(":", "")
                .split(" ");
        hands[0] = createHandFromString(Arrays.copyOfRange(tempString, 0, 6));
        hands[1] = createHandFromString(Arrays.copyOfRange(tempString, 6, 12));
        return hands;
    }

    public static Hand createHandFromString(String[] input) {
        String name = input[0];
        Card[] cards = new Card[5];
        Card card;
        for(int i = 1; i < 6; i++) {
            Rank rank = Rank.createCardRank(input[i].toCharArray()[0]);
            Suit suit = Suit.createCardSuit(input[i].toCharArray()[1]);
            card = new Card(rank, suit);
            cards[i-1] = card;
        }
        return new Hand(name, cards[0], cards[1], cards[2], cards[3], cards[4]);
    }

    public static void printWinner(Hand Black, Hand White) {
        Black.getScore();
        White.getScore();
        if (Black.compareTo(White) == 1) {
            System.out.println("Black wins with " + Black.getHandScore());
        } else if(Black.compareTo(White) == -1) {
            System.out.println("White wins with " + White.getHandScore());
        } else {
            System.out.println("It's a tie!");
        }
    }
}