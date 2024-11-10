import java.util.*;

public class calculatePower {

    static int calculate(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int val = calculate(x, n - 1);
        int multiply = x * val;

        return multiply;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int pow = sc.nextInt();

        System.out.println(calculate(num, pow));
        sc.close();
    }
}
