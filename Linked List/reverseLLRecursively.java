import java.util.*;

public class reverseLLRecursively {

    public static class Node {
        int data;
        Node next;
    }

    public static class reverseLL {

        Node head;
        Node tail;
        int size;

        void addValues(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        void reverse(Node node) {
            if (node == null) {
                return;
            }

            reverse(node.next);

            if (node == tail) {

            } else {
                node.next.next = node;
            }
        }

        void reverseRecursively() {
            reverse(head);

            head.next = null;

            Node temp = head;
            head = tail;
            tail = temp;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        reverseLL list = new reverseLL();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addValues(val);
        }

        list.reverseRecursively();

        list.display();

        sc.close();
    }

}
