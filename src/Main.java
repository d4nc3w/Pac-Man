import Controller.MenuController;
import View.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView mainMenuView = new MenuView();
        MenuController mainMenuController = new MenuController(mainMenuView);
        mainMenuView.setVisible(true);

    }
}
