import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    sequence.add(1);
    sequence.add(1);
    for (int i = 2 ; i <= n ; i++) {
      int value = sequence.get(i-1) + sequence.get(i-2);
      sequence.add(value);
    }
    return sequence.get(n-1);
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
