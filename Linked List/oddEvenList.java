import java.util.*;

public class oddEvenList {

    public static class Node {
        int data;
        Node next;
    }

    public static class oddEven {

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

        void rearrangeOddEvenList() {

            oddEven oddList = new oddEven();
            oddEven evenList = new oddEven();

            // jis list pr call huya hai (list)
            while (this.size > 0) {

                int val = this.getFirst();

                this.removeFirst(); /*
                                     * node ek time me ek hi list me ho
                                     * space complexity : O(1)
                                     */

                if (val % 2 == 0) {
                    evenList.addLast(val);
                } else {
                    oddList.addLast(val);
                }

            }

            // oddList.display();
            // evenList.display();

            // System.out.println(oddList.size + " " + evenList.size);

            if (oddList.size > 0 && evenList.size > 0) {

                oddList.tail.next = evenList.head;

                this.head = oddList.head;
                this.tail = evenList.tail;

            } else if (oddList.size > 0) {

                this.head = oddList.head;
                this.tail = oddList.tail;

            } else {

                this.head = evenList.head;
                this.tail = evenList.tail;

            }

            this.size = oddList.size + evenList.size;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        oddEven list = new oddEven();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addValues(val);
        }

        list.display();

        System.out.println();

        list.rearrangeOddEvenList();

        // System.out.println(list.size);

        list.display();

        sc.close();
    }
}
