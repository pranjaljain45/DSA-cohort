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

    public static void floorVal(Node node, int val) {

        if (node.data < val) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            floorVal(child, val);

        }
    }

    public static int kthLargestValueFromLargestNodeVal(Node node, int k) {

        floor = Integer.MIN_VALUE;

        int factor = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {

            floorVal(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;

        }

        return factor;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);

        System.out.println(kthLargestValueFromLargestNodeVal(root, 2));

    }
}
