import java.util.*;

public class reverseLinkedListRecursively {

    public static class Node {
        int data;
        Node next;
    }

    public static class linkedList {
        Node head;
        Node tail;

        int size;

        void addValues(int val) {

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

        void displayRecursively(Node head) {
            if (head == null) {
                return;
            }
            displayRecursively(head.next);
            System.out.print(head.data + " ");
        }

        void display() {
            displayRecursively(head);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        linkedList list1 = new linkedList();

        list1.addValues(20);
        list1.addValues(30);
        list1.addValues(40);
        list1.addValues(50);

        list1.display();

        sc.close();
    }
}
