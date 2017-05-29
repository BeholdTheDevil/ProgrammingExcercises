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
    boolean state, flag;
    int content;

    Square (float x, float y, int s, Color c) {
        pos = new CVector(x, y);
        color = c;
        size = s;
        state = false;
        flag = false;
        content = 0;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int)(pos.x), (int)(pos.y), size, size);

        g.setColor(Color.black);
        if(flag) {
            g.drawLine((int)pos.x + size/3, (int)pos.y + size/3, (int)pos.x + 2*size/3, (int)pos.y + 2*size/3);
            g.drawLine((int)pos.x + 2*size/3, (int)pos.y + size/3, (int)pos.x + size/3, (int)pos.y + 2*size/3);
        }
        if(content == -1) g.setColor(Color.red);
        if(state && !flag) {
            g.drawString(Integer.toString(content), (int)pos.x + size/3, (int)pos.y + 2*size/3);
        }
    }
}
