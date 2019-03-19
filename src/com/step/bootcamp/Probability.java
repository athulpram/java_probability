package com.step.bootcamp;

class Probability {
    private double value;
    private final int MIN_PROBABILITY = 0;
    private final int MAX_PROBABILITY = 1;

    Probability(double value) throws InvalidProbabilityException {
        this.validateValue(value);
        this.value = value;
    }

    private void validateValue(double value) throws InvalidProbabilityException {
        if (value > MAX_PROBABILITY || value < MIN_PROBABILITY) throw new InvalidProbabilityException();
    }


    Probability not() throws InvalidProbabilityException {
        return new Probability(MAX_PROBABILITY - this.value);
    }

    Probability and(Probability probability) throws InvalidProbabilityException {
        return new Probability(this.value * probability.value);
    }


    @Override
    public boolean equals(Object probability) {
        if (this == probability) return true;
        if (probability == null || getClass() != probability.getClass()) return false;
        Probability that = (Probability) probability;
        return Double.compare(that.value, value) == 0;
    }

    Probability or(Probability probability) throws InvalidProbabilityException {
        double orProbabilityValue = 1 - this.and(probability.not()).value;
        return new Probability(orProbabilityValue);
    }
}
