/*
 * n*n chess board : square matrix
 * KNight 2.5 box move krta hai from original pos
 * clockwise direction 
 * 
 */

 import java.util.Scanner;

 public class KnightTour {
 
     static void tour(int[][] chess, int row, int col, int move) {
         if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
             return;
         } 
         
         if (move == chess.length * chess.length) {
             chess[row][col] = move;
             displayBoard(chess);
             chess[row][col] = 0;
             return;
         }
 
         chess[row][col] = move;
 
         tour(chess, row - 2, col + 1, move + 1);
         tour(chess, row - 1, col + 2, move + 1);
         tour(chess, row + 1, col + 2, move + 1);
         tour(chess, row + 2, col + 1, move + 1);
         tour(chess, row + 2, col - 1, move + 1);
         tour(chess, row + 1, col - 2, move + 1);
         tour(chess, row - 1, col - 2, move + 1);
         tour(chess, row - 2, col - 1, move + 1);
 
         chess[row][col] = 0;
     }
 
     static void displayBoard(int[][] chess) {
         for (int i = 0; i < chess.length; i++) {
             for (int j = 0; j < chess[0].length; j++) {
                 System.out.print(chess[i][j] + " ");
             }
             System.out.println();
         }
         System.out.println();
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         int m = sc.nextInt();
 
         int[][] chess = new int[m][m];
 
         int row = sc.nextInt();
         int col = sc.nextInt();
 
         int move = 0;
 
         tour(chess, row, col, move);
 
         sc.close();
     }
 
 }
 
