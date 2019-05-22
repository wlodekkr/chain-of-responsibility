package pl.refactoring.tutor.chain.card;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
public class CardDeckTest {
    private CardDeckFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new CardDeckFactory();
    }

    @Test
    public void canDrawACard(){
        CardDeck deck = factory.createDeck(4);

        Set<Card> remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(4);

        Card firstRandomCard = deck.draw();

        remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(3)
                .doesNotContain(firstRandomCard);

        Card secondRandomCard = deck.draw();

        remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(2)
                .doesNotContain(firstRandomCard, secondRandomCard);
    }
}
