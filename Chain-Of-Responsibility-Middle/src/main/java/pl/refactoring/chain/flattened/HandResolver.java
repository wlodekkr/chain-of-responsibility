package pl.refactoring.chain.flattened;

import pl.refactoring.chain.flattened.card.Card;

import java.util.List;

import static pl.refactoring.chain.flattened.RANKING.*;

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

        if (cardSet.ofOneColor() && cardSet.isSequential())
            return new Hand(STRAIGHT_FLUSH, handCards);

        if (cardSet.ofOneColor() && !cardSet.isSequential())
            return new Hand(FLUSH, handCards);

        // Check for possible x of a kind
        if (cardSet.hasRanksDiversity(5) &&
                cardSet.isSequential())
            return new Hand(STRAIGHT, handCards);

        // Look for four of a kind
        if (cardSet.hasRanksDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4))
            return new Hand(FOUR_OF_A_KIND, handCards);

        // Look for full house
        if (cardSet.hasRanksDiversity(2) &&
                !cardSet.containsRankWithMultiplicity(4))
            return new Hand(FULL_HOUSE, handCards);

        // Look for 3 of a kind
        if (cardSet.hasRanksDiversity(3) &&
                cardSet.containsRankWithMultiplicity(3))
            return new Hand(THREE_OF_A_KIND, handCards);

        // Look for 2 pairs
        if (cardSet.hasRanksDiversity(3) &&
                cardSet.containsRankWithMultiplicity(1))
            return new Hand(TWO_PAIRS, handCards);

        if (cardSet.hasRanksDiversity(4)){
            return new Hand(ONE_PAIR, handCards);
        }

        return new Hand(HIGH_CARD, handCards);
    }

}
