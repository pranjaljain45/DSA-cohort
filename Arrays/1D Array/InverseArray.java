// values of array should be < arr size - 1 kyuki 0 bases idx hota hai

import java.util.*;

public class inverseArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] invArr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            invArr[val] = i;
        }

        for (int val : invArr) {
            System.out.print(val + " ");
        }
        
        sc.close();

    }
}
