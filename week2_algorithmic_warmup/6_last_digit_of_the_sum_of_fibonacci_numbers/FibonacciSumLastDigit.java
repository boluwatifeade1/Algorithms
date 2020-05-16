import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;
        long runTime = n%60;
        if (runTime <= 1){
            return runTime;
        }
        for (long i = 2; i <= runTime; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum += current;
            sum = sum%10;
        }

        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

