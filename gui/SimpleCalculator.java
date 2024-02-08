import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.StringTokenizer;
import sahil.InfixExpressionUtils;

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
        frame.getContentPane().setBackground(Color.GRAY);
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
        buttonsPanel.setBackground(Color.GRAY);
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

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == equalsButton) {
            try {
                double result = InfixExpressionUtils.evaluateInfixExpression(textField.getText());
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
