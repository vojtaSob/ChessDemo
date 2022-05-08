package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class Knight extends Piece {
    public Knight(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(Piece.KNIGHT);
        this.didFirstMove = false;
        this.initMoves();

        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhiteKnightIcon());
        } else {
            this.setImageIcon(swingFactories.getBlackKnightIcon());
        }
        this.addMoves(new Move(2, 1, 2));
        this.addMoves(new Move(2, 1, -2));
        this.addMoves(new Move(2, 2, 1));
        this.addMoves(new Move(2, 2, -1));
        this.addMoves(new Move(2, -1, 2));
        this.addMoves(new Move(2, -1, -2));
        this.addMoves(new Move(2, -2, 1));
        this.addMoves(new Move(2, -2, -1));
    }
}
