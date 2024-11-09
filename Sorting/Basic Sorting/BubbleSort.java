/*
 * push MAX ele at the end of the array by doing ADJACENT SWAP
 * time complexity : O(n^2)
 * 
 * if array sorted : time complexity : O(n) kyuki if wali condition work hi nahi karegi
 */

 import java.util.*;

 public class BubbleSort {
  
     public static void main(String[] args) {
      
         Scanner sc = new Scanner(System.in);
 
         int n = sc.nextInt(); // enter num of elemnts
      
         int arr[] = new int[n]; // reate an array
 
         for (int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
         }
 
         // BUBBLE SORT
 
         // har barr LAST ele apni correct pos pr ja rha hai isliye loop wha tak nahi
         // jayegi
 
         for (int i = n - 1; i > 0; i--) {
             for (int j = 0; j < i; j++) {
                 if (arr[j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                 }
             }
         }
 
         // print array
         for (int i : arr) {
             System.out.print(i + " ");
         }
 
         sc.close();
     }
 }
