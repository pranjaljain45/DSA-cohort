//divide + merge
/* divide the array into the smallest single element then merge them
* 
* suppose array of 5 elements
* isko do part me divide karenge lets 3(left half) and 2(right half)
* left half 3 ko 2 & 1
* phir 2 ko 1 & 1
* 
* right half 2 ko 1 & 1
* 
* phir last divide krne ke baad sare ek INDIVIDUAL ARRAY me convert ho jayenge
* aur division me HYPOTHETICAL ARRAY banegi
* phir unhe COMPARE karenge and MERGE karenge
* 
* SORT LEFT AND RIGHT HALF
* upper se neevhe tak divide neeche se upper tak merge
*/

// NOTE
// odd no of elements ke case me array ko sabse phle jis trh se divide karenge vaise hi aage karenge

// AFTER RIGHT AND LEFT ARRAY GET SORTED
/*TWO POINTER APPROACH
* ek pointer on left array and another on right array
* then compare each idx element and PUT them in NEW ARRAY OF PREV UNSORTED ARRAY SIZE
* AGAR kisi part ke element nahi reh gye toh dusri array ke sare elements as it is arrange ho jayenge
*/


import java.util.*;

public class MergeSort {

    public static void merge(int arr[], int low, int mid, int high) { // mid isliye kyuki righr array mid + 1 se start hoti hai

        ArrayList<Integer> temp = new ArrayList<>(); // temporary store all elements in sorted order
        int left = low; // LEFT array ka first idx
        int right = mid + 1; // RIGHT array ka first idx

        // merging

        // mid is the LAST IDX of LEFT array

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // jab LEFT array me elements reh jaye

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // jab RIGHT array me elements reh jaye

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // TEMP ARRAY KE ELEMNTS KO ARRAY ME SHIFT KRNA

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low); /* i - low : har bar hum ek particular section ko merge kr rhe hai and arrange kr rhe hai unke idx pr*/
        }
    }

    // har bar COMPLETE ARRAY PASS hogi

    /*
     * LOW = phle idx hypothetical array
     * HIGH = last idx hai hypothetical array
     */

    public static void divideArray(int arr[], int low, int high) {

        if (low >= high) { // jab signle element array reh jayegi tbh uska idx same hoga
            return;
        }

        int mid = (low + high) / 2; // kis idx se array divide hogi

        divideArray(arr, low, mid); // left array
        divideArray(arr, mid + 1, high); // right array
        merge(arr, low, mid, high); // merge sorted array
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

        // calling divide function
        
        divideArray(arr, 0, n - 1);

        //print array
        
        for (int val : arr) {
            System.out.print(val + " ");
        }

        sc.close();

    }
}

//TIME COMPLEXITY : O(nlogn)

//har step pr array size is divide by 2

//SPACE COMPLEXITY : O(n)

// kuki temp array ka use kr rhe hai
