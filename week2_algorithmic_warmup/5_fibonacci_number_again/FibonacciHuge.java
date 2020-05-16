import java.util.*;

public class FibonacciHuge {
    private static long pisano(long m){
        long length = 0;
        long previous = 0;
        long current = 1;
        boolean loop = true;
        while(loop) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
            length+=1;
            if(previous == 0 && current == 1){
                loop = false;
            }
        } 
        return length;
    }
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;
        long pisanoLength = pisano(m);
        long runTime = n%pisanoLength;
        if(runTime <= 1){
            return runTime;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= runTime; i++){
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
        }
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

