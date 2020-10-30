package session_7.bai_tap.resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public double getArea(){
        return length * width;
    }
    @Override
    public void resize(double percent){
        double area = getArea() + percent;
        System.out.println("diện tích hình chữ nhật sau khi tăng: " + area);
    }
}
