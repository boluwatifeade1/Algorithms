import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;
            
        long previous = 0;
        long current  = 1;

        for (int i = 2; i <= n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

