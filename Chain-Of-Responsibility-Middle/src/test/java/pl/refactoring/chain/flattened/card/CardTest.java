package pl.refactoring.chain.flattened.card;

import org.junit.Test;

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
public class CardTest {
    @Test
    public void aCardHasOneRankAndOneSuit(){
        Card card = Card.aCard(SUIT.HEART, RANK.ACE);

        SUIT suit = card.getSuit();
        RANK rank = card.getRank();

        assertThat(suit).isEqualTo(SUIT.HEART);
        assertThat(rank).isEqualTo(RANK.ACE);
    }
}
