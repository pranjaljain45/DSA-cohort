import java.util.*;

public class largestAreaHistogram {

    static int findLargeArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        // left spread
        Stack<Integer> leftSpread = new Stack<>();

        int[] lb = new int[n]; // idx of left smaller element

        lb[0] = -1; // 0th idx ke left me kuch nahi
        leftSpread.push(0);

        for (int i = 1; i < n; i++) {
            while (leftSpread.size() > 0 && height[i] <= height[leftSpread.peek()]) {
                leftSpread.pop();
            }
            if (leftSpread.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = leftSpread.peek(); // last spread val
            }
            leftSpread.push(i);
        }

        for (int i = 0; i < lb.length; i++) {
            System.out.print(lb[i]);
        }

        // right spread
        Stack<Integer> rightSpread = new Stack<>();

        int[] rb = new int[n]; // idx of right smaller element

        rightSpread.push(n - 1);
        rb[n - 1] = n; // 0th idx ke right me kuch nahi

        for (int i = n - 2; i >= 0; i--) {
            while (rightSpread.size() > 0 && height[i] <= height[rightSpread.peek()]) {
                rightSpread.pop();
            }
            if (rightSpread.size() == 0) {
                rb[i] = height.length;
            } else {
                rb[i] = rightSpread.peek(); // last spread val
            }
            rightSpread.push(i);
        }

        for (int i = 0; i < rb.length; i++) {
            System.out.print(rb[i]);
        }

        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = height[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
        }

        int area = findLargeArea(height);

        System.out.print(area);

        sc.close();
    }
}
