package GUI;

import utils.SwingFactories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {
    JFrame f;

    public MenuGUI() {
        super();
        SwingFactories swingFactories = new SwingFactories();
        f = swingFactories.getDefaultJFrame(400, 600, "Chess");//creating instance of JFrame
        JButton newGameButton = new JButton("New game");
        JButton newCustomGameButton = new JButton("New custom game");
        JButton loadGameButton = new JButton("Load game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGameAction();
            }
        });
        newCustomGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewCustomGameAction();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadGameAction();
            }
        });
        JPanel menu = new JPanel(new GridLayout(3, 1, 1, 1));
        menu.add(newGameButton);
        menu.add(newCustomGameButton);
        menu.add(loadGameButton);
        f.getContentPane().add(menu);
        f.setVisible(true);
    }

    public void createNewGameAction() {
        CreateNewGameGUI createNewGameGUI = new CreateNewGameGUI();
        f.dispose();
    }

    public void createNewCustomGameAction() {

        CreateNewCustomGameGUI createNewCustomGameGUI = new CreateNewCustomGameGUI();
        f.dispose();
    }

    public void loadGameAction() {
        LoadGameGUI loadGameGUI = new LoadGameGUI();
        f.dispose();
    }

}
