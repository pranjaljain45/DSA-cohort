import java.util.*;

public class targetSumSubset {

    static void sumSubset(int[] arr, int idx, String set, int sum, int target) {

        if (idx == arr.length) {
            if (sum == target) {
                System.out.println(set);
            }
            return;
        }

        sumSubset(arr, idx + 1, set + arr[idx], sum + arr[idx], target); // num add hoga
        sumSubset(arr, idx + 1, set, sum, target); // num add nahi hoga

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int[] arr = new int[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        sumSubset(arr, 0, "", 0, target);

        sc.close();
    }

}
