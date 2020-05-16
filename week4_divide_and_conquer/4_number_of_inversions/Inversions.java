import java.util.*;

public class Inversions {
    private static long mergeSort(int[] array, int left, int right){
        if (right <= left){
            return 0;
        }
        long numberOfInversions = 0;
        int mid = (right + left)/2;
        numberOfInversions += mergeSort(array, left , mid);
        numberOfInversions += mergeSort(array , mid+1, right);
        numberOfInversions += merge(array, left , right);
        return numberOfInversions;
    }
    private static long merge(int[] array, int left, int right){
        long numberOfInversions = 0;
        int[] mergeArray = new int[right - left +1];
        int mid = (right + left)/2;
        int i = left;
        int j = mid + 1;
        int cur = 0;
        while(i <= mid && j<= right){
            if (array[i] > array[j]){
                mergeArray[cur++] = array[j++];
                numberOfInversions += mid -i + 1;
            }
            else {
                mergeArray[cur++] = array[i++];
            }
        }
        while(i <= mid){
            mergeArray[cur++] = array[i++];
        }
        while(j <= right){
            mergeArray[cur++] = array[j++];
        }
        System.arraycopy(mergeArray,0,array,left,right-left+1);
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(mergeSort(a,0, a.length-1));
    }
}

