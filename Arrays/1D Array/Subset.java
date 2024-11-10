import java.util.*;

public class subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // no of subsets
        int numSS = (int) Math.pow(2, arr.length);

        for (int i = 0; i < numSS; i++) {
            int temp = i;
            
            String set = "";

            // work on bits either 0 or 1
            for (int j = arr.length - 1; j >= 0; j--) { // from end we have to arrange values
                int r = temp % 2; // 1 ata toh include 0 ata toh exclude
                temp /= 2;

                if (r == 0) {
                    set = " " + set;
                } else {
                    set = arr[j] + set;
                }
            }

            System.out.println(set);
        }

        sc.close();
    }
}
