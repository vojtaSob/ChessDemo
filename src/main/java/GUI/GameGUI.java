package GUI;

import game.Game;
import utils.SwingFactories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameGUI implements MouseListener, MouseMotionListener {
    private Game game;
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JPanel chessBoard;

    private JLabel chessPiece;
    private int xPos;
    private int yPos;

    public GameGUI(Game game) {
        //https://community.oracle.com/tech/developers/discussion/1369482/chess-game-with-drag-and-drop-using-jlayeredpane

        super();
        this.game = game;
        Dimension boardSize = new Dimension(600, 600);
        SwingFactories swingFactories = new SwingFactories();
        frame = swingFactories.getDefaultJFrame(800, 800, "Chess");
        layeredPane = new JLayeredPane();
        frame.getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0) {
                if (i % 2 == 0) {
                    square.setBackground(Color.white);
                } else {
                    square.setBackground(Color.black);
                }
            } else {
                if (i % 2 == 0) {
                    square.setBackground(Color.black);
                } else {
                    square.setBackground(Color.white);
                }
            }
        }

        //JLabel piece = new JLabel(new ImageIcon("GUI/graphics/bb.svg"));
        //chessBoard.add(piece);
        frame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
