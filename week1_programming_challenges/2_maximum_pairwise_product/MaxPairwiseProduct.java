import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;
        int firstNumber = numbers[0];
        int secondNumber = numbers[1];
        int[] dummy = {firstNumber, secondNumber};
        for (int i=2; i<n; i++) {
            if(numbers[i] > dummy[0]) {
                int temp = dummy[0];
                dummy[0] = numbers[i];
                if(temp > dummy[1]){
                    dummy[1] = temp;
                }
            } else if (numbers[i] > dummy[1]){
                dummy[1] = numbers[i];
            }
        }
        return long (long)(dummy[0]*dummy[1]);
        // return long res = ((long) dummy[0]) * dummy[1];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
