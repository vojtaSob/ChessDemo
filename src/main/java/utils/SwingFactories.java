package utils;

import javax.swing.*;
import java.awt.*;

public class SwingFactories {


    public JFrame getDefaultJFrame(int width, int height, String title) {
        JFrame jFrame = new JFrame(title);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        return jFrame;
    }

    public JTextField getNameTextField() {
        JTextField jTextField = new JTextField();
        jTextField.setBorder(BorderFactory.createLineBorder(Color.black));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        return jTextField;
    }

    public ImageIcon getBlackBishopIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_bishop.png");
    }
    public ImageIcon getBlackKingIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_king.png");
    }
    public ImageIcon getBlackKnightIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_knight.png");
    }
    public ImageIcon getBlackPawnIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_pawn.png");
    }
    public ImageIcon getBlackQueenIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_queen.png");
    }
    public ImageIcon getBlackRookIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/black_rook.png");
    }
    public ImageIcon getWhiteBishopIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_bishop.png");
    }
    public ImageIcon getWhiteKingIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_king.png");
    }
    public ImageIcon getWhiteKnightIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_knight.png");
    }
    public ImageIcon getWhitePawnIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_pawn.png");
    }
    public ImageIcon getWhiteQueenIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_queen.png");
    }
    public ImageIcon getWhiteRookIcon() {
        return new ImageIcon("src/main/java/GUI/graphics/white_rook.png");
    }
}
