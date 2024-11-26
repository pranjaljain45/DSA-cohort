/*
 * tos1 : -1 , left to right stack ko fill karega
 * tos2 : a.l , right to left stack ko fill karega
 * 
 * pr dono mil kar a.l tak hi fill karenge
 *
*/

import java.util.*;

public class twoStacksinArray {

    public static class stacksinArray {
        int[] arr;
        int tos1;
        int tos2;

        public stackinArray(int size) {
            arr = new int[size];
            tos1 = -1;
            tos2 = arr.length;
        }

        void add1(int val) {
            if (tos1 == tos2 - 1) {
                System.out.println("Array is overflow");
            } else {
                tos1++;
                arr[tos1] = val;
            }
        }

        void add2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Array is overflow");
            } else {
                tos2--;
                arr[tos2] = val;
            }
        }

        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return arr.length - tos2;
        }

        int top1() {
            if (size1() == 0) {
                System.out.println("Array is underflow");
                return -1;
            } else {
                return arr[tos1];
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Array is underflow");
                return -1;
            } else {
                return arr[tos2];
            }
        }

        int remove1() {
            if (size1() == 0) {
                System.out.println("Array is underflow");
                return -1;
            } else {
                int val = arr[tos1];
                tos1--;
                return val;
            }

        }

        int remove2() {
            if (size2() == 0) {
                System.out.println("Array is underflow");
                return -1;
            } else {
                int val = arr[tos2];
                tos2++;
                return val;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        stackinArray arr = new stackinArray(n);

        arr.add1(10);
        arr.add1(20);
        arr.add1(30);

        arr.add2(10);
        arr.add2(20);

        System.out.println(arr.size1());
        System.out.println(arr.size2());

        System.out.println(arr.top1());
        System.out.println(arr.top2());

        System.out.println(arr.remove1());
        System.out.println(arr.remove2());

        sc.close();
    }
}
