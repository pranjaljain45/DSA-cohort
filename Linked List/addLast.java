import java.util.*;

public class addLast {

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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        linkedList list1 = new linkedList();

        list1.addEnd(20);
        list1.addEnd(30);
        list1.addEnd(40);
        list1.addEnd(50);
        list1.addEnd(60);

        list1.printList();

        sc.close();
    }
}
