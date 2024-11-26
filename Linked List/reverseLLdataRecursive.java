/*
 * left : traverse start to end
 * right : traverse end to start
 * floor : check karega ki swap krna hai ki nahi (swap mid tak hi hoga)
 */

import java.util.*;

public class reverseLLdataRecursive {

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

        void reverseHelper(Node right, int floor) {
            if (right == null) {
                return;
            }

            reverseHelper(right.next, floor + 1);

            if (floor >= size / 2) {
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }
            
            left = left.next;
        }

        Node left;

        void reverse() {
            left = head;
            reverseHelper(head, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        reverseLL list = new reverseLL();

        list.addValues(10);
        list.addValues(20);
        list.addValues(30);
        list.addValues(40);
        list.addValues(50);

        list.reverse();

        list.display();

        sc.close();
    }
}
