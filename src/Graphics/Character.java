package Graphics;

import java.awt.*;

/**
 * Created by anton on 2017-05-22.
 */
public class Character {

    CVector pos;
    CVector vel;
    CVector acc;
    Color color;
    int size;

    Character(CVector cords) {
        pos = cords.copy();
        vel = new CVector(0, 0);
        acc = new CVector(0, 0);
    }

    public void move() {
        vel.add(acc);
        pos.add(vel);
        acc.mult(0);
    }

    public void applyForce(CVector force) {
        acc.add(force);
    }
}
