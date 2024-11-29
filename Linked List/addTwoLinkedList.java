import java.util.*;

public class addTwoLinkedList {

    public static class Node {
        int data;
        Node next;
    }

    public static class addLL {

        Node head;
        Node tail;
        int size;

        void add(int val) {
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

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
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

        static int add(Node n1, int pv1, Node n2, int pv2, addLL list) {

            if (n1 == null && n2 == null) {
                return 0;
            }

            int data = 0;

            if (pv1 > pv2) {
                int carry = add(n1.next, pv1 - 1, n2, pv2, list);
                data = n1.data + carry;
            }

            else if (pv1 < pv2) {
                int carry = add(n1, pv1, n2.next, pv2 - 1, list);
                data = n2.data + carry;
            }

            else {
                int carry = add(n1.next, pv1 - 1, n2.next, pv2 - 1, list);
                data = n1.data + n2.data + carry;
            }

            int newData = data % 10;
            int newCarry = data / 10;

            list.addFirst(newData);

            return newCarry;
        }

        static addLL addition(addLL list1, addLL list2) {

            addLL list = new addLL();

            int carry = add(list1.head, list1.size, list2.head, list2.size, list);

            if (carry > 0) {
                list.addFirst(carry);
            }

            return list;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        addLL list1 = new addLL();

        list1.add(9);
        list1.add(9);
        list1.add(9);
        list1.add(9);

        addLL list2 = new addLL();
        list2.add(1);
        list2.add(1);


        addLL addll = addLL.addition(list1, list2);

        addll.display();
        
        sc.close();
    }

}

// 1 0 0 1 0
