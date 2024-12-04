/*
 * do nodes jo ek dusre se edges ke term me sabse zyda  * dur hai unke beech ka distance
 * 
 * deepestchildheight + 2nddeepestchildheight + 2
 */

import java.util.*;

public class genericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node constructor(int[] arr) {

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

        return root;
    }

    static int diameter = 0;

    public static int diamterGenericTree(Node node) {

        int dht = -1; // deepest child height
        int sdht = -1; // second deepest child height

        for (Node child : node.children) {

            int childht = diamterGenericTree(child);

            if (childht > dht) {
                sdht = dht;
                dht = childht;
            } else if (childht > sdht) {
                sdht = childht;
            }
        }

        if (dht + sdht + 2 > diameter) {
            diameter = dht + sdht + 2;
        }

        dht += 1;

        return dht;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);
        diamterGenericTree(root);

        System.out.println(diameter);

    }
}
