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

    static int maxSumNode = 0;
    static int maxSum = Integer.MIN_VALUE;

    public static int subTreeSum(Node node) {
        int sum = 0;

        if (sum > maxSum) {
            maxSum = sum;
            maxSumSubNode = node.data;
        }

        for (Node child : node.children) {
            int currsum = subTreeSum(child);
            sum += currsum;
        }

        sum += node.data;

        if (sum > maxSum) {

            maxSumNode = node.data;
            maxSum = sum;

        }

        return sum;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -1, 3, 4, -1, 5, -1, -1, 6, 7, -1, -1, -1 };

        Node root = constructor(arr);

        subTreeSum(root);

        System.out.println(maxSum);

        System.out.println(maxSumNode);

    }
}
