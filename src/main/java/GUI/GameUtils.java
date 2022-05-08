package GUI;

import game.Game;
import game.Piece;
import game.pieces.*;

public class GameUtils {
    Game game;

    public GameUtils(Game game) {
        this.game = game;
    }

    public King createNewKing(Tile tile, String color) {
        King king = new King(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = king;
        return king;


    }


    public Knight createNewKnight(Tile tile, String color) {
        Knight knight = new Knight(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = knight;

        return knight;
    }

    public Pawn createNewPawn(Tile tile, String color) {
        Pawn pawn = new Pawn(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = pawn;
        return pawn;

    }


    public Queen createNewQueen(Tile tile, String color) {
        Queen queen = new Queen(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = queen;
        return queen;
    }

    public Piece createNewBishop(Tile tile, String color) {
        Bishop bishop = new Bishop(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = bishop;
        return bishop;
    }

    public Rook createNewRook(Tile tile, String color) {
        Rook rook = new Rook(tile, color);
        this.game.gameBoard[tile.getHeightInBoard()][tile.getWidthInBoard()] = rook;
        return rook;
    }

    public Tile[][] initializeBaseBoard(Tile[][] board) {
        for (int i = 0; i < 8; i++) {
            board[i][2].setPiece(this.createNewPawn(board[i][2], Piece.WHITE));
        }
        return board;
    }
}
