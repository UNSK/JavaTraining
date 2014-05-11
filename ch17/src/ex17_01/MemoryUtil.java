package ex17_01;

import java.util.LinkedList;

public class MemoryUtil {

    public static void main(String[] args) {
        printFreeMemory();
        LinkedList<Double> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Double(i));
        }
        
        printFreeMemory();
        
        Runtime.getRuntime().gc();
        
        printFreeMemory();
    }

    public static void printFreeMemory() {
        long mem = Runtime.getRuntime().freeMemory();
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("Free memory: " + mem);
        System.out.printf("Usage: %1.3f\n", ((double) mem / (double) total));
    }
}
