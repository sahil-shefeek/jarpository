import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.StringTokenizer;

class GUI implements ActionListener {
    JFrame frame;
    JPanel buttonsPanel;
    JTextField textField;
    JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, equalsButton, clearButton,
            deleteButton;

    GUI() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(480, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        textField = new JTextField(32);
        textField.setBounds(0, 0, 480, 64);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        equalsButton = new JButton("=");
        clearButton = new JButton("AC");
        deleteButton = new JButton("Del");
        clearButton.setForeground(Color.RED);
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(e -> textField.setText(""));
        deleteButton.addActionListener(e -> {
            String str = textField.getText();
            if (str != null && str.length() > 0)
                textField.setText(str.substring(0, str.length() - 1));
        });
        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(0, 64, 480, 540);
        buttonsPanel.setLayout(new GridLayout(6, 3, 5, 5));
        buttonsPanel.add(clearButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(multiplyButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(modulusButton);
        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
            buttonsPanel.add(digitButtons[i]);
        }
        buttonsPanel.add(equalsButton);
        frame.add(textField);
        frame.add(buttonsPanel);
        frame.setVisible(true);
    }

    boolean isOperator(String str) {
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

    int precedence(String str) {
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

    double evaluate(double y, double x, String op) {
        switch (op) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                if (y == 0) {
                    throw new ArithmeticException();
                }
                return x / y;
            case "%":
                return x % y;
        }
        return 0;
    }

    double evaluateExpression(String expression) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/%", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isOperator(token)) {
                while ((!operators.isEmpty()) && precedence(operators.peek()) > precedence(token))
                    operands.push(evaluate(operands.pop(), operands.pop(), operators.pop()));
                operators.push(token);
            } else {
                operands.push(Double.parseDouble(token));
            }
        }
        while (!operators.isEmpty())
            operands.push(evaluate(operands.pop(), operands.pop(), operators.pop()));

        if (!operands.isEmpty())
            return operands.pop();
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == equalsButton) {
            try {
                double result = evaluateExpression(textField.getText());
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                textField.setText("Error: Divide by zero");
            }
        } else {
            textField.setText(textField.getText() + source.getText());
        }
    }
}

public class SimpleCalculator {
    public static void main(String[] args) {
        new GUI();
    }
}
