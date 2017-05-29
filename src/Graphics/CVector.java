package Graphics;

/**
 * Created by anton on 2017-05-22.
 */
public class CVector {

    float x, y;

    CVector(float cx, float cy) {
        this.x = cx;
        this.y = cy;
    }

    CVector(int cx, int cy) {
        this.x = (float) cx;
        this.y = (float) cy;
    }

    double mag() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    double dist(CVector c) {
        return dist(c.x, c.y);
    }
    double dist(float cx, float cy) {
        double d = Math.sqrt((Math.pow(x - cx, 2) + Math.pow(y - cy, 2)));
        return d;
    }

    void add(CVector c) {
        add(c.x, c.y);
    }
    void add(float cx, float cy) {
        x += cx;
        y += cy;
    }

    void sub(CVector c) {
        sub(c.x, c.y);
    }
    void sub(float cx, float cy) {
        x -= cx;
        y -= cy;
    }

    void mult(CVector c) {
        //r(cos v + sin v)
        double angle = Math.atan(y/x) + Math.atan(c.y/c.x);
        double mag = mag() * c.mag();

        x = (float)(mag * Math.cos(angle));
        y = (float)(mag * Math.sin(angle));
    }
    void mult(float scalar) {
        x = x*scalar;
        y = y*scalar;
    }

    void div(CVector c) {
        double angle = Math.atan(y/x) - Math.atan(c.y/c.x);
        double mag = mag() / c.mag();

        x = (float)(mag * Math.cos(angle));
        y = (float)(mag * Math.sin(angle));
    }
    void div(float scalar) {
        x = x / scalar;
        y = y / scalar;
    }

    CVector copy() {
        return new CVector(x, y);
    }
}
