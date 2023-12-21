import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class App implements ActionListener {
    JFrame frame;
    JLabel message;
    ButtonGroup btngroup;
    JRadioButton rbred, rbyellow, rbgreen;

    App() {

        frame = new JFrame("Traffic Light Simulator");
        message = new JLabel("Select Light");
        btngroup = new ButtonGroup();
        rbred = new JRadioButton("Red");
        rbyellow = new JRadioButton("Yellow");
        rbgreen = new JRadioButton("Green");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setForeground(Color.BLACK);
        rbred.setForeground(Color.RED);
        rbyellow.setForeground(Color.YELLOW);
        rbgreen.setForeground(Color.GREEN);

        btngroup.add(rbred);
        btngroup.add(rbyellow);
        btngroup.add(rbgreen);

        rbred.addActionListener(this);
        rbyellow.addActionListener(this);
        rbgreen.addActionListener(this);

        frame.add(message);
        frame.add(rbred);
        frame.add(rbyellow);
        frame.add(rbgreen);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String txt = e.getActionCommand();
        if (txt.equals("Red")) {
            message.setForeground(Color.RED);
            message.setText("STOP");
        } else if (txt.equals("Yellow")) {
            message.setForeground(Color.YELLOW);
            message.setText("READY");
        } else {
            message.setForeground(Color.GREEN);
            message.setText("GO");
        }
    }
}

public class TrafficLightSimulator {

    public static void main(String[] args) {
        new App();
    }

}