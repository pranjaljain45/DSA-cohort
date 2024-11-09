import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // enter num of elemnts
        int arr[] = new int[n]; // reate an array

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        // print array
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}