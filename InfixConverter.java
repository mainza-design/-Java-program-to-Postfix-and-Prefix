import java.util.Stack;

public class InfixConverter {

    // Check if character is operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Return precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Infix to Postfix conversion
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If operand, add to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If '(' push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')' pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            // If operator
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    // For right associative '^', handle differently
                    if (c == '^' && stack.peek() == '^') {
                        break;
                    } else {
                        result.append(stack.pop());
                    }
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                stack.pop();
            } else {
                result.append(stack.pop());
            }
        }

        return result.toString();
    }

    // Reverse string helper
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    // Replace '(' with ')' and vice versa
    private static String replaceParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else if (c == ')') {
                sb.append('(');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Infix to Prefix conversion
    public static String infixToPrefix(String expression) {
        // Step 1: Reverse the infix expression
        String reversed = reverse(expression);

        // Step 2: Replace '(' with ')' and vice versa
        String replaced = replaceParentheses(reversed);

        // Step 3: Get postfix of modified expression
        String postfix = infixToPostfix(replaced);

        // Step 4: Reverse postfix to get prefix
        String prefix = reverse(postfix);

        return prefix;
    }

    // Main method for testing
    public static void main(String[] args) {
        String infixExpr = "((A-B)/ (C+D))*E";

        System.out.println("Infix Expression: " + infixExpr);
        String postfix = infixToPostfix(infixExpr);
        System.out.println("Postfix Expression: " + postfix);
        String prefix = infixToPrefix(infixExpr);
        System.out.println("Prefix Expression: " + prefix);
    }
}
