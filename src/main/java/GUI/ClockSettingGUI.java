package GUI;

import game.ClockSettings;
import game.Game;
import utils.SwingFactories;

import javax.swing.*;

public class ClockSettingGUI {
    JFrame frame;
    Game game;
    ClockSettings clockSettings;

    public ClockSettingGUI(Game game) {
        this.game = game;
        SwingFactories swingFactories = new SwingFactories();
        frame = swingFactories.getDefaultJFrame(400, 400, "Set a clocks!");


    }

    public void setClockSettings() {
        clockSettings = new ClockSettings(clockSettings.NO_CLOCK, 0, 0, 0);
        game.setClockSettings(clockSettings);
    }
}
