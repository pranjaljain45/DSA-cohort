import java.util.*;

public class printKeypadCombination {

    // globally declared
    static String[] combination = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    static void keypadCombination(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = s.charAt(0);
        String restStr = s.substring(1);

        String codeforch = combination[ch - '0'];

        for (int i = 0; i < codeforch.length(); i++) { // iterate over char of a string(num)

            char chCode = codeforch.charAt(i); // store each char

            keypadCombination(restStr, ans + chCode);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // combination of numbers

        keypadCombination(str, "");

        sc.close();
    }
}
