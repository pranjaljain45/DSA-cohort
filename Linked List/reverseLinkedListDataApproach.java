import java.util.*;

public class reverseLinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class linkedList {
        Node head;
        Node tail;

        int size;

        void addEnd(int val) {

            Node temp = new Node(); // create a new node
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp; // prev last node me new add note ka address
                tail = temp; // aur last node
            }
            size++;
        }

        void printList() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");

                temp = temp.next; // abh prev store node me store address wali node
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;

            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }

        void swapNode() {
            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                
                li++;
                ri--;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        linkedList list1 = new linkedList();

        list1.addEnd(20);
        list1.addEnd(30);
        list1.addEnd(40);
        list1.addEnd(50);

        list1.swapNode();

        list1.printList();

        sc.close();
    }
}
