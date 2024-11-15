/*
 * left me next greater element aur jo element hai un dono ke idx ko diff
 */

import java.util.*;

public class stockSpan {

    static int[] findDifference(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int[] result = new int[arr.length];

        st.push(0);
        result[0] = 1; // 0th idx element ke aage koi element nahi

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                result[i] = i + 1; // left wale sare element chote hai
            } else {
                result[i] = i - st.peek(); // agar bda element mil gya
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] span = findDifference(arr);

        for (int val : span) {
            System.out.print(val + " ");
        }
        sc.close();
    }
}
