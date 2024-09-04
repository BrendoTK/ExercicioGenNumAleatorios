import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.example.brendobrazsales.RandomAdapter;
import org.example.brendobrazsales.RandomNumberGenerator;
import org.example.brendobrazsales.RealDistributionAdapter;

public class Principal {
    public static void main(String[] args) {
        final long seed = 123;

        RandomNumberGenerator normalRandom = new RealDistributionAdapter(new NormalDistribution());
        ((RealDistributionAdapter) normalRandom).reseedRandomGenerator(seed);

        RandomNumberGenerator logNormalRandom = new RealDistributionAdapter(new LogNormalDistribution());
        ((RealDistributionAdapter) logNormalRandom).reseedRandomGenerator(seed);

        RandomNumberGenerator random = new RandomAdapter(seed);

        final int TOTAL_NUMEROS = 4;
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            double[] normalNumbers = normalRandom.generateNumbers(12);
            double[] logNormalNumbers = logNormalRandom.generateNumbers(1);
            double[] randomNumbers = random.generateNumbers(1);

            System.out.println("Número aleatório seguindo distribuição Normal usando biblioteca Apache Commons Math: " + normalNumbers[0]);
            System.out.println("Número aleatório seguindo distribuição Log-Normal usando biblioteca Apache Commons Math: " + logNormalNumbers[0]);
            System.out.println("Número aleatório seguindo distribuição Uniforme usando classe Random: " + randomNumbers[0]);
            System.out.println();
        }
    }
}
