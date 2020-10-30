package session_7.test;

abstract public class Shape {
    protected int x, y;

    protected Shape(int _x, int _y) {
        x = _x;
        y = _y;
    }

    abstract public void draw();

    abstract public void erase();

    public void moveTo(int _x, int _y) {
        erase();
        x = _x;
        y = _y;
        draw();
    }
}
