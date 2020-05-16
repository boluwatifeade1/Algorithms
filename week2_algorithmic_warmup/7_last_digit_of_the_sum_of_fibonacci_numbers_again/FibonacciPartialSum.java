import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1){
            if(n<0){
                return 0;
            }
            return n;
        }
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
        }
        return sum%10;
    }
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long first = getFibonacciSumNaive(from-1);
        long second = getFibonacciSumNaive(to);
        // System.out.println(getFibonacciSumNaive(1));
        long sum = (second+10) -first;
        return sum%10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

