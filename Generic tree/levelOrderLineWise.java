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
    }

    public static void levelOrderLineWise(Node temp) {

        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        mq.add(temp);

        while (mq.size() > 0) {
            temp = mq.remove();

            System.out.print(temp.data + " ");

            for (Node child : temp.children) { // add children
                cq.add(child);
            }

            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();

                System.out.println(); //next line after each line
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

        levelOrderLineWise(root);
    }
}
