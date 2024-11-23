/*
 * odd : mid
 * even : first half ka end element
 */

import java.util.*;

public class MiddleOfLL {

    public static class Node {
        int data;
        Node next;
    }

    public static class middle {

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

        int getMiddleVal() {

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow.data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        middle list = new middle();

        list.addValues(2);
        list.addValues(3);
        list.addValues(4);
        list.addValues(5);
        list.addValues(6);

        System.out.println(list.getMiddleVal());

        sc.close();
    }
}
