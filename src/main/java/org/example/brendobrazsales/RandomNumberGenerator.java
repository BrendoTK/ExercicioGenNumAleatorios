package org.example.brendobrazsales;

public interface RandomNumberGenerator {
    double[] generateNumbers(int count);

    // Adicione este método para permitir que as subclasses redefinam a seed
    void reseedRandomGenerator(long seed);
}
