import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI implements ActionListener {

    JFrame frame;
    JTextField textField;

    GUI() {

        frame = new JFrame();
        frame.setTitle("Simple Calculator");
        frame.setSize(480, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 3));

        textField = new JTextField(25);

        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton modulusButton = new JButton("%");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("AC");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        equalsButton.addActionListener(e -> {
            String expression = textField.getText();
            try {
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                textField.setText("Error: Divide by zero");
            }
        });

        clearButton.addActionListener(e -> textField.setText(""));

        frame.add(textField);
        frame.add(clearButton);
        for (int i = 0; i < 10; i++)
            frame.add(digitButtons[i]);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(modulusButton);
        frame.add(equalsButton);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        textField.setText(textField.getText() + source.getText());
    }

    double evaluateExpression(String expression) {
        double operand1 = 0;
        double operand2 = 0;
        char operator = ' ';

        boolean isOperand1 = true;

        for (char term : expression.toCharArray()) {
            if (term == '+' || term == '-' || term == '*' || term == '/' || term == '%') {
                operator = term;
                isOperand1 = false;
            } else {
                Double digit = (double) Character.getNumericValue(term);
                if (isOperand1)
                    operand1 = operand1 * 10 + digit;
                else
                    operand2 = operand2 * 10 + digit;

            }
        }

        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException();
                }
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;

        }
        return 0;
    }

}

public class SimpleCalculator {
    public static void main(String[] args) {
        new GUI();
    }
}
