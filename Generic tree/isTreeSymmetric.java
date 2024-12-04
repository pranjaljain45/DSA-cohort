/*
 * no of children same
 * tree1 left to right child  == tree2 right to left child
 */

import java.util.*;

public class genericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Boolean areTreesMirror(Node n1, Node n2) {

        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;

            Node c1 = n1.children.get(i);
            Node c2 = n1.children.get(j);

            if (areTreesMirror(c1, c2) == false) {
                return false;
            }
        }

        return true;
    }

    public static Boolean isTreeSymmetric(Node node) {
        return areTreesMirror(node, node);
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

        System.out.println(isTreeSymmetric(root));

    }
}
