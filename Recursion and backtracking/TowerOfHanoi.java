import java.util.*;

public class towerOfHanoi {

    // t1 = source, t2 = destination, t3 = helper
    
    static void printTOH(int n, String t1, String t2, String t3) {
        if (n == 0) {
            return;
        }

        printTOH(n - 1, t1, t3, t2); // move disc from t1 to t3 using t2
        System.out.println(n + " : " + t1 + t2);
        printTOH(n - 1, t3, t2, t1); // move disc from t3 to t2 using t1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printTOH(n, "A", "B", "C");
        sc.close();
    }
}
