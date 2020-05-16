import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int row = a.length;
        int col = b.length;
        int grid = c.length;
        int[][][] dp = new int[row+1][col+1][grid+1];
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                for(int k=1; k<=grid; k++){
                    if((a[i-1] == b[j-1]) && (b[j-1] == c[k-1])){
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                    }
                    else {
                        dp[i][j][k] = Math.max(dp[i][j][k - 1], Math.max(dp[i - 1][j][k], dp[i][j - 1][k]));
                    }
                }
            }
        }
        return dp[row][col][grid];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

