import java.util.*;

public class genricTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String s = node.data + " : ";

        for (Node child : node.children) {
            s += child.data + " ";
        }

        System.out.println(s);

        for (Node child : node.children) {
            display(child);
        }
    }

    /*
     * pre order me move karnege aur tree ko linear banayenge yani ki uske baad wala
     * element ko uska child banadenge
     * 1 2 4 5 8 9 3 6 7 10
     */

    public static void linearizeTree(Node node) {

        for (Node child : node.children) {
            linearizeTree(child);
        }

        while (node.children.size() > 1) {

            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLastChild = node.children.get(node.children.size() - 1);
            Node slct = getTail(secondLastChild);
            slct.children.add(lastChild);

        }

    }

    private static Node getTail(Node node) {

        while (node.children.size() == 1) {
            node = node.children.get(0);
        }

        return node;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] arr = { 1, 2, 4, -1, 5, 8, -1, 9, -1, -1, -1, 3, 6, -1, 7, 10, -1, -1, -1, -1 };

        Stack<Node> st = new Stack<>();

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

        display(root);

        linearizeTree(root);

        display(root);
    }
}
