package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;

import java.util.*;

/**
 * Corypight (c) 2018 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 *
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 *
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 *
 * If willing to do so, please contact the author.
 */
public class Hand {
    private final RANKING ranking;
    private final SortedSet<Card> cardList;

    public Hand(RANKING ranking, List<Card> cardList) {
        this.ranking = ranking;
        this.cardList = new TreeSet<>(cardList);
    }

    public RANKING getRanking() {
        return ranking;
    }

    public SortedSet<Card> getSortedCards() {
        return cardList;
    }
}
