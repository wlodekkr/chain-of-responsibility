package pl.refactoring.chain;

import pl.refactoring.chain.card.Card;
import pl.refactoring.chain.card.RANK;
import pl.refactoring.chain.card.SUIT;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static pl.refactoring.chain.RANKING.*;

/**
 * Copyrights (c) 2018 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 *
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 *
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 *
 * If willing to do so, please contact the author.
 */
public class HandResolver {
    public Hand hand(CardSet cardSet) {
        List<Card> handCards = cardSet.getSortedCards();

        // Figure our high card by same color
        SUIT colorCandidate = handCards.get(0).getSuit();
        boolean allSameColor = handCards.stream()
                .allMatch(card -> card.getSuit().equals(colorCandidate));
        if (allSameColor){
            // Check for straight flush
            int firstOrdinal = handCards.get(0).getRank().ordinal();
            int secondOrdinal = handCards.get(1).getRank().ordinal();
            int thirdOrdinal = handCards.get(2).getRank().ordinal();
            int fourthOrdinal = handCards.get(3).getRank().ordinal();
            int fifthOrdinal = handCards.get(4).getRank().ordinal();

            if (firstOrdinal + 1 == secondOrdinal
                    && secondOrdinal + 1 == thirdOrdinal
                    && thirdOrdinal + 1 == fourthOrdinal
                    && fourthOrdinal + 1 == fifthOrdinal)
                return new Hand(STRAIGHT_FLUSH, handCards);
            else
                return new Hand(FLUSH, handCards);
        }
        else{
            // Check for possible x of a kind
            Map<RANK, List<Card>> cardsByRank = handCards.stream().collect(groupingBy(Card::getRank));

            List<RANK> ranks = cardsByRank.keySet()
                    .stream()
                    .collect(Collectors.toList());
            if (ranks.size() == 5){
                // Check for straight
                int firstOrdinal = handCards.get(0).getRank().ordinal();
                int secondOrdinal = handCards.get(1).getRank().ordinal();
                int thirdOrdinal = handCards.get(2).getRank().ordinal();
                int fourthOrdinal = handCards.get(3).getRank().ordinal();
                int fifthOrdinal = handCards.get(4).getRank().ordinal();

                if (firstOrdinal + 1 == secondOrdinal
                        && secondOrdinal + 1 == thirdOrdinal
                        && thirdOrdinal + 1 == fourthOrdinal
                        && fourthOrdinal + 1 == fifthOrdinal)
                    return new Hand(STRAIGHT, handCards);
            }
            if (ranks.size() == 2){
                // Look for four of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 4 ||
                    cardsByRank.get(ranks.get(1)).size() == 4)
                    return new Hand(FOUR_OF_A_KIND, handCards);
                // Look for full house
                else {
                    return new Hand(FULL_HOUSE, handCards);
                }
            } else if (ranks.size() == 3){
                // Look for 3 of a kind
                if (cardsByRank.get(ranks.get(0)).size() == 3 ||
                        cardsByRank.get(ranks.get(1)).size() == 3 ||
                        cardsByRank.get(ranks.get(2)).size() == 3)
                    return new Hand(THREE_OF_A_KIND, handCards);

                // Look for 2 pairs
                if (cardsByRank.get(ranks.get(0)).size() == 1 ||
                        cardsByRank.get(ranks.get(1)).size() == 1 ||
                        cardsByRank.get(ranks.get(2)).size() == 1)
                    return new Hand(TWO_PAIRS, handCards);
            } else if (ranks.size() == 4){
                return new Hand(ONE_PAIR, handCards);
            } else {
                return new Hand(HIGH_CARD, handCards);
            }
        }

        return new Hand(HIGH_CARD, handCards);
    }
}
