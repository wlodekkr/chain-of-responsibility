package pl.refactoring.tutor.chain;

import pl.refactoring.tutor.chain.card.Card;
import pl.refactoring.tutor.chain.spec.*;
import pl.refactoring.tutor.chain.spec.Spec;

import java.util.Arrays;
import java.util.List;

import static pl.refactoring.tutor.chain.RANKING.*;

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
public class HandResolver {
    private static final Spec ONE_PAIR_SPEC = new OnePairSpec();
    private static final Spec TWO_PAIR_SPEC = new TwoPairSpec();
    private static final Spec THREE_OF_A_KIND_SPEC = new ThreeOfAKindSpec();
    private static final Spec FULL_HOUSE_SPEC = new FullHouseSpec();
    private static final Spec FOUR_OF_A_KIND_SPEC = new FourOfAKindSpec();
    private static final Spec STRAIGHT_SPEC = new StraightSpec();
    private static final Spec FLUSH_SPEC = new FlushSpec();
    private static final Spec STRAIGHT_FLUSH_SPEC = new StraightFlushSpec();

    public Hand hand(CardSet cardSet) {
        List<Card> handCards = cardSet.getSortedCards();

        List<Spec> specs = Arrays.asList(
                STRAIGHT_FLUSH_SPEC,
                FLUSH_SPEC,
                STRAIGHT_SPEC,
                FOUR_OF_A_KIND_SPEC,
                FULL_HOUSE_SPEC,
                THREE_OF_A_KIND_SPEC,
                TWO_PAIR_SPEC,
                ONE_PAIR_SPEC);

        return specs.stream()
                .filter(spec -> spec.isSatisfiedBy(cardSet))
                .findFirst()
                .map(spec -> new Hand(spec.getRanking(), handCards))
                .orElse(new Hand(HIGH_CARD, handCards));
    }

}
