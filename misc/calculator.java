import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame {
    private JTextField textField;

    public calculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textField = new JTextField();
        textField.setEditable(false);

        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(new DigitButtonActionListener());
        }

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");

        addButton.addActionListener(new OperationButtonActionListener("+"));
        subtractButton.addActionListener(new OperationButtonActionListener("-"));
        multiplyButton.addActionListener(new OperationButtonActionListener("*"));
        divideButton.addActionListener(new OperationButtonActionListener("/"));
        equalsButton.addActionListener(new EqualsButtonActionListener());

        // Set layout
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        // Add components to the button panel
        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(addButton);
        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(subtractButton);
        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(divideButton);

        // Add components to the frame
        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private class DigitButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            textField.setText(textField.getText() + source.getText());
        }
    }

    private class OperationButtonActionListener implements ActionListener {
        private String operation;

        public OperationButtonActionListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = textField.getText();
            if (!currentText.isEmpty()) {
                textField.setText(currentText + operation);
            }
        }
    }

    private class EqualsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = textField.getText();

            try {
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                textField.setText("Error: Divide by zero");
            }
        }

        private double evaluateExpression(String expression) {
            // Initialize variables to store operand and operator
            double operand1 = 0;
            double operand2 = 0;
            char operator = ' ';

            // Flag to determine if we are currently processing the first operand
            boolean processingOperand1 = true;

            // Iterate through each character in the expression
            for (char ch : expression.toCharArray()) {
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    // Found an operator, update the operator and switch to processing the second
                    // operand
                    operator = ch;
                    processingOperand1 = false;
                } else {
                    // Found a digit, update the operands accordingly
                    double digit = Character.getNumericValue(ch);
                    if (processingOperand1) {
                        operand1 = operand1 * 10 + digit;
                    } else {
                        operand2 = operand2 * 10 + digit;
                    }
                }
            }

            // Perform the operation based on the operator
            switch (operator) {
                case '+':
                    return operand1 + operand2;
                case '-':
                    return operand1 - operand2;
                case '*':
                    return operand1 * operand2;
                case '/':
                    if (operand2 == 0) {
                        throw new ArithmeticException("Divide by zero");
                    }
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }

    }

    public static void main(String[] args) {
        calculator calculatorGUI = new calculator();
        calculatorGUI.setVisible(true);
    }
}
