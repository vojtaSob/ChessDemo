package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class Bishop extends Piece {
    public Bishop(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(Piece.BISHOP);
        this.initMoves();
        this.didFirstMove = false;

        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhiteBishopIcon());
        } else {
            this.setImageIcon(swingFactories.getBlackBishopIcon());
        }
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, -1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, -1));


    }
}
