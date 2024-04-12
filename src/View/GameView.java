package View;

import Model.PacMan;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int BLOCK_SIZE = 24;
    private final int NUM_OF_BLOCKS = 20;
    private final int SCREEN_SIZE = NUM_OF_BLOCKS * BLOCK_SIZE;
    private int[][] levelData;
    private PacMan pacman;

    public GameView() {
        setTitle("Pac-Man Game");
        setSize(SCREEN_SIZE, SCREEN_SIZE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
    }

    public void setPacman(PacMan pacman) {
        this.pacman = pacman;
    }

    public void passLevelData(int[][] levelData) {
        this.levelData = levelData;
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (levelData != null) {
            for (int y = 0; y < NUM_OF_BLOCKS; y++) {
                for (int x = 0; x < NUM_OF_BLOCKS; x++) {
                    int blockValue = levelData[y][x];
                    if (blockValue == 1) {
                        g.setColor(Color.BLUE);
                        g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    } else if (blockValue == 2) {
                        g.setColor(Color.BLACK);
                        g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    } else if (blockValue == 0) {
                        g.setColor(Color.BLACK);
                        g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                        g.setColor(Color.WHITE);
                        g.fillOval(x * BLOCK_SIZE + BLOCK_SIZE / 2, y * BLOCK_SIZE + BLOCK_SIZE / 2, BLOCK_SIZE / 4, BLOCK_SIZE / 4);
                    } else if (blockValue == 3) {
                        ImageIcon pacmanImage = pacman.getImage();
                        g.drawImage(pacmanImage.getImage(), x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, null);
                    }
                }
            }
        }
    }

    public void stop(){
        //TODO: prompt user if he wants to save his score
    }
}
