package ex22_01;

public class FPFormatter {
    public void printFPs(double[] doubles, int colum) {
        if (colum < 1) { 
            throw new IllegalArgumentException();
        }
        for(double d : doubles) {
            System.out.printf("% ." + colum + "e%n", d);
        }
    }
    
    public static void main(String[] args) {
        double[] data = {
                Math.PI,
                Math.E,
                Math.log(Math.random()) / 10,
                Math.cos(Math.random()) * 1000,
                Math.random() * Math.random()
                };
        FPFormatter fpFormatter = new FPFormatter();
        fpFormatter.printFPs(data, 13);
        
    }
    
}
