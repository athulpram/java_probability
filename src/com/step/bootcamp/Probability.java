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

    Probability intersect(Probability probability) throws InvalidProbabilityException {
        return new Probability(this.value * probability.value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

}
