import java.util.*;

public class LinkedListtoQueue {

    public static class LLQueueAdapter {

        LinkedList<Integer> list; // define linked list

        public LLQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() {
            return list.size(); // size of linked list
        }

        void push(int val) {
            list.addLast(val); // adding values
        }

        int top() {
            if (list.size() == 0) {
                return -1; // Indicate queue is empty
            } else {
                return list.getFirst(); // Return the top element without removing it
            }
        }

        int pop() {
            if (list.size() == 0) {
                return -1; // Indicate queue is empty
            } else {
                return list.removeFirst(); // Remove and return the top element
            }
        }

        void display() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LLQueueAdapter stack = new LLQueueAdapter();

        stack.push(10);
        stack.push(20);

        stack.display();

        System.out.println("Stack size: " + stack.size()); // should return 2
        System.out.println("Top element: " + stack.top()); // Should print 20
        System.out.println("Popped element: " + stack.pop()); // Should print 20

        sc.close();
    }
}
