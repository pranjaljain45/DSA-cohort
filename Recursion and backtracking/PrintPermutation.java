//PERMUTAION : group of element me har element ko kaise arrange kare apass me ki ek new group ban jaye

import java.util.*;

public class printPermutation {

    static void permutations(String st, String ans) {
        if (st.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            String lp = st.substring(0, i); // i is excluded
            String rp = st.substring(i + 1); // i is excluded

            String restString = lp + rp;

            permutations(restString, ans + ch);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

       permutations(s, "");
        sc.close();
    }

}
