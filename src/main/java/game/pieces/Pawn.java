package game.pieces;

import GUI.Tile;
import game.Move;
import game.Piece;
import utils.SwingFactories;

public class Pawn extends Piece {
    public Pawn(Tile tile, String color) {
        this.setLocation(tile);
        this.setColor(color);
        this.setType(Piece.PAWN);
        this.didFirstMove = false;
        this.initMoves();
        SwingFactories swingFactories = new SwingFactories();
        if (color == WHITE) {
            this.setImageIcon(swingFactories.getWhitePawnIcon());
            this.addMoves(new Move(Move.MOVE, 0, 1));
            this.addMoves(new Move(Move.TAKE, 1, 1));
            this.addMoves(new Move(Move.TAKE, -1, 1));
            this.addMoves(new Move(Move.AS_FIRST_MOVE, 0, 2));

        } else {
            this.setImageIcon(swingFactories.getBlackPawnIcon());
            this.addMoves(new Move(Move.MOVE, 0, -1));
            this.addMoves(new Move(Move.TAKE, 1, -1));
            this.addMoves(new Move(Move.TAKE, -1, -1));
            this.addMoves(new Move(Move.AS_FIRST_MOVE, 0, -2));
        }

    }
}
