import java.util.*;

public class printStairpath {

    static void findPath(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        } else if (n < 0) {
            return;
        }

        findPath(n - 1, ans + "1");
        findPath(n - 2, ans + "2");
        findPath(n - 3, ans + "3");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        findPath(n, "");

        sc.close();
    }
}
