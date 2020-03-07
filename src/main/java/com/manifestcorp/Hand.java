package com.manifestcorp;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Hand implements Comparable<Hand> {

    private String playerName;
    private Card[] cards = new Card[5];
    private HandScore handScore;
    private final Map<Rank, Integer> map = new LinkedHashMap<>();
    private Map<Rank, Integer> sortedMap;

    public Hand(String playerName, Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive) {
        this.playerName = playerName;
        this.cards[0] = cardOne;
        this.cards[1] = cardTwo;
        this.cards[2] = cardThree;
        this.cards[3] = cardFour;
        this.cards[4] = cardFive;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card[] getCards() {
        return cards;
    }

    public HandScore getHandScore() {
        return this.handScore;
    }

    public void getScore() {
        this.handScore = setHandScore();
    }

    public HandScore setHandScore() {
        sortCards();
        if(sortedMap.size() == 2) {
            return sortedMap.values().toArray()[0].equals(4) ? HandScore.FOUR_OF_A_KIND : HandScore.FULL_HOUSE;
        }
        if(sortedMap.size() == 3) {
            return sortedMap.values().toArray()[0].equals(3) ? HandScore.THREE_OF_A_KIND : HandScore.TWO_PAIRS;
        }
        if(sortedMap.size() == 4) {
            return HandScore.PAIR;
        } else {
            if(checkFlush()) {
                return checkStraight() ? HandScore.STRAIGHT_FLUSH : HandScore.FLUSH;
                }
            return checkStraight() ? HandScore.STRAIGHT : HandScore.HIGH_CARD;
        }
    }

    public boolean checkStraight() {
        Arrays.sort(cards);
        int requiredRank = cards[0].getRank().ordinal();
        for(Card card: cards) {
            if(card.getRank().ordinal() != requiredRank) {
                boolean lowAceStraight = (cards[0].getRank() != Rank.TWO || cards[1].getRank() != Rank.THREE || cards[2].getRank() != Rank.FOUR
                        || cards[3].getRank() != Rank.FIVE || cards[4].getRank() != Rank.ACE);
                if(lowAceStraight) {
                    return false;
                }
                return true;
            }
            requiredRank++;
        }
        return true;
    }

    public boolean checkFlush() {
        Suit requiredSuit = cards[0].getSuit();
        for(Card card: cards) {
            if (card.getSuit() != requiredSuit) {
                return false;
            }
        }
        return true;
    }

    public void sortCards() {
        Arrays.sort(cards, Collections.reverseOrder());
        for(Card card: cards) {
            map.putIfAbsent(card.getRank(), 0);
            map.put(card.getRank(), map.get(card.getRank()) + 1);
        }

        sortedMap = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

    @Override
    public int compareTo(Hand hand) {
        if(this.handScore.ordinal() > hand.handScore.ordinal()) {
            return 1;
        } else if(this.handScore.ordinal() < hand.handScore.ordinal()) {
            return -1;
        }
        for(int i = 0; i < this.sortedMap.keySet().toArray().length; i++) {
            Rank rankOne = (Rank) this.sortedMap.keySet().toArray()[i];
            Rank rankTwo = (Rank) hand.sortedMap.keySet().toArray()[i];
            if(rankOne.ordinal() > rankTwo.ordinal()) {
                return 1;
            } else if(rankTwo.ordinal() > rankOne.ordinal()) {
                return -1;
            }
        }
        return 0;
    }
}