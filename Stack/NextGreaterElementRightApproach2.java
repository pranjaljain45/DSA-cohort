/*
 * ek number ke right me usse pass wala array me bda nummber
 */

import java.util.*;

public class nextGreaterElementRight {

    static int[] solve(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];

        Stack<Integer> nums = new Stack<>();

        nums.push(0);

        for (int i = 1; i < n; i++) {
            while (nums.size() > 0 && arr[nums.peek()] < arr[i]) {
                int pos = nums.peek();
                newArr[pos] = arr[i];
                nums.pop();
            }
            nums.push(i);
        }

        while (nums.size() > 0) {
            int pos = nums.peek();
            newArr[pos] = -1;
            nums.pop();
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] a = solve(arr);

        for (int i : a) {
            System.out.print(i + " ");
        }

        sc.close();

    }
}
