import java.util.*;

public class removeLast {

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

        void rmvLast() {
            if (size == 0) {
                System.out.println("Empty linkedlist");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;

                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                temp.next = null;
                size--;

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

        list1.rmvLast();

        list1.printList();

        sc.close();
    }
}
