import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton modulusButton;
    JButton equalsButton;
    JButton clearButton;
    private boolean isReset = true;

    GUI() {

        frame = new JFrame("Simple Calculator");
        frame.setSize(360, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 3));

        textField = new JTextField(25);
        textField.setBounds(50, 25, 300, 50);

        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        equalsButton = new JButton("=");
        clearButton = new JButton("AC");
        clearButton.setForeground(Color.RED);
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
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
        if (source == equalsButton) {
            String expression = textField.getText();
            try {
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
                isReset = false;
            } catch (ArithmeticException ex) {
                textField.setText("Error: Divide by zero");
            }
        } else if (source == clearButton) {
            textField.setText("");
        } else {
            if (!isReset) {
                textField.setText("");
                isReset = true;
            }
            textField.setText(textField.getText() + source.getText());
        }
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
