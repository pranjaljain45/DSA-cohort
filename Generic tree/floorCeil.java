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

    static int floor; // max val among small values
    static int ceil; // min val among large values

    public static void floorCeil(Node node, int val) {

        if (node.data > val) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }

        if (node.data < val) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            floorCeil(child, val);

        }

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);

        floor = Integer.MIN_VALUE;
        ceil = Integer.MAX_VALUE;

        floorCeil(root, 8);

        System.out.println(floor);

        System.out.println(ceil);

    }
}
