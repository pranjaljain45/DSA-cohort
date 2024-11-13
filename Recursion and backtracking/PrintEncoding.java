/*
 * a=1, b=2, c=3, d=4, e=5,f=6............z=26
 */

/*
 * ya toh first ch ya first two chs
 */

import java.util.*;

public class printEncoding {

    static void encoding(String st, String ans) {
        if (st.length() == 0) {
            System.out.println(ans);
            return;
        } else if (st.length() == 1) {
            char ch = st.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chValue = ch - '0'; // convert '6' to 6
                char code = (char) ('a' + chValue - 1); /*
                                                       * char + int = int
                                                       * a hai uski ascii value (97) usme chValue(2) - 1
                                                       * 97 + 2 - 1 = 98 : b
                                                       * har small aplhabets ki value ko provide kareyg
                                                       */
                ans += code;
                System.out.println(ans);
                return;
            }
        } else {
            // phle character

            char ch = st.charAt(0);
            String restString = st.substring(1);

            if (ch == '0') {
                return;
            } else {
                int chValue = ch - '0';
                char code = (char) ('a' + chValue - 1);

                encoding(restString, ans + code);
            }

            // starting ke do chs

            String s = st.substring(0, 2);
            String restString12 = st.substring(2);

            int ch12v = Integer.parseInt(s);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                encoding(restString12, ans + code);
            } else {
                return;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        encoding(str, "");
        sc.close();
    }

}
