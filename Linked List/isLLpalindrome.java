import java.util.*;

public class isLLpalindrome {

    public static class Node {
        int data;
        Node next;
    }

    public static class isPallindrome {
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

        Boolean pallindromeHelper(Node right) {
            if (right == null) {
                return true;
            }
            Boolean res = pallindromeHelper(right.next);

            if (res == false) {
                return false;
            } else if (left.data != right.data) {
                return false;
            } else {
                left = left.next;
                return true;
            }

        }

        Node left;

        Boolean pallindromeChecker() {

            left = head;

            return pallindromeHelper(head);

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        isPallindrome list = new isPallindrome();

        list.addValues(10);
        list.addValues(20);
        list.addValues(30);
        list.addValues(40);
        list.addValues(50);

        System.out.println(list.pallindromeChecker());

        sc.close();
    }
}
