import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int count = 0;
        while ( m > 0) {
            if ( m >= 10) {
                count += 1;
                m -= 10;
            }
            else if ( m >= 5){
                count += 1;
                m -= 5;
            }
            else if ( m >= 1){
                count += 1;
                m -= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

