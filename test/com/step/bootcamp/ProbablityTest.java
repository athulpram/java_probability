package com.step.bootcamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
    @Test
    void shouldCreateProbability() {
        assertDoesNotThrow((Executable) () -> new Probability(1));
    }

    @Test
    void shouldThrowAnInvalidProbabilityException() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(1.2));
    }

    @Test
    void shouldThrowAnInvalidProbabilityExceptionWhenGivenLessThanZero() {
        assertThrows(InvalidProbabilityException.class, () -> new Probability(-1));
    }

    @Test
    void shouldReturnNotProbability() throws InvalidProbabilityException {
        Probability probability = new Probability(0.2);
        assertEquals(new Probability(0.8),probability.not());
    }

    @Test
    void shouldReturnTheTotalProbability() throws InvalidProbabilityException {
        Probability coin1ToGetTail = new Probability(0.5);
        Probability coin2ToGetTail = new Probability(0.5);

        Probability actual = coin1ToGetTail.intersect(coin2ToGetTail);
        Probability expected = new Probability(0.25);
        assertEquals(expected, actual);
    }
}