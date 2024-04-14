package View;

import Model.Ghost;
import Model.PacMan;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private final int BLOCK_SIZE = 24;
    private final int NUM_OF_BLOCKS = 20;
    private final int SCREEN_SIZE = NUM_OF_BLOCKS * BLOCK_SIZE;
    private int[][] levelData;
    private PacMan pacman;
    private Image offScreenBuffer;
    private int score;
    private int lives;
    private Ghost[] ghosts;

    public GameView() {
        setTitle("Pac-Man Game");
        setSize(SCREEN_SIZE, SCREEN_SIZE+40);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ghosts = new Ghost[4];
        for(int i = 0; i < 4; i++){
            ghosts[i] = new Ghost(0, 0);
        }
    }

    public void setPacman(PacMan pacman) {
        this.pacman = pacman;
    }

    public void passLevelData(int[][] levelData) {
        this.levelData = levelData;
    }

    public void paint(Graphics g) {
        if (offScreenBuffer == null) {
            offScreenBuffer = createImage(getWidth(), getHeight());
        }

        Graphics offScreenGraphics = offScreenBuffer.getGraphics();
        paintOffScreen(offScreenGraphics);
        g.drawImage(offScreenBuffer, 0, 0, null);
    }

    public void paintOffScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
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
                    } else if (blockValue == 4){
                        ImageIcon ghostImage = ghosts[0].getImages()[0];
                        g.drawImage(ghostImage.getImage(), x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, null);
                    }
                }
            }
        }
        //SCORE
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String scoreText = "Score: " + score;
        int stringWidth = g.getFontMetrics().stringWidth(scoreText);
        int x = (getWidth() - stringWidth) / 2;
        int y = SCREEN_SIZE + 30;
        g.drawString(scoreText, x, y);

        //HEARTS
        int heartSize = 40;
        x = SCREEN_SIZE - 150;
        y = SCREEN_SIZE + 3;
        for (int i = 0; i < lives; i++) {
            ImageIcon heartIcon = new ImageIcon("res/heart.png");
            g.drawImage(heartIcon.getImage(), x, y, heartSize, heartSize, null);
            x += heartSize + 5;
        }
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setHearts(int lives){
        this.lives = lives;
    }

    public void stop(){
        //TODO: prompt user if he wants to save his score
    }
}
