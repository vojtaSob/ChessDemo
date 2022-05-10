package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class King extends Piece {
    public King(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(KING);
        this.initMoves();
        this.didFirstMove = false;
        this.initMoves();


        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhiteKingIcon());


        } else {
            this.setImageIcon(swingFactories.getBlackKingIcon());
        }
        this.addMoves(new Move(Move.CASTLING, -4, 0));
        this.addMoves(new Move(Move.CASTLING, 3, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, 1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, -1, 0));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, 1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, -1, -1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, -1, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, 1, -1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, 0, 1));
        this.addMoves(new Move(Move.MOVE_OR_TAKE, 0, -1));

    }
}
