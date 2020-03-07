package com.manifestcorp;

public class Card implements Comparable<Card>{

    private Rank rank;
    private Suit suit;

    public Card (Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
           return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card card) {
        return this.rank.ordinal() > card.rank.ordinal() ? 1 :
                this.rank.ordinal() < card.rank.ordinal() ? -1 : 0;
    }
}