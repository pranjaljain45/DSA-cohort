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

    public static Node Constructor(int[] arr) {

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

    static int size;
    static int min;
    static int max;
    static int height;

    public static void multiSolver(Node node, int depth) {

        size++;

        min = Math.min(min, node.data);

        max = Math.max(max, node.data);

        height = Math.max(height, depth);

        for (Node child : node.children) {
            multiSolver(child, depth + 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = Constructor(arr);

        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;

        multiSolver(root, 0);

        System.out.println(size);
        System.out.println(min);
        System.out.println(max);
        System.out.println(height);

    }
}
