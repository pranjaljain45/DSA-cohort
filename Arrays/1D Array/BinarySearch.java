//array should be sorted

import java.util.*;

public class binarySearch {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int start = 0;
        int end = arr.length - 1;

        int idx = -1; // if not found
        
        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                idx = mid;
                break;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(idx);

        sc.close();

    }
}
