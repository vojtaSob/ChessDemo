package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class Queen extends Piece {
    public Queen(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(Piece.QUEEN);
        this.initMoves();
        this.didFirstMove = false;
        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhiteQueenIcon());
        } else {
            this.setImageIcon(swingFactories.getBlackQueenIcon());
        }
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, -1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, -1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 1, -1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 0, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE_UNLIMITED, 0, -1));
    }
}
