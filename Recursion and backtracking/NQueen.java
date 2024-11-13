/*
 * n*n chess board : square matrix
 * adjust n queen in n rows taki vo ek dusre ko mare nah
 * queen horizontal, vertical, diagonal kill krti hai 
 */

import java.util.*;

public class NQueen {

    static void putQueen(int[][] chess, int row, String set) {

        if (row == chess.length) {
            System.out.println(set);
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (safePlace(chess, row, col) == true) {
                chess[row][col] = 1;
                putQueen(chess, row + 1, set + row + col + " , ");
                chess[row][col] = 0;
            }
        }
    }

    static boolean safePlace(int[][] chess, int row, int col) {

        // vertical check
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // primary diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // secondary diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] chess = new int[m][n];

        putQueen(chess, 0, "");

        sc.close();
    }

}
