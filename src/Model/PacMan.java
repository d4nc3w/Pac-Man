package Model;

import javax.swing.*;
import java.awt.*;

public class PacMan {
    private int x,y;
    private char direction;
    private ImageIcon[] images;
    private boolean mouthOpen;
    private int animationDelay;

    public PacMan(int x, int y){
        this.direction = 'r';
        this.x = x;
        this.y = y;
        this.images = new ImageIcon[4];
        this.images[0] = new ImageIcon("res/l.png");
        this.images[1] = new ImageIcon("res/r.png");
        this.images[2] = new ImageIcon("res/u.png");
        this.images[3] = new ImageIcon("res/d.png");
        this.mouthOpen = true;
        this.animationDelay = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void move(char direction) {
        switch (direction){
            case 'l':
                x--;
                break;
            case 'r':
                x++;
                break;
            case 'u':
                y--;
                break;
            case 'd':
                y++;
                break;
        }
    }
    public ImageIcon getImage() {
        int index = 0;
        switch (direction) {
            case 'r':
                index = 1;
                break;
            case 'u':
                index = 2;
                break;
            case 'd':
                index = 3;
                break;
        }
        if (mouthOpen) {
            return images[index];
        } else {
            return new ImageIcon("res/closed.png");
        }
    }
    public void toggleMouth() {
        mouthOpen = !mouthOpen;
    }

    public int getAnimationDelay(){
        return animationDelay;
    }
}
