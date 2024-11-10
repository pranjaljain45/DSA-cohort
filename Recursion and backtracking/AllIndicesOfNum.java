// target value jin jin index pr hai un sab index ko array ke from me return krna hai

import java.util.*;

public class allIndicesOfNum {

    static int[] allIndices(int[] arr, int target, int idx, int count) {
        if (idx == arr.length) {
            return new int[count];
        }

        if (arr[idx] == target) {
            int idxArray[] = allIndices(arr, target, idx + 1, count + 1);
            idxArray[count] = idx;
            return idxArray;
        } else {
            int[] idxArray = allIndices(arr, target, idx + 1, count);
            return idxArray;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int idx = 0;
        int count = 0;

        int[] result = allIndices(arr, target, idx, count);

        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
