/*
 * vo person jo kisi ko nahi jnta aur usko sab jnte hai
 * 
 * 0,0 ki matrix hai
 * diagonal pr 0 isliye kykui har insaan khudh ko jnta hai : ILLOGICAL
 */

import java.util.*;

public class celebrityProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        findCelebrity(matrix);

        sc.close();
    }

    static void findCelebrity(int[][] matrix) {

        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {
            val.push(i);
        }

        while (val.size() >= 2) {
            int v2 = val.pop();
            int v1 = val.pop();

            if (matrix[v1][v2] == 1) { // v1 v2 ko jnte hai
                val.push(v2);
            } else {
                val.push(v1);
            }

        }

        int canCelebrity = val.pop();

        for (int i = 0; i < matrix.length; i++) {
            if (i != canCelebrity) {

                /*
                 * aisa koi jo apko nah jnta ho aur ap kisi ko jnte ho
                 */
                if (matrix[i][canCelebrity] == 0 || matrix[canCelebrity][i] == 1) {
                    System.out.println("No celebrity exist");
                }
            }
        }
        System.out.println(canCelebrity);
    }
}
