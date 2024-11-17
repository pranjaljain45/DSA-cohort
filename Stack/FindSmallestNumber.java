/*
 * pattern di
 * d = decreasing
 * i = increasing
 * 
 */

import java.util.*;

public class findSmallestNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();

        int n = 1;

        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == 'd') {
                num.push(n);
                n++;
            } else {
                num.push(n);
                n++;
                while (num.size() > 0) {
                    System.out.print(num.pop() + " ");
                }
            }
        }
        num.push(n);

        while (num.size() != 0) {
            System.out.print(num.pop() + " ");
        }

        sc.close();
    }
}
