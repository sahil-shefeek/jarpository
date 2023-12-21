import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {
    private JTextField celsiusTextField, fahrenheitTextField;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel celsiusLabel = new JLabel("Celsius:");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        celsiusTextField = new JTextField(10);
        fahrenheitTextField = new JTextField(10);
        fahrenheitTextField.setEditable(false);
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> convertTemperature());

        setLayout(new FlowLayout());
        add(celsiusLabel);
        add(celsiusTextField);
        add(fahrenheitLabel);
        add(fahrenheitTextField);
        add(convertButton);
        pack();
        setVisible(true);
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusTextField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Celsius.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
