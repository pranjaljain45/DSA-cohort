//application of binary search

//sorted array

// if value present, ceil = floor = value
/*if absent , ceil - search value se just bda element and 
floor - search value se just chota element
*/

import java.util.*;

public class ceilFloor {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt(); // search value

        int start = 0;
        int end = arr.length - 1;

        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (target == arr[mid]) {
                ceil = arr[mid];
                floor = arr[mid];
                break; // Exit loop when exact match is found
            } 
            else if (target < arr[mid]) {
                end = mid - 1;
                ceil = arr[mid]; // current mid could be the ceil
            } 
            else {
                start = mid + 1;
                floor = arr[mid]; // current mid could be the floor
            }
        }
        
        System.out.print(floor + " " + ceil);

        sc.close();
    }
}
