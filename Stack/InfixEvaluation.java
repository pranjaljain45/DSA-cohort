
/*
 * integer single digit honge
 */
import java.util.*;

public class infixEvaluation {

    // calculate value

    static int calculation(int v1, int v2, char operator) {
        if (operator == '+') {
            return v1 + v2;
        } else if (operator == '-') {
            return v1 - v2;
        } else if (operator == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

    // precedence

    static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '/' || operator == '*') {
            return 2;
        } else {
            return -1; // Invalid operator
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stack<Character> operators = new Stack<>(); // store operators

        Stack<Integer> operands = new Stack<>(); // store integer value

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');// Convert char to int
            } else if (ch == ')') {

                while (operators.peek() != '(') {

                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opv = calculation(v1, v2, optor);
                    operands.push(opv);
                }

                operators.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {

                    char optor = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opv = calculation(v1, v2, optor);
                    operands.push(opv);

                }
                operators.push(ch);
            }
        }

        // remaining operators

        while (operators.size() != 0) {

            char optor = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int opv = calculation(v1, v2, optor);
            operands.push(opv);
        }

        System.out.println(operands.pop());

        sc.close();
    }
}
