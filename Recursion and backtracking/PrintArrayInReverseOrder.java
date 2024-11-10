import java.util.*;

public class printArrayinRevOrder {

    static void printValues(int[] arr, int lastIdx) {
        if (lastIdx < 0) {
            return;
        }

        System.out.print(arr[lastIdx]);
        
        printValues(arr, lastIdx - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int lastIdx = arr.length - 1;

        printValues(arr, lastIdx);

        sc.close();
    }
}
