import java.util.StringTokenizer;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String infix = scanner.nextLine();
        System.out.println("Postfix equivalent is: " + InfixToPostfixConverter.convert(infix));
    }

}

class InfixToPostfixConverter {

    public static String convert(String infix) {
        Stack<String> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(infix, "+-*/^()", true);
        StringBuffer buffer = new StringBuffer();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    try {
                        while ((!stack.empty()) & precedence(stack.peek()) >= precedence(token)) {
                            buffer.append(stack.pop());
                        }
                    } catch (EmptyStackException e) {
                    }
                    stack.push(token);
                    break;
                case "^":
                    try {
                        while ((!stack.empty()) & precedence(stack.peek()) > precedence(token)) {
                            buffer.append(stack.pop());
                        }
                    } catch (EmptyStackException e) {
                    }
                    stack.push(token);
                    break;
                case "(":
                    stack.push("(");
                    break;
                case ")":
                    try {
                        while (stack.peek() != "(") {
                            buffer.append(stack.pop());
                        }
                        stack.pop();
                    } catch (EmptyStackException e) {
                    }
                    break;
                default:
                    buffer.append(token);
                    break;
            }

        }
        while (!stack.empty()) {
            buffer.append(stack.pop());
        }
        return buffer.toString();
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
