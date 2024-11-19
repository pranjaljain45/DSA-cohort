/*
 * PUSH : add data agar space availabe hai vrna stack overflow
 * POP : remove and return data if available or print underflow + return -1
 * TOP : return peek data if available or stack underflow + return -1
 * SIZE : return count of elements
 * DISPLAY : print stack in LIFO order
 */

/*
 * CONSTANT SPACE AND TIME
 */

import java.util.*;

public class buildStack {

    public static class minimumStack {

        Stack<Integer> data;
        int min;

        public minimumStack() { // size of stack
            data = new Stack<>();
        }

        // add values to the stack
       
        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                data.push(val + val - min); /*
                                             * push fake valuee jab min se choti value ajayee
                                             * aur satck me min se choti val store hogi aur idea lg jaye kab min val
                                             * change huyi
                                             */
                min = val;
            }
        }

        // print stack size

        int size() {
            return data.size();
        }

        // remove val from the stack one by one

        int pop() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                if (data.peek() >= min) {
                    return data.pop();
                } else {
                    int v = min;
                    min = 2 * min - data.pop();
                    return v;
                }
            }
        }

        // print peek val of the stack

        int top() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else if (data.peek() >= min) {
                return data.peek();
            } else {
                return min;
            }
        }

        int min() {
            if (data.size() == 0) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        minimumStack s1 = new minimumStack();

        s1.push(20);
        s1.push(30);
        s1.push(4);
        s1.push(50);

        System.out.println(s1.size());
        System.out.println(s1.top());
        System.out.println(s1.pop());
        System.out.println(s1.min());

        sc.close();
    }
}
