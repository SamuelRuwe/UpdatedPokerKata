package com.manifestcorp;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'),
    TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');

    private char value;
    public static final Map<Character, Rank> rankMap = new HashMap<>();

    Rank (char value) {
        this.value= value;
    }

    public char getValue() {
        return this.value;
    }

    public static Rank createCardRank(char inputValue){
        Rank rank = rankMap.get(inputValue);
        return rank;
    }

    static {
        for(Rank rank : Rank.values()){
            rankMap.put(rank.getValue(), rank);
        }
    }
}