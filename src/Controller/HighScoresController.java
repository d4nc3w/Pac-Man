package Controller;

import View.HighScoresView;

public class HighScoresController {
    private HighScoresView view;

    public HighScoresController(HighScoresView view){
        this.view = view;
    }

    public void showHighScores(){
        view.setVisible(true);
    }
}
