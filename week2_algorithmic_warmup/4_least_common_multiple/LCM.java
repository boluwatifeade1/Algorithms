import java.util.*;

public class LCM {

  private static int gcd_naive(int a, int b) {
    if (b == 0){
      return a;
    }
    return gcd_naive(b,a%b);
  }

  private static long lcm_naive(int a, int b) {
    int gcd = gcd_naive(a, b);
    if(gcd == 1){
      return (long) a * b;
    } else {
      return (long) a*b/gcd;
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(lcm_naive(a, b));
  }
}
