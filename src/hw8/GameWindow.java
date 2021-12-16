package hw8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_WIDTH = 500;
    static final int WINDOW_HEIGHT = 555;

    private SettingWindow settingWindow;
    private BattleField BattleField;

    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");

        settingWindow = new SettingWindow(this);
        BattleField = new BattleField(this);
        add(BattleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("New Game");
        JButton btnExit = new JButton("Exit");
        panel.add(btnNewGame);
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);
        btnExit.setBackground(Color.MAGENTA);
        btnNewGame.setBackground(Color.CYAN);

        btnExit.addActionListener(e -> System.exit(0));

        btnNewGame.addActionListener(e -> settingWindow.setVisible(true));

        setVisible(true);
    }

    void startNewGame(int size, int winLength) {
        BattleField.startNewGame(size, winLength);
    }
}
