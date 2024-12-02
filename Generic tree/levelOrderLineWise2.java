/*
 * 1 : 2 3 6
 * 2
 * 3 : 4 5
 * 4 :
 * 5 :
 * 6 : 7
 * 7 : 
 * 
 * 1 2 3 6 4 5 7
*/

import java.util.*;

public class genericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void levelOrderLineWise2(Node temp) {

        Queue<Node> mq = new ArrayDeque<>();
        // Queue<Node> cq = new ArrayDeque<>();

        mq.add(temp);
        mq.add(new Node(-1));

        while (mq.size() > 0) {
            temp = mq.remove();

            if (temp.data != -1) {
                System.out.print(temp.data + " ");

                for (Node child : temp.children) { // add children
                    mq.add(child);
                }
            } else {
                if (mq.size() > 0) {
                    mq.add(new Node(-1));

                    System.out.println();
                }

            }

        }

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Stack<Node> st = new Stack<>();

        Node root = null;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }

                st.push(temp);
            }
        }

        levelOrderLineWise2(root);
    }
}
