package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int size;
    private int winLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.LIGHT_GRAY);


        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.gameFinished) {
                    Logic.humanTurn(cellX, cellY);
                }
            }
        }
        );
    }


    void startNewGame(int size, int winLength) {
        this.size = size;
        this.winLength = winLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        cellWidth = getWidth() / size;
        cellHeight = getHeight() / size;

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(5f));


        for (int i = 1; i < size; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 1; i < size; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[j][i] == Logic.DOT_X) {
                    drawX(g, i, j);
                }
            }
        }
        repaint();

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[j][i] == Logic.DOT_O) {
                    drawO(g, i, j);
                }
            }
        }
    }
    private void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(5f));

        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                cellX * cellWidth + cellWidth, cellY * cellHeight + cellHeight);

        g.drawLine(cellX * cellWidth + cellWidth, cellY * cellHeight,
                cellX * cellWidth, cellY * cellHeight + cellHeight);
    }
    private void drawO(Graphics g, int cellX, int cellY) {
        g.setColor(Color.GREEN);
        ((Graphics2D) g).setStroke(new BasicStroke(5f));

        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }
}
