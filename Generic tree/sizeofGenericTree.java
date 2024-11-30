import java.util.*;

public class GenricTree {

    public static class Node {
        int data;

        ArrayList<Node> children = new ArrayList<>(); /*
                                                       * ArrayList in each node, used to store references to its child
                                                       * nodes.
                                                       */

        // public Node(int data) {
        // this.data = data;
        // }
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            int cs = size(child);
            s += cs;
        }

        return s + 1;
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
                    st.peek().children.add(temp); // har parent node pr ek arraylist banegi uske children ki
                } else {
                    root = temp;
                }

                st.push(temp);
            }
        }

        System.out.print(size(root));
    }
}
