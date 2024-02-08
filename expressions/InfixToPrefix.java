import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class InfixToPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String infix = scanner.nextLine();
        System.out.println("Postfix equivalent is: " + InfixToPrefixConverter.convert(infix));
    }
}

class InfixToPrefixConverter {
    public static String convert(String infix) {
        Stack<String> stack = new Stack<>();
        String reversedInfix = new StringBuilder(infix).reverse().toString();
        StringBuilder prefix = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reversedInfix, "+-*/^()", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    try {
                        while ((!stack.empty()) & precedence(stack.peek()) > precedence(token)) {
                            prefix.append(stack.pop());
                        }
                    } catch (EmptyStackException e) {
                    }
                    stack.push(token);
                    break;
                case "^":
                    try {
                        while ((!stack.empty()) & precedence(stack.peek()) >= precedence(token)) {
                            prefix.append(stack.pop());
                        }
                    } catch (EmptyStackException e) {
                    }
                    stack.push(token);
                    break;
                case ")":
                    stack.push(")");
                    break;
                case "(":
                    try {
                        while (stack.peek() != ")") {
                            prefix.append(stack.pop());
                        }
                        stack.pop();
                    } catch (EmptyStackException e) {
                    }
                    break;
                default:
                    prefix.append(token);
                    break;
            }
        }
        return prefix.reverse().toString();
    }

    private static int precedence(String str) {
        switch (str) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
}
