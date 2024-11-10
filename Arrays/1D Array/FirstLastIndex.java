// target value ki phli occurence ke according kaam karega
// fisrt & last idx of a continously repeated value 

import java.util.*;

public class FirstLastIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt(); // search value

        int start = 0;
        int end = arr.length - 1;

        // value not exists
        int fi = -1;
        int li = -1;

        // find first idx

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                fi = mid;
                end = mid - 1; // mid se phle khi value mil jaye
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = arr.length - 1;
        // find last idx
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                li = mid;
                start = mid + 1; //mid se aage kisi index pr value mil jaye
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(fi + " " + li);

        sc.close();
    }

}
