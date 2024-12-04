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
            Node c2 = n2.children.get(j);

            if (areTreesMirror(c1, c2) == false) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        int[] a1 = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Stack<Node> st1 = new Stack<>();

        Node root1 = null;

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == -1) {
                st1.pop();
            } else {
                Node temp = new Node();
                temp.data = a1[i];

                if (st1.size() > 0) {
                    st1.peek().children.add(temp);
                } else {
                    root1 = temp;
                }

                st1.push(temp);
            }
        }

        int[] a2 = { 1, 7, 8, -1, -1, 4, 5, -1, 6, -1, -1, 2, -1, -1 };

        Node root2 = null;

        Stack<Node> st2 = new Stack<>();

        for (int i = 0; i < a2.length; i++) {
            if (a2[i] == -1) {
                st2.pop();
            } else {
                Node temp = new Node();
                temp.data = a2[i];

                if (st2.size() > 0) {
                    st2.peek().children.add(temp);
                } else {
                    root2 = temp;
                }

                st2.push(temp);
            }
        }

        System.out.println(areTreesMirror(root1, root2));

    }
}
