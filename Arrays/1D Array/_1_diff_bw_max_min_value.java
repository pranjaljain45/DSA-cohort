import java.util.*;

public class _1_diff_bw_max_min_value {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // size of an array
        int[] arr = new int[n]; // declare array

        for (int i = 0; i < n; i++) { // enter array
            arr[i] = sc.nextInt();
        }

        int max = arr[0]; // declare max value
        int min = arr[0];// declare min value
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]); // compare
            min = Math.min(min, arr[i]); // compare
        }

        System.out.println(max - min);
        sc.close();
    }
}