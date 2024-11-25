import java.util.*;

public class stackTOqueue {

    public static class stackQueue {

        Stack<Integer> st;
        Stack<Integer> helpSt;

        public stackQueue() {
            st = new Stack<>();
            helpSt = new Stack<>();
        }

        void add(int val) {
            st.push(val);
        }

        int size() {
            return st.size();
        }

        int top() {
            if (st.size() == 0) {
                System.out.println("Stack is underflow");
                return -1;
            } else {
                while (st.size() > 1) {
                    helpSt.push(st.pop());
                }

                int val = st.pop();

                helpSt.push(val);

                while (helpSt.size() > 0) {
                    st.push(helpSt.pop());

                }

                return val;
            }
        }

        int remove() {
            if (st.size() == 0) {
                System.out.println("Stack is underflow");
                return -1;
            } else {
                while (st.size() > 1) {
                    helpSt.push(st.pop());
                }

                int val = st.pop();

                while (helpSt.size() > 0) {
                    st.push(helpSt.pop());

                }

                return val;
            }
        }

        void display() {
            System.out.println(st);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        stackQueue stq = new stackQueue();

        stq.add(10);
        stq.add(20);
        stq.add(30);
        stq.add(40);
        stq.add(50);

        System.out.println(stq.size());
        System.out.println(stq.top());
        System.out.println(stq.remove());

        stq.display();

        sc.close();
    }

}
