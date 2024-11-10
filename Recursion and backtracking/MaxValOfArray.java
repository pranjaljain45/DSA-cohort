import java.util.*;

public class maxValOfArray {

    static int findMax(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int maxi = findMax(arr, idx + 1);
        int max = Math.max(maxi, arr[idx]);

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0;

        System.out.print(findMax(arr, idx));
        
        sc.close();
    }
}
