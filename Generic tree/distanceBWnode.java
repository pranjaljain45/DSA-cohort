
public class genericTree {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToroot(Node node, int val) {
        if (node.data == val) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for (Node child : node.children) {
            ArrayList<Integer> list2 = nodeToroot(child, val);
            if (list2.size() > 0) {
                list2.add(node.data);
                return list2;
            }
        }

        return new ArrayList<>();
    }

    public static int distanceBWnode(Node node, int d1, int d2) {

        ArrayList<Integer> p1 = nodeToroot(node, d1);
        ArrayList<Integer> p2 = nodeToroot(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {

            i--;
            j--;

        }

        i++;
        j++;

        return i + j;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, -1, -1, 4, 5, -1, 6, 7, -1, 8, -1, -1, -1, 9, -1, 10, 11, -1, -1, -1 };

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

        System.out.println(distanceBWnode(root, 7, 9));

    }
}
