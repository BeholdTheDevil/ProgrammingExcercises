package Graphics;

import Datastructures.CustomLists.CustomArrayList;

import java.awt.*;

/**
 * Created by anton on 2017-05-22.
 */
public class Square {

    CVector pos;
    Color color;
    int size;
    boolean state;
    int content;

    Square (float x, float y, int s, Color c) {
        pos = new CVector(x, y);
        color = c;
        size = s;
        state = false;
        content = 0;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int)(pos.x), (int)(pos.y), size, size);

        g.setColor(Color.black);
        if(content == -1) g.setColor(Color.red);
        if(state == true) {
            g.drawString(Integer.toString(content), (int)pos.x + size/3, (int)pos.y + 2*size/3);
        }
    }
}
