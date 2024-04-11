package Controller;

import View.GameView;
import View.HighScoresView;
import View.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view){
        this.view = view;
    }

    public void start(){
        view.addNewGameButtonListener(new NewGameButtonListener());
        view.addHighScoresButtonListener(new HighScoresButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }

    private class NewGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            GameView gameView = new GameView();
            GameController gameController = new GameController(gameView);
            gameController.startGame();
        }
    }

    private class HighScoresButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            HighScoresView highScoresView = new HighScoresView();
            HighScoresController highScoresController = new HighScoresController(highScoresView);
            highScoresController.showHighScores();
        }
    }

    private class ExitButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
