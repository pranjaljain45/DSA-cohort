// n = 5
// 5 4 3 2 1

import java.util.*;

public class printDecreasing {

    static void printElements(int n) {
        if(n == 0){
            return;
        }
        System.out.println(n);
        printElements(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printElements(n);

        sc.close();
    }
}
