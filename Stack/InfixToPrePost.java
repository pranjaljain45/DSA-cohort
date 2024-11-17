/*
 * INFIX
 * Postfix -- v1v2op (ab+)
 * Prefix -- opv1v2  (+ab)
 */

import java.util.*;

public class InfixToPrePost {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String st = sc.nextLine();

      Stack<Character> operator = new Stack<>();
      
      Stack<String> preStr = new Stack<>();
      
      Stack<String> postStr = new Stack<>();

      for (int i = 0; i < st.length(); i++) {

         char ch = st.charAt(i);

         if (ch == '(') {
            operator.push(ch);
         } 
         else if (Character.isLetterOrDigit(ch)) {
            preStr.push(s + "" );
            postStr.push(s + "" );
         } 
         else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            while (operator.size() > 0 && operator.peek() != '('
                  && precedence(ch) <= precedence(operator.peek())) {
               solve(operator, preStr, postStr);
            }
            operator.push(ch);
         } 
         else if (ch == ')') {
            while (operator.peek() != '(') {
               solve(operator, preStr, postStr);
            }
            operator.pop();
         }
      }

      while (operator.size() != 0) {
         solve(operator, preStr, postStr);
      }

      System.out.println(postStr.pop());
      System.out.println(preStr.pop());
      sc.close();
   }

   static int precedence(char ch) {
      if (ch == '+' || ch == '-') {
         return 1;
      } else if (ch == '*' || ch == '/') {
         return 2;
      } else {
         return -1;
      }
   }

   static void solve(Stack<Character> operator, Stack<String> preStr, Stack<String> postStr) {
      char op = operator.pop();

      String preV2 = preStr.pop();
      String preV1 = preStr.pop();
      preStr.push(op + preV1 + preV2);

      String postV2 = postStr.pop();
      String postV1 = postStr.pop();
      postStr.push(postV1 + postV2 + op);
   }
}
