import java.util.*;

public class isNoPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            int count = 0;
            for (int div = 2; div <= Math.sqrt(num); div++) {
                if (num % div == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                System.out.println("Prime num");
            } else {
                System.out.println("Not a prime num");
            }
        }

        sc.close();
    }
}
