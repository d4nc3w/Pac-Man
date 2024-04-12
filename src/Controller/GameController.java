package Controller;

import Model.PacMan;
import View.GameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private GameView view;
    private int lives, score;
    private boolean gameOver;
    private boolean dying = false;
    private final int[][] levelData;
    private long lastAnimationTime;
    private PacMan pacman;
    private boolean gameStarted;

    public GameController(GameView view){
        this.view = view;
        this.levelData = LevelController.getRandomLevel();
        view.passLevelData(levelData);
        view.addKeyListener(this);
        initVariables();
    }

    public void startGame() {
        view.setVisible(true);
        gameStarted = true;
        view.requestFocus();
    }

    private void initVariables() {
        lives = 3;
        score = 0;
        gameOver = false;
        int pacmanX = -1;
        int pacmanY = -1;
        for (int y = 0; y < levelData.length; y++) {
            for (int x = 0; x < levelData[y].length; x++) {
                if (levelData[y][x] == 3) {
                    pacmanX = x;
                    pacmanY = y;
                    break;
                }
            }
        }
        pacman = new PacMan(pacmanX, pacmanY);
        view.setPacman(pacman);
        lastAnimationTime = System.currentTimeMillis();
        score = 0;
        //TODO: Other variables...
    }


    public void updateGameState(){
        //...
    }

    public void renderGame(){
        //...
    }

    private void handleInput(int keyCode) {
        if (gameStarted) {
            int oldX = pacman.getX();
            int oldY = pacman.getY();

            int newX = oldX;
            int newY = oldY;

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    newX = oldX;
                    newY = oldY - 1;
                    break;
                case KeyEvent.VK_RIGHT:
                    newX = oldX + 1;
                    newY = oldY;
                    break;
                case KeyEvent.VK_DOWN:
                    newX = oldX;
                    newY = oldY + 1;
                    break;
                case KeyEvent.VK_LEFT:
                    newX = oldX - 1;
                    newY = oldY;
                    break;
            }

            if (canMoveTo(newX, newY)) {
                pacman.setDirection(getDirectionFromKeyCode(keyCode));
                pacman.move(getDirectionFromKeyCode(keyCode));

                if (levelData[newY][newX] == 0) {
                    score++;
                } else if (levelData[newY][newX] == 2) {
                    levelData[newY][newX] = 3;
                }
                levelData[oldY][oldX] = 2;
                levelData[newY][newX] = 3;

                //TODO: view.setScore(score);
                view.repaint();
            }
        }
    }

    private boolean canMoveTo(int newX, int newY) {
        if (newX < 0 || newX >= levelData[0].length || newY < 0 || newY >= levelData.length) {
            return false;
        }
        return levelData[newY][newX] != 1;
    }

    private void updatePacmanAnimation() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAnimationTime >= pacman.getAnimationDelay()) {
            pacman.toggleMouth();
            lastAnimationTime = currentTime;
        }
    }

    public PacMan getPacman(){
        return pacman;
    }

    private char getDirectionFromKeyCode(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                return 'u';
            case KeyEvent.VK_RIGHT:
                return 'r';
            case KeyEvent.VK_DOWN:
                return 'd';
            case KeyEvent.VK_LEFT:
                return 'l';
            default:
                return 'r'; // Default to right
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        handleInput(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //NOT USED
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //NOT USED
    }
}

