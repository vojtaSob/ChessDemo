package game;

import GUI.Tile;


public class Game {
    private String whitePlayer;
    private String blackPlayer;
    private ClockSettings clockSettings;
    private Tile gameBoard[][];
    private int gamePhase;

    //Game phase 0 White choosing piece to move.
    //Game phase 1 White choosing move target.
    //Game phase 2 Black choosing piece to move.
    //Game phase 3 Black choosing move target.
    public Game(String whitePlayer, String blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.gamePhase++;
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

    public void goToNextPhase() {
        if (this.gamePhase < 3) {
            this.gamePhase++;
        }
        this.gamePhase = 0;
    }
}
