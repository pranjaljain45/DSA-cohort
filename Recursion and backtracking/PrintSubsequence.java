/*Subset calculate krte hai string ka BUT string ki length undefined hoti hai isliye Arraylist ka use krte hai store krne ke liye values */

import java.util.*;

public class printSubsequence {

    static void subsetString(String s, String ans) {

        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0); // har baar string ka ek ek char alag karenge

        String restStr = s.substring(1);// bki string ko alag store

        subsetString(restStr, ans + " "); // char nahi ayega
        subsetString(restStr, ans + ch);// ch ayega
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // enter string

        subsetString(str, "");

        sc.close();
    }
}
