/*
 * ek number ke right me usse pass wala array me bda nummber
 */

import java.util.*;

public class nextGreaterElementRight {

    static int[] solve(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];

        Stack<Integer> num = new Stack<>();

        num.push(arr[n - 1]);

        newArr[newArr.length - 1] = -1; // last element se bde koi element nahi hota uske right pr

        for (int i = n - 2; i >= 0; i--) {
            while (num.size() > 0 && arr[i] >= num.peek()) {
                num.pop();
            }
            if (num.size() == 0) {
                newArr[i] = -1;
            } else {
                newArr[i] = num.peek();
            }
            num.push(arr[i]);
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
