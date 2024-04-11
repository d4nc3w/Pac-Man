package Controller;

import View.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view){
        this.view = view;
        view.addNewGameButtonListener(new NewGameButtonListener());
        view.addHighScoresButtonListener(new HighScoresButtonListener());
        view.addExitButtonListener(new ExitButtonListener());
    }

    private class NewGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //...
        }
    }

    private class HighScoresButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //...
        }
    }

    private class ExitButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
