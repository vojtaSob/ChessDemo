package GUI;

import game.Game;
import utils.SwingFactories;

import javax.swing.*;
import java.awt.*;

public class GameGUI {
    Game game;
    JFrame frame;
    JPanel panel;
    JLayeredPane layeredPane;
    private Tile tile_arr[][];


    public GameGUI(Game game) {
        //https://community.oracle.com/tech/developers/discussion/1369482/chess-game-with-drag-and-drop-using-jlayeredpane

        super();
        this.game = game;
        tile_arr = new Tile[8][8];
        SwingFactories swingFactories = new SwingFactories();
        frame = swingFactories.getDefaultJFrame(800, 800, "Chess");
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        frame.getContentPane().add(panel);
        for (int y = 8; y >= 1; y--) {

            for (int x = 1; x < 9; x++) {
                Tile tile = new Tile(x, y);
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        tile.setBackground(Color.gray);
                    } else {
                        tile.setBackground(Color.white);
                    }
                } else {
                    if (x % 2 == 0) {
                        tile.setBackground(Color.white);
                    } else {
                        tile.setBackground(Color.gray);
                    }
                }
                tile.setBaseColor(tile.getBackground());
                tile.addActionListener(e -> tileAction(tile, game));
                panel.add(tile);
                tile_arr[x - 1][y - 1] = tile;

            }
        }
        tile_arr[1][2].setIcon(swingFactories.getBlackBishopIcon());
        tile_arr[2][2].setIcon(swingFactories.getBlackKnightIcon());
        tile_arr[1][2].setText("");

        frame.setVisible(true);
    }

    void tileAction(Tile tile, Game game) {
        tile.setIcon(null);

    }
}
