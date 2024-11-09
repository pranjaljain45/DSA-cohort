/*
 * pick the MINI ele aur usko first pos pr rakh do swap krte huye
 * time complexity : O(n^2)
 * if array is sorted , time complexity : O(n)
 */
import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // enter num of elemnts
        int arr[] = new int[n]; // reate an array

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // SELECTION SORT
        for (int i = 0; i < n; i++) {
            int mini = i; // mini ele ith idx pr hai
            for (int j = n - 1; j >= i; j--) {
                if (arr[mini] > arr[j]) {
                    mini = j; // update the mini ele idx
                }
            }

            // swap the the ith idx and mini idx ele
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }

        // print array
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}