package GUI;

import game.Game;
import utils.SwingFactories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewCustomGameGUI {
    Frame f;
    JPanel panel;
    JLabel whiteTag;
    JLabel blackTag;
    JTextField whiteName;
    JTextField blackName;
    JButton setTimerButton;
    JButton createGameButton;

    public CreateNewCustomGameGUI() {
        super();
        SwingFactories swingFactories = new SwingFactories();
        f = swingFactories.getDefaultJFrame(400, 300, "Create a new game!");
        panel = new JPanel(new GridLayout(3, 2));
        whiteTag = new JLabel("White player :");
        blackTag = new JLabel("Black player :");
        whiteName = swingFactories.getNameTextField();
        blackName = swingFactories.getNameTextField();
        setTimerButton = new JButton("Set timer!");
        createGameButton = new JButton("Go to a desk setup!");
        panel.add(whiteTag);
        panel.add(whiteName);
        panel.add(blackTag);
        panel.add(blackName);
        panel.add(setTimerButton);
        panel.add(createGameButton);
        createGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGameAction();
            }
        });
        f.add(panel);
        f.setVisible(true);


    }

    private void createNewGameAction() {
        Game game = new Game(whiteName.getText(), blackName.getText());
        GameGUI gameGUI = new GameGUI(game);
        f.dispose();

    }
}
