package pl.refactoring.chain.flattened.card;

import java.util.Set;
import java.util.TreeSet;

import static pl.refactoring.chain.flattened.card.Card.aCard;

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
public class CardDeckFactory {
    public CardDeck createDeck(int numberOfCards) {

        if (numberOfCards % 4 != 0 ||
                numberOfCards < 4 ||
                numberOfCards > 52) {
            throw new IllegalArgumentException("Number of Cards must be multipler of 4 between 4 and 52");
        }

        int numberOfRanks = numberOfCards / 4;

        Set<Card> cards = new TreeSet<>();

        for (SUIT suit : SUIT.values()){
            for (int i = 0; i < numberOfRanks; i++){
                cards.add(aCard(suit, RANK.values()[i]));
            }
        }

        return new CardDeck(cards);
    }
}
