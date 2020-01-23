package pl.refactoring.chain;

import org.assertj.core.api.AbstractAssert;

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
public class HandAssert extends AbstractAssert<HandAssert, Hand> {
    public HandAssert(Hand actual) {
        super(actual, HandAssert.class);
    }

    public static HandAssert assertThat(Hand hand) {
        return new HandAssert(hand);
    }

    public HandAssert hasRanking(RANKING ranking) {
        isNotNull();
        if (!actual.getRanking().equals(ranking)) {
            failWithMessage("Expected hand to be of ranking %s but was %s",
                    ranking, actual.getRanking());
        }

        return this;
    }
}
