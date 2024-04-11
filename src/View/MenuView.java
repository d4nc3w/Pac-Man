package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private JButton newGameButton;
    private JButton highScoresButton;
    private JButton exitGameButton;

    public MenuView(){
        setTitle("Pac-Man");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initiateComponents();
    }

    private void initiateComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        newGameButton = new JButton("New Game");
        highScoresButton = new JButton("High Scores");
        exitGameButton = new JButton("Exit");

        panel.add(newGameButton);
        panel.add(highScoresButton);
        panel.add(exitGameButton);

        add(panel);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Fire up the Pac-Man game
            }
        });

        highScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Display high scores
            }
        });

        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
