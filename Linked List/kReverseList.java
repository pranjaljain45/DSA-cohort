import java.util.*;

public class kReverseList {

    public static class Node {
        int data;
        Node next;
    }

    public static class kReverse {

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

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                head = tail = temp;
            }
            size++;
        }

        void addLast(int val) {
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

        int getFirst() {
            if (size == 0) {
                System.out.println("LL is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        void removeFirst() {

            if (size == 0) {
                System.out.println("LL is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                head = head.next;
                size--;
            }

        }

        void reverseList(int k) {

            kReverse prev = null;

            while (this.size > 0) {

                kReverse curr = new kReverse();

                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {

                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);

                    }

                } else {

                    int os = this.size;

                    for (int i = 0; i < os; i++) {

                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }

                if (prev == null) {

                    prev = curr;

                } else {

                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;

                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        kReverse list = new kReverse();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addValues(val);
        }

        list.display();

        System.out.println();

        list.reverseList(2);

        list.display();

        sc.close();
    }
}
