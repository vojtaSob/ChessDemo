package GUI;

import game.Game;
import game.Move;
import game.Piece;
import utils.SwingFactories;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGUI {
    Game game;
    JFrame frame;
    JPanel panel;
    JLayeredPane layeredPane;
    GameUtils gameUtils;
    private ArrayList<Tile> possibleMoves;
    Tile pressed;
    Tile moveStartingPosition;
    private Tile tile_arr[][];


    public GameGUI(Game game) {
        //https://community.oracle.com/tech/developers/discussion/1369482/chess-game-with-drag-and-drop-using-jlayeredpane

        super();
        this.game = game;
        initializeBoard();
        SwingFactories swingFactories = new SwingFactories();
        GameUtils gameUtils = new GameUtils(game);
        //createBaseGameSetup();
        testGameSetup();
        frame.setVisible(true);
        possibleMoves = new ArrayList<>();
    }

    void testGameSetup() {
        GameUtils gameUtils = new GameUtils(game);
        tile_arr[4][0].setPiece(gameUtils.createNewKing(tile_arr[4][0], Piece.WHITE));
        tile_arr[0][0].setPiece(gameUtils.createNewRook(tile_arr[0][0], Piece.WHITE));
        tile_arr[7][0].setPiece(gameUtils.createNewRook(tile_arr[7][0], Piece.WHITE));
    }

    void createBaseGameSetup() {

        GameUtils gameUtils = new GameUtils(game);
        //Create White
        for (int i = 0; i < 8; i++) {
            tile_arr[i][1].setPiece(gameUtils.createNewPawn(tile_arr[i][1], Piece.WHITE));
        }
        tile_arr[0][0].setPiece(gameUtils.createNewRook(tile_arr[0][0], Piece.WHITE));
        tile_arr[7][0].setPiece(gameUtils.createNewRook(tile_arr[7][0], Piece.WHITE));
        tile_arr[1][0].setPiece(gameUtils.createNewKnight(tile_arr[1][0], Piece.WHITE));
        tile_arr[6][0].setPiece(gameUtils.createNewKnight(tile_arr[6][0], Piece.WHITE));
        tile_arr[2][0].setPiece(gameUtils.createNewBishop(tile_arr[2][0], Piece.WHITE));
        tile_arr[5][0].setPiece(gameUtils.createNewBishop(tile_arr[5][0], Piece.WHITE));
        tile_arr[3][0].setPiece(gameUtils.createNewQueen(tile_arr[3][0], Piece.WHITE));
        tile_arr[4][0].setPiece(gameUtils.createNewKing(tile_arr[4][0], Piece.WHITE));
        //Create black
        for (int i = 0; i < 8; i++) {
            tile_arr[i][6].setPiece(gameUtils.createNewPawn(tile_arr[i][6], Piece.BLACK));
        }

        tile_arr[0][7].setPiece(gameUtils.createNewRook(tile_arr[0][7], Piece.BLACK));
        tile_arr[7][7].setPiece(gameUtils.createNewRook(tile_arr[7][7], Piece.BLACK));
        tile_arr[1][7].setPiece(gameUtils.createNewKnight(tile_arr[1][7], Piece.BLACK));
        tile_arr[6][7].setPiece(gameUtils.createNewKnight(tile_arr[6][7], Piece.BLACK));
        tile_arr[2][7].setPiece(gameUtils.createNewBishop(tile_arr[2][7], Piece.BLACK));
        tile_arr[5][7].setPiece(gameUtils.createNewBishop(tile_arr[5][7], Piece.BLACK));
        tile_arr[3][7].setPiece(gameUtils.createNewQueen(tile_arr[3][7], Piece.BLACK));
        tile_arr[4][7].setPiece(gameUtils.createNewKing(tile_arr[4][7], Piece.BLACK));

    }

    void initializeBoard() {
        tile_arr = new Tile[8][8];
        SwingFactories swingFactories = new SwingFactories();
        frame = swingFactories.getDefaultJFrame(800, 800, "Chess");
        frame.setResizable(true);
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        frame.getContentPane().add(panel);
        for (int y = 7; y >= 0; y--) {

            for (int x = 0; x <= 7; x++) {
                Tile tile = new Tile(x, y);
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        tile.setBackground(Color.gray);
                    } else {
                        tile.setBackground(Color.white);
                    }
                } else {
                    if (x % 2 == 0) {
                        tile.setBackground(Color.white);
                    } else {
                        tile.setBackground(Color.gray);
                    }
                }
                tile.setBaseColor(tile.getBackground());
                tile.setPiece(null);
                tile.addActionListener(e -> tileAction(tile));
                panel.add(tile);
                tile_arr[x][y] = tile;


            }
        }
    }

    void cleanPossibleMoves() {
        for (int i = 0; i < this.possibleMoves.size(); i++) {
            this.possibleMoves.get(i).resetColor();
        }
        this.possibleMoves.clear();
    }

    void tileAction(Tile tile) {
        if (tile.piece != null) {
            if (this.game.getGamePhase() == 0 && tile.piece.getColor() == Piece.WHITE) {
                cleanPossibleMoves();
                choosingMoveTargets(tile);
            } else if (this.game.getGamePhase() == 2 && tile.piece.getColor() == Piece.BLACK) {
                cleanPossibleMoves();
                choosingMoveTargets(tile);
            } else if (this.game.getGamePhase() == 1 && tile.getPiece().getColor() == Piece.WHITE) {
                game.setGamePhase(0);
                moveStartingPosition.resetColor();
                moveStartingPosition = null;
                cleanPossibleMoves();
                choosingMoveTargets(tile);
            } else if (this.game.getGamePhase() == 3 && tile.getPiece().getColor() == Piece.BLACK) {
                game.setGamePhase(2);
                moveStartingPosition.resetColor();
                moveStartingPosition = null;
                cleanPossibleMoves();
                choosingMoveTargets(tile);
            }

        }
        if ((game.getGamePhase() == 1 || game.getGamePhase() == 3) && this.possibleMoves.contains(tile)) {
            doAMove(tile);
        }
    }

    void choosingMoveTargets(Tile tile) {
        cleanPossibleMoves();
        tile.setBackground(Color.BLUE);
        if (this.pressed != null) {
            this.pressed.setBackground(this.pressed.getBaseColor());
        }
        this.pressed = tile;
        this.moveStartingPosition = tile;
        for (int i = 0; i < tile.piece.moves.size(); i++) {

            Move m = tile.piece.moves.get(i);
            int possibleX = tile.getWidthInBoard() + m.xAddition;
            int possibleY = tile.getHeightInBoard() + m.yAddition;
            if (possibleX < 0 || possibleX > 7 || possibleY < 0 || possibleY > 7) {
                continue;
            }
            Tile possibleTarget = tile_arr[possibleX][possibleY];
            if (m.moveType == Move.MOVE_OR_TAKE_UNLIMITED) {
                for (int y = 1; y < 8; y++) {

                    possibleX = tile.getWidthInBoard() + m.xAddition * y;
                    possibleY = tile.getHeightInBoard() + m.yAddition * y;
                    if (possibleX < 0 || possibleX > 7 || possibleY < 0 || possibleY > 7) {
                        break;
                    }
                    System.out.println(game.getGamePhase());
                    possibleTarget = tile_arr[possibleX][possibleY];

                    if (possibleTarget.getPiece() == null) {
                        possibleMoves.add(possibleTarget);
                    } else if (possibleTarget.getPiece().getColor() == Piece.BLACK && game.getGamePhase() == 0) {
                        possibleMoves.add(possibleTarget);
                        break;
                    } else if (possibleTarget.getPiece().getColor() == Piece.WHITE && game.getGamePhase() == 2) {
                        possibleMoves.add(possibleTarget);
                        break;
                    } else {
                        break;
                    }
                    System.out.println(possibleMoves.size());


                }
                continue;
            } else if (m.moveType == Move.AS_FIRST_MOVE && this.moveStartingPosition.piece.didFirstMove) {
                continue;
            } else if (m.moveType == Move.TAKE) {
                if (game.getGamePhase() == 0 && (possibleTarget.getPiece() == null || possibleTarget.getPiece().getColor() == Piece.WHITE)) {
                    continue;
                }
                if (game.getGamePhase() == 2 && (possibleTarget.getPiece() == null || possibleTarget.getPiece().getColor() == Piece.BLACK)) {
                    continue;
                }
            } else if (m.moveType == Move.MOVE && (game.getGamePhase() == 0 || game.getGamePhase() == 2) && possibleTarget.getPiece() != null) {
                continue;
            } else if (m.moveType == Move.MOVE_OR_TAKE) {
                Piece p = possibleTarget.getPiece();
                if (p != null) {
                    if (p.getColor() == Piece.WHITE && game.getGamePhase() == 0) {
                        continue;
                    } else if (p.getColor() == Piece.BLACK && game.getGamePhase() == 2) {
                        continue;
                    }
                }
            } else if (m.moveType == Move.CASTLING) {
                if (checkCastlingConditions(tile.getPiece().getColor(), m.xAddition)) {
                    possibleMoves.add(possibleTarget);
                }
                continue;
            } else if (m.moveType == Move.EN_PASSANT) {

            }
            possibleMoves.add(possibleTarget);
        }
        for (int i = 0; i < possibleMoves.size(); i++) {
            possibleMoves.get(i).setBackground(Color.green);
        }

        game.goToNextPhase();
    }

    public boolean checkCastlingConditions(String color, int x_change) {
        int yConst = 0;
        if (color == Piece.BLACK) {
            yConst = 7;
        }
        if (tile_arr[4][yConst].getPiece().getType() == null) {
            return false;
        }
        Piece kingToMove = tile_arr[4][yConst].getPiece();
        Piece rookToMove = null;
        if (x_change == -4 && tile_arr[0][yConst].getPiece() != null) {
            rookToMove = tile_arr[0][yConst].getPiece();
        } else if (tile_arr[7][yConst].getPiece() != null) {
            rookToMove = tile_arr[7][yConst].getPiece();
        } else {
            return false;
        }
        if (kingToMove.getType() != Piece.KING || kingToMove.didFirstMove) {
            return false;
        } else if (rookToMove.getType() != Piece.ROOK || rookToMove.didFirstMove) {
            return false;
        }
        if (x_change == -3) {
            for (int i = 1; i < 3; i++) {
                if (tile_arr[i][yConst].getPiece() != null) {
                    return false;
                }
            }
        } else {
            for (int i = 5; i < 6; i++) {
                if (tile_arr[i][yConst].getPiece() != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void doCastling() {
    }

    public void doAMove(Tile tile) {
        tile.setPiece(this.moveStartingPosition.getPiece());
        tile.getPiece().didFirstMove = true;
        this.moveStartingPosition.setPiece(null);
        this.moveStartingPosition.resetColor();
        cleanPossibleMoves();
        game.goToNextPhase();
    }

}
