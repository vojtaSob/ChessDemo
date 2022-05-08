package game;

import GUI.Tile;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
    public static final String BLACK = "BLACK";
    public static final String WHITE = "WHITE";
    public static final String ROOK = "ROOK";
    public static final String PAWN = "PAWN";
    public static final String KING = "KING";
    public static final String QUEEN = "QUEEN";
    public static final String BISHOP = "BISHOP";
    public static final String KNIGHT = "KNIGHT";

    private Tile location;
    String type;
    String color;
    public boolean didFirstMove;
    public ArrayList<Move> moves;

    private ImageIcon imageIcon;

    public Tile getLocation() {
        return location;
    }

    public void setLocation(Tile location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void doMove() {

    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public void initMoves() {
        this.moves = new ArrayList<Move>();
    }

    public void addMoves(Move move) {
        this.moves.add(move);

    }

    public ArrayList<Move> getMoves() {
        return this.moves;
    }
}

