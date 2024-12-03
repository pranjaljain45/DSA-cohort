import java.util.*;

public class genricTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeTorootPath(Node node, int data) {

        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> list2 = nodeTorootPath(child, data);
            if (list2.size() > 0) {
                list2.add(node.data);
                return list2;
            }
        }

        return new ArrayList<>();
    }

    public static int lowestCommonAncestor(Node node, int d1, int d2) {

        ArrayList<Integer> p1 = nodeTorootPath(node, d1);
        ArrayList<Integer> p2 = nodeTorootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        i++;
        j++;

        return p1.get(i);
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
System.out.println(lowestCommonAncestor(root, 5, 4));
    }
}
