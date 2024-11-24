// ITERATIVE APPROACH


import java.util.*;

public class KthNodeFromEnd {

    public static class Node {
        int data;
        Node next;
    }

    public static class Kth {

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

        int getKthValue(int k) {
            Node slow = head;
            Node fast = head;

            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Kth list = new Kth();

        list.addValues(2);
        list.addValues(3);
        list.addValues(4);
        list.addValues(5);

        System.out.println(list.getKthValue(0));

        sc.close();
    }
}
