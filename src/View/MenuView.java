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
        setSize(550, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setContentPane(new JLabel(new ImageIcon("res/MenuBackground.jpg")));
        setLayout(new BorderLayout());
        add(createButtonPanel(), BorderLayout.CENTER);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(newGameButton, gbc);

        gbc.gridy++;
        highScoresButton = new JButton("High Scores");
        highScoresButton.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(highScoresButton, gbc);

        gbc.gridy++;
        exitGameButton = new JButton("Exit");
        exitGameButton.setPreferredSize(new Dimension(150, 50));
        buttonPanel.add(exitGameButton, gbc);

        return buttonPanel;
    }

    public void addNewGameButtonListener(ActionListener listener) {
        newGameButton.addActionListener(listener);
    }

    public void addHighScoresButtonListener(ActionListener listener) {
        highScoresButton.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitGameButton.addActionListener(listener);
    }
}
