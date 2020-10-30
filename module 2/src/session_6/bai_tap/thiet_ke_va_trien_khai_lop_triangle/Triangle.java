package session_6.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Triangle extends Shape {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(){

    }

    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }
    public double getArea(){
       return Math.pow((side2*side2+side3*side3-side1*side1)/2, 0.5)*side1/2;
    }
    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + getColor() +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}
