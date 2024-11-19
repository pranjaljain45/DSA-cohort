/*
 * PUSH : add data agar space availabe hai vrna stack overflow
 * POP : remove and return data if available or print underflow + return -1
 * TOP : return peek data if available or stack underflow + return -1
 * SIZE : return count of elements
 * DISPLAY : print stack in LIFO order
 */

/*
 * jab data.length - 1 pr toss ajaye toh size stack ka inc ho jaye
 */
import java.util.*;

public class buildStack {

    public static class dynamicStack {
        int[] data;
        int tos; // traverse stack idx

        public dynamicStack(int cap) { // size of stack
            data = new int[cap];
            tos = -1; // yani stack empty hai
        }

        // add values to the stack
        void push(int val) {
            if (tos == data.length - 1) {

                int[] newData = new int[2 * data.length];

                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }

                data = newData; // point karega new array ko

                tos++;
                data[tos] = val;

            } else {
                tos++;
                data[tos] = val;
            }
        }

        // print stack size
        int size() {
            return tos + 1;
        }

        // print stack
        void display() {
            for (int v : data) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // remove val from the stack one by one
        int pop() {
            if (tos == -1) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                // System.out.println("tos" + tos);
                int val = data[tos];
                tos--;
                return val;
            }
        }

        // print peek val of the satck
        int top() {
            if (tos == -1) {
                System.out.print("Stack underflow");
                return -1;
            } else {
                return data[tos];
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dynamicStack s1 = new dynamicStack(n);

        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        s1.push(60);
        s1.push(70);
        s1.push(80);

        s1.display();
        System.out.println(s1.size());
        System.out.println(s1.pop());
        System.out.println(s1.top());

        sc.close();
    }
}
