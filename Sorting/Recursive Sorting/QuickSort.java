// DIVIDE AND CONQUER

/*
 * PIVOT : ek pivot element vo array ka koi bhi element ho skta hai
 * LEFT SIDE : jo elements pivot element se chote honge unhe left me rakh denge
 * RIGHT SIDE : jo elements pivot element se bde honge unhe right me rakh denge
 */

/*
 * LOW : original array ka 1st idx
 HIGH : original array ka last idx

 TWO POINTER APPRAOCH
 pivot as arr[low]

 i,j

 i = low j = high 

 abh check karenge PIVOT ELEMENT ke sath ith and jth idx value ko
 ith idx se hum phli bdi value ko dhudhenge
 jth idx se hum phli chotti value ko dhudhenge
 mil jaye toh swap

 jab i > j yani ki i cross j
 tbh stop hoajyenge aur j ki value ko swap kr denge pivot value se

 pivot value apni correct pos pr hai aur act as PARTITION ELEMENT

 */

/*
 * PARTITION ELEMENT
 * 
 * partition ho jayega array me small element on left and large element on right side
 * 
 * new array low to partition -1  &&&&  partition + 1 to high
 * 
 * repeat the above steps
 * 
 */


import java.util.*;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) { // phle bda element from start array
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) { // phle chota element from end array
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place the pivot in the correct position

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void sort(int[] arr, int low, int high) {

        if (low < high) {
            int partitionIdx = partition(arr, low, high);

            sort(arr, low, partitionIdx - 1);
            sort(arr, partitionIdx + 1, high);
        }
    }

    public static int[] qs(int[] arr) {

        sort(arr, 0, arr.length - 1);

        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        // enter array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println();

        // call function
        qs(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }

        sc.close();

    }
}


/*
 * TIME COMPLEXITY : O(nlogn)
 * 
 */

/*
 * SPACE COMPLEXITY : O(1)
 */




