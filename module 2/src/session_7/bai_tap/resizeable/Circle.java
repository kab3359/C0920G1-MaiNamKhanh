package session_7.bai_tap.resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    @Override
    public void resize(double percent){
        double area = getArea() + percent;
        System.out.println("diện tích hình tròn sau khi tăng: " + area);
    }
}
