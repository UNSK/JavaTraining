package ex22_05;
import java.util.Random;

public class Dice {
    
    private static final int TRIAL_NUM = 1000000;
    /** the sides of dice */
    private static final int SIDE = 6;
    private Random random = new Random();
    
    public int roll() {
        return random.nextInt(SIDE) + 1;
    }
    
    public void calcProbability(int diceNum) {
        if (diceNum < 1) {
            throw new IllegalArgumentException();
        }
        double[] counts = new double[diceNum * SIDE + 1];
        for (int i = 0; i < TRIAL_NUM; i++) {
            int sum = 0;
            for (int j = 0; j < diceNum; j++) {
                sum += this.roll();
            }
            counts[sum]++;
        }
        
        System.out.println("Actual: ");
        System.out.printf("Sum\tProbability%n");
        for (int i = diceNum; i < counts.length; i++) {
            System.out.printf("%d\t%.5f%n", i, counts[i] / TRIAL_NUM);
        }
    }
    
    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.calcProbability(3);
    }
}
