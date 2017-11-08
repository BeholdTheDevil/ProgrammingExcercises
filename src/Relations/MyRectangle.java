package Relations;

/**
 * Created by anton on 2017-11-08.
 */
public class MyRectangle {
    private MyPoint bottomRight;
    private MyPoint topLeft;

    public MyRectangle() {}

    public MyRectangle(MyPoint bottomRight, MyPoint topLeft) {
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
    }

    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.bottomRight = new MyPoint(x1, y1);
        this.topLeft = new MyPoint(x2, y2);
    }

    public String toString() {
        return new String("MyRectangle[bottomRight=" + bottomRight.toString() + ",topLeft=" + topLeft.toString() + "]");
    }

    public MyPoint[] getCorners() {
        return new MyPoint[] {bottomRight, topLeft};
    }

    public MyPoint getBottomRight() {
        return bottomRight;
    }

    public MyPoint getTopLeft() {
        return topLeft;
    }

    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }

    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }

    public double getArea() {
        return Math.abs(topLeft.getX() - bottomRight.getX()) * Math.abs(topLeft.getY() - bottomRight.getY());
    }

    public double getPerimeter() {
        double a = Math.abs(topLeft.getX() - bottomRight.getX());
        double b = Math.abs(topLeft.getY() - bottomRight.getY());

        return 2*(a+b);
    }
}
