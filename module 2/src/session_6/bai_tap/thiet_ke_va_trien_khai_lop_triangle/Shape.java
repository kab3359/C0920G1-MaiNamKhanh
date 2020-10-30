package session_6.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }
    public Shape(){}

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
}
