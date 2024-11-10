import java.util.*;

public class findIdx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt(); // target value

        int idx = -1; // target element present hi nahi hai

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                idx = i;
            }
        }

        System.out.println(idx); // print idx
    }
}
