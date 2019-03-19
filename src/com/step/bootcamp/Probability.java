package com.step.bootcamp;

class Probability {
    private double value;

    Probability(double value) throws InvalidProbabilityException {
        this.validateValue(value);
        this.value = value;
    }

    private void validateValue(double value) throws InvalidProbabilityException {
        if(value>1 || value<0) throw new InvalidProbabilityException();
    }


    Probability inverse() throws InvalidProbabilityException {
        return new Probability(1-this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }
}
