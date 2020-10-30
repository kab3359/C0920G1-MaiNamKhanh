package session_6.bai_tap.point2d_and_point3d;

import java.util.Arrays;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY (float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        return new float[]{x, y};
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                ", xy=" + Arrays.toString(getXY()) +
                '}';
    }
}
