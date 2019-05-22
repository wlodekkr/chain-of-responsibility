package pl.refactoring.chain;

import pl.refactoring.chain.card.CardDeck;
import pl.refactoring.chain.card.CardDeckFactory;

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
public class PokerHandResolverMain {
    public static void main(String[] args) {
        CardDeckFactory factory = new CardDeckFactory();
        CardDeck deck = factory.createDeck(32);


    }
}
