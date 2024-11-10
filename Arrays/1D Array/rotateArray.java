import java.util.*;

public class rotateArray {

    public static void reverse(int[] arr, int i, int j) {

        int start = i;
        int end = j;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int r = sc.nextInt(); // times rotate krna hai

        if (r < 0) {
            r += arr.length;
        } else if (r >= arr.length) {
            r %= arr.length;
        }

        reverse(arr, 0, arr.length - r - 1);
        reverse(arr, arr.length - r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
