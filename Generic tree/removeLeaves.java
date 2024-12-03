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

    public static void removeLeaves(Node node) {

        /*
         * traverse back se isliye kyuki list me agar age se kia toh sare lements aage
         * ajayenge and kuch elements check hi nahi ho payenge
         */

      /*
        pre order karenge kyuki post order me agar kia toh jin child ke child exist krte hai vo bhi remove ho jayenge
      */
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
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

        removeLeaves(root);

        display(root);
    }
}
