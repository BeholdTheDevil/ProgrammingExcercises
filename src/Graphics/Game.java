package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by anton on 2017-05-22.
 */
public class Game extends JFrame {

    GameTest gt;

    public Game() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gt = new GameTest();

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gt.reset();
            }
        };
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        gt.getActionMap().put("RESET", action);
        gt.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "RESET");

        Action dispose = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        gt.getActionMap().put("DISPOSE", dispose);
        gt.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escKey, "DISPOSE");

        this.setPreferredSize(gt.getPreferredSize());
        this.setBackground(new Color(51,51,51));
        this.add(gt);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        gt.startG();
    }

    public static void main(String[] args) {
        new Game();
    }
}
