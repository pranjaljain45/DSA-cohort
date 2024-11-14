import java.util.*;

public class getKeypadCombination {

    // globally declared
    static String[] combination = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    static ArrayList<String> keypadCombination(String s) {
        if (s.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = s.charAt(0);
        String restStr = s.substring(1);

        ArrayList<String> words = keypadCombination(restStr);

        ArrayList<String> result = new ArrayList<>(); // store final ans

        String codeforch = combination[ch - '0'];

        for (int i = 0; i < codeforch.length(); i++) { // iterate over char of a string(num)

            char chCode = codeforch.charAt(i); // store each char

            for (String st : words) {
                result.add(chCode + st);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // combination of numbers

        ArrayList<String> s = keypadCombination(str);

            System.out.println(s);
        
        sc.close();
    }
}
