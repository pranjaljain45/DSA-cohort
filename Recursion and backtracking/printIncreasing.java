// n = 5
// 1 2 3 4 5

import java.util.*;

public class printIncreasing {

    static void printNum(int n) {

        if (n == 0) {
            return;
        }

        printNum(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printNum(n);

        sc.close();
    }
}
