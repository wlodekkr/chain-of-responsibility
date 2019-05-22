package pl.refactoring.chain;

import org.junit.Before;
import org.junit.Test;

import static pl.refactoring.chain.HandAssert.assertThat;
import static pl.refactoring.chain.card.Card.aCard;
import static pl.refactoring.chain.card.RANK.*;
import static pl.refactoring.chain.card.SUIT.*;

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
public class HandResolverTest {
    private HandResolver handResolver;

    @Before
    public void setUp() throws Exception {
        handResolver = new HandResolver();
    }

    @Test
    public void canRecognizeFlush(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(HEART, QUEEN),
                aCard(HEART, TEN),
                aCard(HEART, FIVE),
                aCard(HEART, FOUR));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.FLUSH);
    }

    @Test
    public void canRecognizeStraightFlush(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(HEART, KING),
                aCard(HEART, QUEEN),
                aCard(HEART, JACK),
                aCard(HEART, TEN));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.STRAIGHT_FLUSH);
    }

    @Test
    public void canRecognizeStraight(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(DIAMOND, KING),
                aCard(HEART, QUEEN),
                aCard(CLUB, JACK),
                aCard(SPADE, TEN));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.STRAIGHT);
    }

    @Test
    public void canRecognizeHigherFourOfAKind(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(DIAMOND, ACE),
                aCard(CLUB, ACE),
                aCard(SPADE, ACE),
                aCard(HEART, TEN));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.FOUR_OF_A_KIND);
    }

    @Test
    public void canRecognizeLowerFourOfAKind(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(HEART, JACK),
                aCard(DIAMOND, JACK),
                aCard(CLUB, JACK),
                aCard(SPADE, JACK));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.FOUR_OF_A_KIND);
    }

    @Test
    public void canRecognizeHigherFullHouse(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(SPADE, JACK),
                aCard(DIAMOND, ACE),
                aCard(CLUB, JACK),
                aCard(SPADE, ACE));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.FULL_HOUSE);
    }

    @Test
    public void canRecognizeLowerFullHouse(){
        CardSet cardSet = new CardSet(
                aCard(HEART, QUEEN),
                aCard(SPADE, KING),
                aCard(DIAMOND, QUEEN),
                aCard(CLUB, KING),
                aCard(SPADE, QUEEN));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.FULL_HOUSE);
    }

    @Test
    public void canRecognizeLowestThreeOfAKind(){
        CardSet cardSet = new CardSet(
                aCard(HEART, TWO),
                aCard(SPADE, THREE),
                aCard(DIAMOND, TWO),
                aCard(CLUB, FOUR),
                aCard(SPADE, TWO));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.THREE_OF_A_KIND);
    }

    @Test
    public void canRecognizeMIddleThreeOfAKind(){
        CardSet cardSet = new CardSet(
                aCard(HEART, THREE),
                aCard(SPADE, TWO),
                aCard(DIAMOND, THREE),
                aCard(CLUB, FOUR),
                aCard(SPADE, THREE));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.THREE_OF_A_KIND);
    }

    @Test
    public void canRecognizeHighestThreeOfAKind(){
        CardSet cardSet = new CardSet(
                aCard(HEART, FOUR),
                aCard(SPADE, TWO),
                aCard(DIAMOND, FOUR),
                aCard(CLUB, THREE),
                aCard(SPADE, FOUR));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.THREE_OF_A_KIND);
    }

    @Test
    public void canRecognizeHighestOddAndTwoPairs(){
        CardSet cardSet = new CardSet(
                aCard(HEART, SEVEN),
                aCard(DIAMOND, SIX),
                aCard(CLUB, SIX),
                aCard(SPADE, FIVE),
                aCard(HEART, FIVE));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.TWO_PAIRS);
    }

    @Test
    public void canRecognizeMiddleOddAndTwoPairs(){
        CardSet cardSet = new CardSet(
                aCard(HEART, SEVEN),
                aCard(DIAMOND, SEVEN),
                aCard(CLUB, SIX),
                aCard(SPADE, FIVE),
                aCard(HEART, FIVE));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.TWO_PAIRS);
    }

    @Test
    public void canRecognizeLowestOddAndTwoPairs(){
        CardSet cardSet = new CardSet(
                aCard(HEART, SEVEN),
                aCard(DIAMOND, SEVEN),
                aCard(CLUB, SIX),
                aCard(SPADE, SIX),
                aCard(HEART, FIVE));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.TWO_PAIRS);
    }

    @Test
    public void canRecognizeHighestOnePair(){
        CardSet cardSet = new CardSet(
                aCard(HEART, EIGHT),
                aCard(DIAMOND, NINE),
                aCard(CLUB, TEN),
                aCard(SPADE, JACK),
                aCard(HEART, JACK));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.ONE_PAIR);
    }

    @Test
    public void canRecognizeMiddleOnePair(){
        CardSet cardSet = new CardSet(
                aCard(HEART, EIGHT),
                aCard(DIAMOND, NINE),
                aCard(CLUB, TEN),
                aCard(SPADE, TEN),
                aCard(HEART, JACK));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.ONE_PAIR);
    }

    @Test
    public void canRecognizeLowestOnePair(){
        CardSet cardSet = new CardSet(
                aCard(HEART, EIGHT),
                aCard(DIAMOND, EIGHT),
                aCard(CLUB, NINE),
                aCard(SPADE, TEN),
                aCard(HEART, JACK));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.ONE_PAIR);
    }

    @Test
    public void canRecognizeHighestCard(){
        CardSet cardSet = new CardSet(
                aCard(HEART, ACE),
                aCard(HEART, QUEEN),
                aCard(DIAMOND, TEN),
                aCard(SPADE, FIVE),
                aCard(CLUB, FOUR));

        Hand hand = handResolver.hand(cardSet);

        assertThat(hand)
                .hasRanking(RANKING.HIGH_CARD);
    }
}
