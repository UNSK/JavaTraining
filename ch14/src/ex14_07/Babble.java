package ex14_07;

/**
 * 14.7 execute Babble several times and examine the results.
 */
public class Babble extends Thread {
    static boolean doYield;
    static int howOften;
    private String word;
    
    Babble(String whatTosay) {
        word = whatTosay;
    }
    
    public void run() {
        for (int i = 0; i < howOften; i++) {
            System.out.println(word);
            if (doYield) {
                Thread.yield();
            }
        }
    }
    
    /**
     * @param args arguments of this program
     *        args[0]: set true or false. Do (not) yield thread.
     *        args[1]: set integer. How many times do the threads run
     *        after args: set String. # of threads and what to say.
     */
    public static void main(String[] args) {
        doYield = new Boolean(args[0]).booleanValue();
        howOften = Integer.parseInt(args[1]);
        
        for (int i = 2; i < args.length; i++) {
            new Babble(args[i]).start();
        }
    }

}
