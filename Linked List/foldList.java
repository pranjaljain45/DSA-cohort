/*
 * 1 2 3 4 5 6 7
 * 1 7 2 6 3 5 4
 */

import java.util.*;

public class foldList {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
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

        void fold() {
            left = head;
            foldHelper(head, 0);
        }

        Node left;

        void foldHelper(Node right, int idx) {
            if (right == null) {
                return;
            }

            foldHelper(right.next, idx + 1);

            if (idx > size / 2) {
                Node temp = left.next;
                left.next = right;
                right.next = temp;

                left = temp;
            } else if (idx == size / 2) {
                tail = right;
                tail.next = null;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        list.addValues(1);
        list.addValues(2);
        list.addValues(3);
        list.addValues(4);
        list.addValues(5);
        list.addValues(6);
        list.addValues(7);

        list.fold();

        list.display();

        sc.close();
    }
}
