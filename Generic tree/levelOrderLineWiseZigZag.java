/*
 * 1 : 2 3 6
 * 2
 * 3 : 4 5
 * 4 :
 * 5 :
 * 6 : 7
 * 7 :
 * 
 * 1
 * 6 3 2
 * 4 5 7 
*/

import java.util.*;

public class genericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrderLineWiseZigZag(Node temp) {

        Stack<Node> ms = new Stack();
        Stack<Node> cs = new Stack();

        ms.push(temp);

        int level = 1; /*
                        * even : right to left
                        * odd : left to right
                        */

        while (ms.size() > 0) {
            temp = ms.pop();

            System.out.print(temp.data + " ");

            // left to right
            if (level % 2 == 1) {

                for (int i = 0; i < temp.children.size(); i++) {
                    Node child = temp.children.get(i);
                    cs.push(child);
                }

            }
            // right to left
            else {

                for (int i = temp.children.size() - 1; i >= 0; i--) {
                    Node child = temp.children.get(i);
                    cs.push(child);
                }

            }

            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack();
                level++;

                System.out.println();
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

        levelOrderLineWiseZigZag(root);
    }
}
