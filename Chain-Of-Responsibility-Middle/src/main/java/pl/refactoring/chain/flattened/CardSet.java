package pl.refactoring.chain.flattened;

import pl.refactoring.chain.flattened.card.Card;
import pl.refactoring.chain.flattened.card.RANK;
import pl.refactoring.chain.flattened.card.SUIT;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
public class CardSet {

    private final List<Card> sortedCards;

    public CardSet(Card card1, Card card2, Card card3, Card card4, Card card5) {
        SortedSet<Card> sortedSet = new TreeSet<>();

        sortedSet.add(card1);
        sortedSet.add(card2);
        sortedSet.add(card3);
        sortedSet.add(card4);
        sortedSet.add(card5);

        sortedCards = sortedSet.stream()
                .collect(Collectors.toList());

    }

    public List<Card> getSortedCards() {
        return sortedCards;
    }

    boolean isSequential() {
        List<Card> handCards = getSortedCards();

        int firstOrdinal = handCards.get(0).getRank().ordinal();
        int secondOrdinal = handCards.get(1).getRank().ordinal();
        int thirdOrdinal = handCards.get(2).getRank().ordinal();
        int fourthOrdinal = handCards.get(3).getRank().ordinal();
        int fifthOrdinal = handCards.get(4).getRank().ordinal();

        return firstOrdinal + 1 == secondOrdinal
                && secondOrdinal + 1 == thirdOrdinal
                && thirdOrdinal + 1 == fourthOrdinal
                && fourthOrdinal + 1 == fifthOrdinal;
    }

    boolean ofOneColor() {
        List<Card> handCards = getSortedCards();

        SUIT colorCandidate = handCards.get(0).getSuit();
        return handCards.stream()
                .allMatch(card -> card.getSuit().equals(colorCandidate));
    }

    boolean hasRanksDiversity(int ranksMultiplicity) {
        List<Card> handCards = getSortedCards();

        Map<RANK, List<Card>> cardsByRank =
                handCards.stream().collect(groupingBy(Card::getRank));

        List<RANK> ranks = cardsByRank.keySet()
                .stream()
                .collect(Collectors.toList());

        return ranks.size() == ranksMultiplicity;
    }

    boolean containsRankWithMultiplicity(int multiplicity) {
        List<Card> handCards = getSortedCards();

        Map<RANK, List<Card>> cardsByRank =
                handCards.stream().collect(groupingBy(Card::getRank));

        return cardsByRank.values()
                .stream()
                .anyMatch(singleRankCards -> singleRankCards.size() == multiplicity);
    }
}
