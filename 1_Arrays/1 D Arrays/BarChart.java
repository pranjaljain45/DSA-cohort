import java.util.*;

public class barChart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // last val of the barchart

        int limit = arr[0];
        for (int val : arr) {
            limit = Math.max(limit, val);
        }

        // print barchart

        for (int i = limit; i > 0; i--) {
            for (int j : arr) {
                if (j >= i) {
                    System.out.print('*' + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
