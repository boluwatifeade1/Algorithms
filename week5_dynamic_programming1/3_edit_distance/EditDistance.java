import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int row = s.length();
    int col = t.length();
    int[][] dp = new int[row+ 1][col+1];
    for(int i = 0; i <= row; i++){
      dp[i][0] = i;
    }
    for(int j = 0; j <= col; j++){
      dp[0][j] = j;
    }
    for (int i = 1; i<=row;i++){
      for(int j =1;j<=col;j++){
        if(s.charAt(i-1) == t.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }
        else{
          int insert = dp[i][j-1];
          int deletion = dp[i - 1][j];
          int replacement = dp[i-1][j-1];
          dp[i][j] = 1 + Math.min(insert, Math.min(deletion,replacement));
        }  
      }
    }
    return dp[row][col];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
