package game;

public class Move {
    public static final int MOVE = 0;
    public static final int TAKE = 1;
    public static final int MOVE_OR_TAKE = 2;
    public static final int AS_FIRST_MOVE = 3;
    public static final int MOVE_OR_TAKE_UNLIMITED = 4;
    public static final int CASTLING = 5;
    public static final int EN_PASSANT = 6;
    public int moveType;
    public int xAddition;
    public int yAddition;

    public Move(int moveType, int xAddition, int yAddition) {
        this.moveType = moveType;
        this.xAddition = xAddition;
        this.yAddition = yAddition;
    }
}
