package Controller;

import View.GameView;

public class GameController {
    private GameView view;

    public GameController(GameView view){
        this.view = view;
    }

    public void startGame() {
        view.setVisible(true);
    }
}
