import java.util.*;

public class printArray {

    static void printValue(int[] arr, int lastIdx) {
        if (lastIdx < 0) {
            return;
        }

        printValue(arr, lastIdx - 1);
        System.out.println(arr[lastIdx]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int lastIdx = n - 1;
        printValue(arr, lastIdx);
        sc.close();
    }
}
