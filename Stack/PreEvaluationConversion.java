/*
 * solve from right to left
 * opv1v2 = v1 op v2
 */

import java.util.*;

public class preEvaluationConversion {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String str = sc.nextLine();

      Stack<Integer> value = new Stack<>();

      Stack<String> infix = new Stack<>();
      Stack<String> postfix = new Stack<>();

      for (int i = str.length() - 1; i >= 0; i--) {

         char ch = str.charAt(i);

         if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            int v1 = value.pop();
            int v2 = value.pop();

            int v = solve(v1, v2, ch);
            value.push(v);

         } else {
            value.push(ch - '0');
         }
      }

      System.out.println(value.pop());

      // conversion

      for (int i = str.length() - 1; i >= 0; i--) {

         char ch = str.charAt(i);

         if (Character.isLetterOrDigit(ch)) {

            String s = Character.toString(ch);

            infix.push(s);
            postfix.push(s);

         } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            {
               convert(infix, postfix, ch);
            }
         }
      }

      System.out.println(postfix.pop());
      System.out.println(infix.pop());

      sc.close();
   }

   static int solve(int v1, int v2, char ch) {

      if (ch == '+') {
         return v1 + v2;
      } else if (ch == '-') {
         return v1 - v2;
      } else if (ch == '*') {
         return v1 * v2;
      } else if (ch == '/') {
         return v1 / v2;
      } else {
         return 0;
      }
   }

   static void convert(Stack<String> infix, Stack<String> postfix, char ch) {
      String iv1 = infix.pop();
      String iv2 = infix.pop();

      infix.push("(" + iv1 + ch + iv2 + ")");

      String pv1 = postfix.pop();
      String pv2 = postfix.pop();

      postfix.push("(" + pv1 + pv2 + ch + ")");

   }
}
