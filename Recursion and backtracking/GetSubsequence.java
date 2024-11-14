/*Subset calculate krte hai string ka BUT string ki length undefined hoti hai isliye Arraylist ka use krte hai store krne ke liye values */

import java.util.*;

public class getSubsequence {

    static ArrayList<String> subsetString(String s) {

        if (s.length() == 0) {

            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); // ek empty subset bhi hota hai
            return bres;
        }

        char ch = s.charAt(0); // har baar string ka ek ek char alag karenge

        String restStr = s.substring(1);// bki string ko alag store

        ArrayList<String> addString = subsetString(restStr); // phir se call kia taki chars ko alag kr ske

        ArrayList<String> result = new ArrayList<>(); // final ans ko store karegi

        for (String str : addString) {
            result.add(str);
            result.add(ch + str);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // enter string

        ArrayList<String> ss = subsetString(str); // array return hogi subsets ki string nahi

        // print string subsets

            System.out.println(ss);
        
        sc.close();
    }
}
