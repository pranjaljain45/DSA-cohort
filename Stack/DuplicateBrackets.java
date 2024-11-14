/*
 * ek se bracket ek hi content ko wrap kiye hue hai
 * eg : ((a+b))
 * 
 * open + content : push
 * ) : check conditions
 */

import java.util.*;

public class duplicateBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();

        Stack<Character> duplicacy = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);

            if (ch == ')') {
                if (duplicacy.peek() == '(') {
                    System.out.println("Duplicay");
                    break;
                } else {
                    while (duplicacy.peek() != '(') {
                        duplicacy.pop();
                    }
                    duplicacy.pop();
                    if (duplicacy.size() == 0) {
                        System.out.println("No duplicay");
                    }
                }

            } else {
                duplicacy.push(ch);
            }
        }
        sc.close();
    }
}
