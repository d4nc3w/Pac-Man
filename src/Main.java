import Controller.MenuController;
import View.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView mainMenuView = new MenuView();
        MenuController menuController = new MenuController(mainMenuView);
        mainMenuView.setVisible(true);
        menuController.start();
    }
}
