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

        int getFirst() {
            if (size == 0) {
                System.out.println("LL is empty");
                return -1;
            } else {
                return head.data;
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

        public void remove() {

            removeValues newList = new removeValues();

            // jis list pr call huya hai (list)
            while (this.size > 0) {
                
                int val = this.getFirst();
                this.removeFirst();

                if (newList.size == 0 || newList.tail.data != val) {
                    newList.addLast(val);
                }

            }
            this.head = newList.head;
            this.tail = newList.tail;
            this.size = newList.size;
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
