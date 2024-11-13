/* matrix of 0's and 1's */

/*
 * anticlockwise movement in an array
 * t = top, b = bottom, l = left, r = right
 */

/*
 * 0 move
 * 1 stoppage
 * ek path exit karegea  0,0 to m,n
 * path repeat nahi hoga
 */
import java.util.*;

public class floodFill {

    static void pleaseExit(int[][] arr, int row, int col, String ans, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 1
                || visited[row][col] == true) {
            return;
        }

        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println(ans);
            return;
        }

        visited[row][col] = true;
        pleaseExit(arr, row - 1, col, ans + "t", visited); // up
        pleaseExit(arr, row, col - 1, ans + "l", visited); // left
        pleaseExit(arr, row + 1, col, ans + "b", visited); // down
        pleaseExit(arr, row, col + 1, ans + "r", visited);

        visited[row][col] = false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        // array of 0 and 1

        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int row = 1; // starting row
        int col = 1;// starting col

        // track if cell is visited or not

        boolean[][] visited = new boolean[m][n];

        pleaseExit(arr, row, col, "", visited);

        sc.close();
    }

}
