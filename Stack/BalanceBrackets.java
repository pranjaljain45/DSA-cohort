/*
 * equal num of opening and closing brackets
 */

import java.util.*;

public class balanceBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();

        Stack<Character> balanced = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                balanced.push(ch);
            } else if (ch == ')') {
                if (balanced.isEmpty() || balanced.peek() != '(') {
                    System.out.println("Not balanced");
                    return;
                } else {
                    balanced.pop();
                }
            } else if (ch == '}') {
                if (balanced.isEmpty() || balanced.peek() != '{') {
                    System.out.println("Not balanced");
                    return;
                } else {
                    balanced.pop();
                }
            } else if (ch == ']') {
                if (balanced.isEmpty() || balanced.peek() != '[') {
                    System.out.println("Not balanced");
                    return;
                } else {
                    balanced.pop();
                }
            }

        }

        // closing brackets < opening brackets

        if (balanced.size() == 0) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }

        sc.close();
    }
}
