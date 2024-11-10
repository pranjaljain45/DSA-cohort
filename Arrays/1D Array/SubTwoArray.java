// larger array in size - smaller array in size
// n1 > n2

import java.util.*;

public class subTwoArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // larger array
        int n1 = sc.nextInt();
        int[] larArr = new int[n1];

        for (int i = 0; i < n1; i++) {
            larArr[i] = sc.nextInt();
        }

        // smaller array
        int n2 = sc.nextInt();
        int[] smallArr = new int[n2];

        for (int i = 0; i < n2; i++) {
            smallArr[i] = sc.nextInt();
        }

        // result array
        int n = n1;
        int[] arr = new int[n];

        int i = larArr.length - 1;
        int j = smallArr.length - 1;
        int k = arr.length - 1;

        int borrow = 0;

        while (k >= 0) {
            int sub = 0;

            int smallArrayVal = j >= 0 ? smallArr[j] : 0;

            if (larArr[i] + borrow >= smallArrayVal) {
                sub = larArr[i] + borrow - smallArrayVal;
                borrow = 0;
            } else {
                sub = larArr[i] + borrow + 10 - smallArrayVal;
                borrow = -1;
            }

            arr[k] = sub;
            k--;
            i--;
            j--;

        }

        int idx = 0;
        while (idx <= arr.length) {
            
            if (arr[idx] == 0) {
                idx++;
            } else {
                break;
            }
        }

        while (idx < arr.length) {
            System.out.print(arr[idx] + " ");
            idx++;
        }

        sc.close();
    }
}
