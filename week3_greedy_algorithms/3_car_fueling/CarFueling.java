import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int currentRefill = 0;
        int capacity = tank;
        if ((dist - stops[stops.length-1]) > tank){
            return -1;
        }
        while (true) {
            if (tank >= dist){
                return numRefills;
            }
            int lastRefill = currentRefill;
            while (currentRefill <= stops.length - 1){
                if (stops[currentRefill] <= tank) {
                    currentRefill+=1;
                }
                else {
                    break;
                }
            }
            numRefills+=1;
            tank = stops[currentRefill - 1]+capacity;
            if (lastRefill == currentRefill){
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
