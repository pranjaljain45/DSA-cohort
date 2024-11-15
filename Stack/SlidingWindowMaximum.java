import java.util.*;

public class slidingWindowMaximum {

    static void maximumValue(int[] arr, int k) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] nextGreater = new int[n]; // right greater element idx

        st.push(n - 1);
        nextGreater[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                nextGreater[i] = n;
            } else {
                nextGreater[i] = st.peek();
            }

            st.push(i);
        }

        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if (j < i) {
                j = i;
            }
            while (nextGreater[j] < i + k) { // jabtak next greater uss window me hai j ko update jab nahi hoga print
                j = nextGreater[j];
            }
            System.out.print(arr[j] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        maximumValue(arr, k);

        sc.close();
    }
}
