package Controller;

import Model.PacMan;
import View.GameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class GameController implements KeyListener {
    private GameView view;
    private int lives, score;
    private boolean gameOver;
    private boolean dying = false;
    private final int[][] levelData;
    private long lastAnimationTime;
    private PacMan pacman;

    public GameController(GameView view){
        this.view = view;
        this.levelData = LevelController.getRandomLevel();
        view.passLevelData(levelData);
        view.addKeyListener(this);
        initVariables();
    }

    public void startGame() {
        view.setVisible(true);
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
        //TODO: Other variables...
    }


    public void updateGameState(){
        //...
    }

    public void renderGame(){
        //...
    }

    private void handleInput(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_UP:
                pacman.setDirection('u');
                pacman.move('u');
                break;
            case KeyEvent.VK_RIGHT:
                pacman.setDirection('r');
                pacman.move('r');
                break;
            case KeyEvent.VK_DOWN:
                pacman.setDirection('d');
                pacman.move('d');
                break;
            case KeyEvent.VK_LEFT:
                pacman.setDirection('l');
                pacman.move('l');
                break;
        }
    }

    private void gameOver() throws InterruptedException {
        if(dying == true){
            if(lives == 0){
                view.stop();
            }
        }
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

