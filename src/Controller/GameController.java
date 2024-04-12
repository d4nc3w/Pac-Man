package Controller;

import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class GameController implements KeyListener {
    private GameView view;
    private int lives, score;
    private boolean gameOver;
    private boolean dying = false;

    private final int BLOCK_SIZE = 20;
    private final int NUM_OF_BLOCKS = 30;
    private final int SCREEN_SIZE = NUM_OF_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 8;
    private final int PACMAN_SPEED = 6;
    private int NUM_OF_GHOSTS = 6;

    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    private int pacman_x, pacman_y, pacman_dx, pacman_dy;
    private int req_dx, req_dy;
    private final int validSpeeds[] = {1,2,3,4,6,8};
    private final int maxSpeed = 6;
    private int currentSpeed = 3;
    private Timer timer;
    private final int[][] levelData = LevelController.getRandomLevel();

    public GameController(GameView view){
        this.view = view;
        view.passLevelData(levelData);
        view.addKeyListener(this);
        initVariables();
    }

    public void startGame() {
        view.setVisible(true);
    }

    private void initVariables(){
        lives = 3;
        score = 0;
        gameOver = false;

        //TODO: Other variables...
    }

    public void updateGameState(){
        //...
    }

    public void renderGame(){
        //...
    }

    private void handleInput(int keyCode){
        //...
    }

    private void gameOver(){
        //...
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
