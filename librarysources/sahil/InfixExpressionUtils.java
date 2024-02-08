package sahil;

import java.util.Stack;
import java.util.StringTokenizer;

public class InfixExpressionUtils {
    private static boolean isOperator(String str) {
        switch (str) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return true;
        }
        return false;
    }

    private static int precedence(String str) {
        switch (str) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
        }
        return 0;
    }

    private static double operate(double y, double x, String op) {
        switch (op) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            case "%":
                return x % y;
        }
        return 0;
    }

    private static double evaluateExpression(String expression) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/%", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isOperator(token)) {
                while ((!operators.isEmpty()) && precedence(operators.peek()) > precedence(token))
                    operands.push(operate(operands.pop(), operands.pop(), operators.pop()));
                operators.push(token);
            } else {
                operands.push(Double.parseDouble(token));
            }
        }
        while (!operators.isEmpty())
            operands.push(operate(operands.pop(), operands.pop(), operators.pop()));

        if (!operands.isEmpty())
            return operands.pop();
        return 0;
    }

    public static double evaluateInfixExpression(String expression) {
        return evaluateExpression(expression);
    }
}