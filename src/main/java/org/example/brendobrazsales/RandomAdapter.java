package org.example.brendobrazsales;

import java.util.Random;

public class RandomAdapter implements RandomNumberGenerator {
    private final Random random;

    public RandomAdapter(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public double[] generateNumbers(int count) {
        return random.doubles(count).toArray();
    }

    @Override
    public void reseedRandomGenerator(long seed) {
        random.setSeed(seed);
    }
}
