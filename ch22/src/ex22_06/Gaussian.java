package ex22_06;

import java.util.Random;

public class Gaussian {
    
    private static final int TRIAL = 1000000;
    private static final double SCALE = 0.01;
    private static final double TERMINAL = 5.0;
    
    public void printDistribution() {
        Random random = new Random();
        final int SIZE = (int) (TERMINAL / SCALE);
        int[] counts = new int[SIZE * 2];
        for (int i = 0; i < TRIAL; i++) {
            double d = random.nextGaussian();
            int val = (int) (d / SCALE);
            if (val < -SIZE) {
                counts[0]++;
            } else if (val > SIZE) {
                counts[counts.length - 1]++;
            } else {
                counts[SIZE + val]++;
            }
        }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("% .2f ", -TERMINAL + SCALE * i);
            for (int j = 0; j < counts[i]; j += 100) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        Gaussian gaussian = new Gaussian();
        gaussian.printDistribution();
    }
}
