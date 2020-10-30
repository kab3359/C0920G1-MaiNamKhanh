package session_6.bai_tap.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return this.height * getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + this.getRadius() + "\n" +
                "color=" + this.getColor() + "\n" +
                "height=" + height + "\n" +
                "volume=" + getVolume() + "\n" +
                '}';
    }
}
