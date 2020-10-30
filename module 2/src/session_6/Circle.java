package session_6;

public class Circle extends Geometric {
    private double radius = 3.55;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public void printCircle() {
        System.out.println("The " + getColor() + " circle is created with the radius is " + radius);
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Circle{");
//        sb.append("radius=").append(radius);
//        sb.append('}');
//        return sb.toString();
//    }

    @Override
    public String toString(){
       return  "radius= " + getRadius() + "color: " + getColor() +
                (getFilled() == false ? "no fill" : "filled with \"" + getFilled() + "\" color");
    }
}
