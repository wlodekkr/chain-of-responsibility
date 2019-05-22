package pl.refactoring.tutor.chain.spec;

import pl.refactoring.tutor.chain.CardSet;
import pl.refactoring.tutor.chain.RANKING;

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
public interface Spec {
    boolean isSatisfiedBy(CardSet cardSet);

    RANKING getRanking();
}
