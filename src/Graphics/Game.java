package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by anton on 2017-05-22.
 */
public class Game extends JFrame {

    GameTest gt;

    public Game() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gt = new GameTest();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_R) {
                    gt.reset();
                }
            }
        });
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
