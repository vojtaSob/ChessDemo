package GUI;

import game.Piece;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton {
    private int widthInBoard;
    private int heightInBoard;
    private Color baseColor;
    Piece piece;
    String chessCords;

    public Tile(int width, int height) {
        this.widthInBoard = width;
        this.heightInBoard = height;
        this.setChessCords();
        //this.setText(this.chessCords);
    }

    public Color getBaseColor() {
        return this.baseColor;
    }

    public void resetColor() {
        this.setBackground(this.baseColor);
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }

    private void setChessCords() {
        int i = this.widthInBoard + 1;
        char x = ' ';
        switch (i) {
            case 1:
                x = 'a';
                break;
            case 2:
                x = 'b';
                break;
            case 3:
                x = 'c';
                break;
            case 4:
                x = 'd';
                break;
            case 5:
                x = 'e';
                break;
            case 6:
                x = 'f';
                break;
            case 7:
                x = 'g';
                break;
            case 8:
                x = 'h';
                break;
        }
        this.chessCords = x + Integer.toString(this.heightInBoard + 1);


    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        if (piece == null) {
            this.piece = null;
            this.setIcon(null);
        } else {
            this.piece = piece;
            this.setIcon(piece.getImageIcon());
        }
    }

    public int getWidthInBoard() {
        return widthInBoard;
    }

    public void setWidthInBoard(int widthInBoard) {
        this.widthInBoard = widthInBoard;
    }

    public int getHeightInBoard() {
        return heightInBoard;
    }

    public void setHeightInBoard(int heightInBoard) {
        this.heightInBoard = heightInBoard;
    }
}
