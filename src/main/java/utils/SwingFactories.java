package utils;

import javax.swing.*;
import java.awt.*;

public class SwingFactories {


    public JFrame getDefaultJFrame(int width, int height, String title) {
        JFrame jFrame = new JFrame(title);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        return jFrame;
    }

    public JTextField getNameTextField() {
        JTextField jTextField = new JTextField();
        jTextField.setBorder(BorderFactory.createLineBorder(Color.black));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        return jTextField;
    }
}
