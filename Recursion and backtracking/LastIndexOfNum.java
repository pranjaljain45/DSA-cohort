import java.util.*;

public class LastIndexnum {

    static int FindIdx(int[] arr, int target, int idx) {
        if (idx == arr.length) {
            return -1;
        }

        int last = FindIdx(arr, target, idx + 1);
        if (last == -1) {
            if (arr[idx] == target) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return last;
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
        System.out.print(FindIdx(arr, target, idx));

        sc.close();
    }
}
