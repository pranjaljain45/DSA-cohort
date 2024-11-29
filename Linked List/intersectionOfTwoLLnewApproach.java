/*
 * a b d e f g h
 * c d e f g h
 * 
 * d  : common intersection
 * 
 * jo bdi length wali ll usko dono ke size ke diff jitna extra run kra do 
 */

import java.util.*;

public class intersectionOfTwoLL {

    public static class Node {
        int data;
        Node next;
    }

    public static class intersectionLL {

        Node head;
        Node tail;
        int size;

        void add(int val) {
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

        void appendSharedNode(Node sharedNode) {
            if (size == 0) {
                head = tail = sharedNode;
            } else {
                tail.next = sharedNode;
            }
            while (sharedNode != null) {
                tail = sharedNode;
                sharedNode = sharedNode.next;
                size++;
            }
        }

        static int intersection(intersectionLL list1, intersectionLL list2) {

            Node n1 = list1.head;
            Node n2 = list2.head;

            int delta = Math.abs(list1.size - list2.size);

            if (list1.size > list2.size) {
                for (int i = 0; i < delta; i++) {
                    n1 = n1.next;
                }
            } else {
                for (int i = 0; i < delta; i++) {
                    n2 = n2.next;
                }
            }

            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;

            }

            return n1.data;

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        intersectionLL list1 = new intersectionLL();
        list1.add(1);
        list1.add(2);

        intersectionLL list2 = new intersectionLL();
        list2.add(0);

        Node shared = new Node();

        shared.data = 3;
        shared.next = new Node();

        shared.next.data = 4;
        shared.next.next = new Node();

        shared.next.next.data = 5;
        shared.next.next.next = new Node();

        shared.next.next.next.data = 6;

        list1.appendSharedNode(shared);
        list2.appendSharedNode(shared);

        System.out.println(intersectionLL.intersection(list1, list2));

        sc.close();
    }

}
