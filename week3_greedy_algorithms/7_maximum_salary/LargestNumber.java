import java.util.*;
import java.lang.*;

public class LargestNumber {
    private static int compares(String a, String b) {
        String first = a.substring(0,1);
        String Second = b.substring(0,1);
        if( Integer.parseInt(first) > Integer.parseInt(Second)){
            return 1;
        } else if (Integer.parseInt(first) == Integer.parseInt(Second)) {
            int initial = a.length();
            int latter = b.length();
            int prop;
            if ( initial >= latter){
                prop = latter;
            } else {
                prop = initial;
            }
            int val = Integer.parseInt(a.substring(0,prop)) - Integer.parseInt(b.substring(0,prop));
            if (val > 0){
                return 1;
            } else if(val == 0){
                if (initial > latter) {
                    return compares(a.substring(prop),b);
                } else if (latter > initial) {
                    return compares(a,b.substring(prop));
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    private static String largestNumber(String[] a) {
        Arrays.sort(a, Collections.reverseOrder(new Comparator<String>() {
            public int compare (String e, String d) {
                if (compares(e,d) == 1){
                    return 1;
                } 
                return -1;
            }
        }));
        String result = a[0];
        for (int i = 1; i < a.length; i++){
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

