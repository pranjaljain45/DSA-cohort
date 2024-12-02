
import java.util.*;

public class genericTree {

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

    public static void mirrorTree(Node temp) {

        for (Node child : temp.children) {
            mirrorTree(child);
        }

        Collections.reverse(temp.children);
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

        mirrorTree(root);

        display(root);
    }
}
