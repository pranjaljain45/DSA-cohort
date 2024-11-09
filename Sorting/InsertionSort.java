
/*
 * pick an ele and usko shi pos pr rakh do LEFT COMPARE KARTE HUYE
 * time complexity : O(n^2)
 * if array is sorted , time complexity : O(n)
 */
import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // enter num of elemnts
        int arr[] = new int[n]; // reate an array

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // INSERTION SORT

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {/*
                                                   * jab j = 0 : loop me eneter nahi hoga ||
                                                   * j > 0 : last compare tbh hoga jab j = 1 and j - 1 = 0
                                                   */
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        // print array
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
