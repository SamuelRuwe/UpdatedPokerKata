package com.manifestcorp;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    HEARTS('H'), SPADES('S'), DIAMONDS('D'), CLUBS('C');

    private char value;
    public static final Map<Character, Suit> suitMap = new HashMap<>();

    Suit(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }

    public static Suit createCardSuit(char inputValue){
        Suit suit = suitMap.get(inputValue);
        return suit;
    }

    static {
        for(Suit suit: Suit.values()){
            suitMap.put(suit.getValue(), suit);
        }
    }
}