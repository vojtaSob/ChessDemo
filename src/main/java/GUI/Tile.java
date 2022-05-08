package GUI;

import javax.swing.*;
import java.awt.*;

public  class Tile extends JButton {
    int width;
    int height;
    private Color baseColor;
    String chessCords;

    public Tile(int width, int height) {
        this.width = width;
        this.height = height;
        this.setChessCords();
        this.setText(this.chessCords);
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color base_color) {
        this.baseColor = baseColor;
    }


    private void setChessCords() {
        char x = ' ';
        switch (this.width) {
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
        this.chessCords = x + Integer.toString(this.height);


    }


}