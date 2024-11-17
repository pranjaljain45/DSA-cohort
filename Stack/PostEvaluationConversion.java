/*
 * solve from left to right
 */

import java.util.*;

public class postEvaluationConversion {
   public static void main(String[] args) {
     
      Scanner sc = new Scanner(System.in);

      String str = sc.nextLine();

      Stack<Integer> value = new Stack<>();

      Stack<String> infix = new Stack<>();
      Stack<String> prefix = new Stack<>();

      for (char ch : str.toCharArray()) {
        
         if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {  
            
            int v2 = value.pop();
            int v1 = value.pop();
                                                                
            int v = solve( v1, v2, ch);
                                                                
            value.push( v );
         } 
         else {
            value.push( ch - '0' );
         }
      }
     
      System.out.println(value.pop());

      // conversion

      for (char ch : str.toCharArray()) {

         if (Character.isLetterOrDigit(ch)) {
            String s = Character.toString(ch);
            infix.push(s);
            prefix.push(s);
         } 
         else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            convert(infix, prefix, ch);
         }
      }

      System.out.println(prefix.pop());
      System.out.println(infix.pop());

      sc.close();
   }

   static void solve( int v1, int v2, char ch ) {

      int v2 = value.pop();
      int v1 = value.pop();

      if (ch == '+') {
         value.push(v1 + v2);
      } else if (ch == '-') {
         value.push(v1 - v2);
      } else if (ch == '*') {
         value.push(v1 * v2);
      } else if (ch == '/') {
         value.push(v1 / v2);
      } else {
         value.push(0);
      }
   }

   static void convert(Stack<String> infix, Stack<String> prefix, char ch) {
     
      String iv2 = infix.pop();
      String iv1 = infix.pop();

      infix.push("(" + iv1 + ch + iv2 + ")");

      String pv2 = prefix.pop();
      String pv1 = prefix.pop();

      prefix.push("(" + ch + pv1 + pv2 + ")");

   }
}
