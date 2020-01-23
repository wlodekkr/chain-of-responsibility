package pl.refactoring.chain.card;

import java.util.*;
import java.util.stream.Collectors;

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
public class CardDeck {
    private final List<Card> cards;

    public CardDeck(Set<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.shuffle(this.cards);
    }

    // Immutable
    public SortedSet<Card> getRemainingCards() {
        return new TreeSet<>(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}
