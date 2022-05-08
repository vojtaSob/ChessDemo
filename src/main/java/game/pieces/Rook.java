package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class Rook extends Piece {
    public Rook(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(Piece.ROOK);
        this.initMoves();
        this.didFirstMove = false;


        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhiteRookIcon());
        } else {
            this.setImageIcon(swingFactories.getBlackRookIcon());
        }
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 0, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 0, -1));


    }
}
