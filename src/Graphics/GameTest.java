package Graphics;

import Datastructures.CustomLists.CustomArrayList;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;

/**
 * Created by anton on 2017-05-22.
 */
public class GameTest extends JPanel implements Runnable {

    static final int GWIDTH = 1000, GHEIGHT = 700;
    static final Dimension dimension = new Dimension(GWIDTH, GHEIGHT);
    private Graphics dbg;
    private Image dbImage;
    private World world;
    private Thread game;
    private boolean running;

    GameTest() {
        setPreferredSize(dimension);
        setBackground(new Color(51,51,51));
        initialize();
    }

    private void initialize() {
        int playingFieldSize;
        if(GWIDTH > GHEIGHT) {
            playingFieldSize =  GHEIGHT - 50;
        } else {
            playingFieldSize = GWIDTH - 50;
        }
        int ymargin = ((GHEIGHT-25) - playingFieldSize)/2;
        int xmargin = ((GWIDTH-25) - playingFieldSize)/2;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if(running) {
                    if(me.getButton() == MouseEvent.BUTTON1) {
                        float x = me.getX();
                        float y = me.getY();
                        if((x > xmargin+40 && x < GWIDTH-xmargin-40) && (y > ymargin+40 && y < GHEIGHT-ymargin-40)) {
                            int pos = (int)((x-xmargin)/world.scale + world.rowSize*(int)((y-ymargin)/world.scale));
                            world.reveal(pos);
                            if(world.tiles[pos].content == -1) {
                                running = false;
                            }
                        }
                    }
                }
            }
        });

        world = new World(playingFieldSize, xmargin, ymargin);
    }

    public void run() {
        long lastTime = System.nanoTime();
        int updates = 60;
        //Updates per second instead of FPS
        long ns = 100000000/updates;
        double buffer = 0;
        while(running) {
            long t = System.nanoTime();
            buffer += ((t - lastTime)/ns);
            while(buffer > 1) {
                gameRender();
                paintScreen();
                buffer--;
            }
            lastTime = t;
        }
    }

    void gameRender() {
        if(dbImage == null) {
            dbImage = createImage(GWIDTH, GHEIGHT);
            if(dbImage != null) {
                dbg = dbImage.getGraphics();
            }
        }

        draw(dbg);
    }

    //Actual draw function for game objects
    public void draw(Graphics g) {
        world.draw(g);
    }

    private void paintScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if(dbImage != null && g != null) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        } catch (Exception err) {
            System.out.print(err);
        }
    }

    public void startG() {
        if(game == null || !running) {
            game = new Thread(this);
            running = true;
            game.start();
        }
    }

    public void reset() {
        initialize();
        running = true;
    }
}
