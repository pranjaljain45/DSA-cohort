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

    /*
     * state -1 : pre order : print + state inc
     * state 0 to children.size - 1 : child push + state inc
     * state cs : post order : pop + print
     */

    static class pair {

        Node node;
        int state;

        pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void prePostOrder(Node node, int state) {

        Stack<pair> st = new Stack<>();

        st.push(new pair(node, state)); // push root node

        String pre = " ";
        String post = " ";

        while (st.size() > 0) {

            pair top = st.peek();

            if (top.state == -1) {

                pre += top.node.data + " ";
                top.state++;

            } else if (top.state == top.node.children.size()) {

                post += top.node.data + " ";
                st.pop();

            } else {

                pair cp = new pair(top.node.children.get(top.state), -1);
                st.push(cp);

                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);

        prePostOrder(root, -1);

    }
}
