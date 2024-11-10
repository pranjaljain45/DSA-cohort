import java.util.*;

public class SumOfTwoArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1st array
        
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }

        // 2nd array
        
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }

        // final sum array
        
        int n = n1 > n2 ? n1 : n2;
        int[] arr = new int[n];

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = arr.length - 1;

        int carry = 0;     
        
        while (k >= 0) {
            int add = carry;

            if (i >= 0) {
                add += a1[i];
            }
            if (j >= 0) {
                add += a2[j];
            }

            carry = add / 10;
            add = add % 10;

            arr[k] = add;
            i--;
            j--;
            k--;
        }

        if (carry != 0) {
            System.out.print(carry + " ");
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
