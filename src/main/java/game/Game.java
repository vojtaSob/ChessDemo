package game;

import GUI.Tile;


public class Game {
    private String whitePlayer;
    private String blackPlayer;
    private ClockSettings clockSettings;
    public Piece gameBoard[][];
    private int gamePhase;

    //Game phase 0 White choosing piece to move.
    //Game phase 1 White choosing move target.
    //Game phase 2 Black choosing piece to move.
    //Game phase 3 Black choosing move target.
    public Game(String whitePlayer, String blackPlayer) {
        this.gameBoard = new Piece[8][8];
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.gamePhase = 0;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public ClockSettings getClockSettings() {
        return clockSettings;
    }

    public void setClockSettings(ClockSettings clockSettings) {
        this.clockSettings = clockSettings;

    }

    public int getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(int gamePhase) {
        this.gamePhase = gamePhase;
    }

    public void goToNextPhase() {
        if (this.gamePhase < 3) {
            this.gamePhase++;
        } else {
            this.gamePhase = 0;
        }
    }

    public void printBoardState() {
        for (int x = 7; x >= 0; x--) {
            for (int y = 0; y < 8; y++) {
                if (gameBoard[x][y] != null) {
                    System.out.print(gameBoard[x][y].getType() + " " + gameBoard[x][y].getColor());
                } else {
                    System.out.print("-------------");
                }
            }
            System.out.println();

        }
    }
}
