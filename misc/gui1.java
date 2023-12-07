import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui1 {
    public static void main(String[] args) {
        // Call the constructor to create and display the GUI
        new GUI();
    }
}

class GUI {
    public GUI() {
        // Create JFrame
        JFrame frame = new JFrame("Button Example");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Create JTextField
        JTextField textField = new JTextField();
        textField.setEditable(false); // Make the text field not editable

        // Create JButton for Submit
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Submit button clicked");
            }
        });

        // Create JButton for Save
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Save button clicked");
            }
        });

        // Add components directly to the frame
        frame.add(textField);
        frame.add(submitButton);
        frame.add(saveButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}
