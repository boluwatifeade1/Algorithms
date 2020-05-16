import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n;i++){
            dp[i] = dp[i - 1] + 1;
            if( i % 2 == 0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if( i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if(dp[n] == dp[n-1]+1){
                n = n-1;
            }
            else if((n % 2 == 0) && dp[n] == dp[n/2]+1){
                n = n/2;
            }
            else if((n % 3 == 0) && dp[n] == dp[n/3]+1){
                n = n/3;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

