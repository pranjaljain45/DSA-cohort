import java.util.*;

public class removeDuplicate {

    public static class Node {
        int data;
        Node next;
    }

    public static class removeValues {

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

        public void remove() {
            Node n1 = head;

            while (n1 != null && n1.next != null) {
                if (n1.data == n1.next.data) {
                    n1.next = n1.next.next; // skip the duplicate node
                } else {
                    n1 = n1.next; // move to new node
                }

            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        removeValues list = new removeValues();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addValues(val);
        }

        list.remove();

        list.display();

        sc.close();
    }
}
