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

    static Node predecessor;
    static Node successor;
    static int state;

    public static void preSuc(Node node, int val) {
        if (state == 0) {
            if (node.data == val) {
                state = 1;
            } else {
                predecessor = node;
            }
        }

        else if (state == 1) {
            successor = node;
            state = 2;
        }
        for (Node child : node.children) {
            preSuc(child, val);
        }

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);

        state = 0;

        preSuc(root, 5);

        System.out.println(predecessor.data);

        System.out.println(successor.data);

    }
}
