/*
 * PUSH : add data agar space availabe hai vrna stack overflow
 * POP : remove and return data if available or print underflow + return -1
 * TOP : return peek data if available or stack underflow + return -1
 * SIZE : return count of elements
 */

import java.util.*;

public class buildStack {

    public static class minimumStack {

        Stack<Integer> allData;
        Stack<Integer> minData;

        public minimumStack() { // size of stack
            allData = new Stack<>();
            minData = new Stack<>();
        }

        // add values to the stack
        void push(int val) {
            allData.push(val);

            if (minData.size() == 0 || minData.peek() >= val) {
                minData.push(val);
            }
        }

        // print stack size
        int size() {
            return allData.size();
        }

        // remove val from the stack one by one
        int pop() {
            if (allData.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                int val = allData.pop();

                if (val == minData.peek()) {
                    minData.pop();
                }
                
                return val;
            }
        }

        // print peek val of the satck
        int top() {
            if (allData.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }

        int min() {
            if (allData.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                return minData.peek();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        minimumStack s1 = new minimumStack();

        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);

        System.out.println(s1.size());
        System.out.println(s1.top());
        System.out.println(s1.pop());
        System.out.println(s1.min());

        sc.close();
    }
}
