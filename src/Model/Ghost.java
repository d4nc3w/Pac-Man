package Model;

import javax.swing.*;

public class Ghost {
    private int x, y;
    private ImageIcon[] images;

    public Ghost(int x, int y){
        this.x = x;
        this.y = y;
        this.images = new ImageIcon[4];
        this.images[0] = new ImageIcon("res/ghost1.jpg");
        this.images[1] = new ImageIcon("res/ghost2.jpg");
        this.images[2] = new ImageIcon("res/ghost3.jpg");
        this.images[3] = new ImageIcon("res/ghost4.jpg");
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

    public ImageIcon[] getImages() {
        return images;
    }
}
