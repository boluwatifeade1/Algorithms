import java.util.Scanner;
import java.util. *;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[][] valuesWeights = new double[values.length][2];
        for (int i = 0; i < values.length; i++) {
            valuesWeights[i] = new double[] {(double) values[i]/weights[i], weights[i]};
        }
        Arrays.sort(valuesWeights, Collections.reverseOrder(Comparator.comparingDouble(a -> a[0])));
        // System.out.println(Arrays.deepToString(valuesWeights));
        int i = 0;
        while (capacity > 0 && i < values.length){
            double amount =  Math.min(valuesWeights[i][1],capacity); 
            value += amount *(valuesWeights[i][0]);
            capacity -= amount;
            i+=1;
        }
        int dp = 4;
        double pow10 = Math.pow(10,dp);
        return (double) Math.round(value*pow10)/pow10;
        // 3 50 60 20 100 50 120 30
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
