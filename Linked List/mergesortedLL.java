import java.util.*;

public class mergesortedLL {

    public static class Node {
        int data;
        Node next;
    }

    public static class mergeList {

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
            System.out.print(size);
        }

        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // merge is a new object
        static mergeList merge(mergeList list1, mergeList list2) { // object 4

            Node n1 = list1.head;
            Node n2 = list2.head;

            mergeList list = new mergeList(); // object 5

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

        int n1 = sc.nextInt();

        mergeList list1 = new mergeList(); // object 1

        for (int i = 0; i < n1; i++) {
            int val = sc.nextInt();
            list1.addValue(val);
        }

        int n2 = sc.nextInt();

        mergeList list2 = new mergeList(); // object 2

        for (int i = 0; i < n2; i++) {
            int val = sc.nextInt();
            list2.addValue(val);
        }

        mergeList mergedLL = mergeList.merge(list1, list2); // object 3

        mergedLL.display();

        sc.close();
    }
}
