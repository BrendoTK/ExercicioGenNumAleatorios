package org.example.brendobrazsales;

import org.apache.commons.math3.distribution.RealDistribution;

public class RealDistributionAdapter implements RandomNumberGenerator {
    private final RealDistribution distribution;

    public RealDistributionAdapter(RealDistribution distribution) {
        this.distribution = distribution;
    }

    @Override
    public double[] generateNumbers(int count) {
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = distribution.sample();
        }
        return numbers;
    }

    @Override
    public void reseedRandomGenerator(long seed) {
        distribution.reseedRandomGenerator(seed);
    }
}
