import java.util.*;

public class sortLinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class sortList {

        Node head;
        Node tail;
        int size;

        void addValue(int val) {

            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }

        void display() {
            System.out.print(size);

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // find mid node

        public static Node midNode(Node head, Node tail) {
            Node s = head;
            Node f = head;

            while (f != tail && f.next != tail) {
                f = f.next.next;
                s = s.next;
            }

            return s;
        }

        // paasing head and tail for finding mid node

        static sortList mergeSort(Node head, Node tail) {

            if (head == tail) {

                sortList baseres = new sortList();
                baseres.addValue(head.data);
                return baseres;

            }

            Node mid = midNode(head, tail);

            sortList firsthalf = mergeSort(head, mid);

            sortList secondhalf = mergeSort(mid.next, tail);

            sortList list = sortList.merge(firsthalf, secondhalf);

            return list;

        }

        // merge is a new object
        // return type sortList : return type of object (depend krtsa hai last me return
        // lia kr rhe hai)
        // parameter : ip of two objects
        // static : call by using class name

        static sortList merge(sortList list1, sortList list2) { // object 4

            Node n1 = list1.head;
            Node n2 = list2.head;

            sortList list = new sortList(); // object 5

            // jab tak element hai
            while (n1 != null && n2 != null) {

                if (n1.data < n2.data) {

                    list.addValue((n1.data));
                    n1 = n1.next;

                } else {

                    list.addValue((n2.data));
                    n2 = n2.next;

                }
            }

            // agar list 1 me elements bach gye ho

            while (n1 != null) {

                list.addValue((n1.data));
                n1 = n1.next;

            }

            // list2 me elements bach gye ho
            while (n2 != null) {

                list.addValue((n2.data));
                n2 = n2.next;

            }

            return list;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sortList list = new sortList(); // object 1

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addValue(val);
        }

        // call a class return type object

        sortList sortedList = sortList.mergeSort(list.head, list.tail);

        sortedList.display();

        sc.close();
    }
}
