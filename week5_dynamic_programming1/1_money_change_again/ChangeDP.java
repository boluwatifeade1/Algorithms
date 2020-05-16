import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] dp = new int[m+1];
        int[] coins = {1,3,4};
        dp[0] = 0;
        for (int i = 1; i < m+1; i++){
            dp[i] = m;
            for (int coin: coins){
                if(i - coin >=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
                
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

