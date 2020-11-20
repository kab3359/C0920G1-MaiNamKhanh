package session_15.bai_tap.IllegalTriangleException;

public class Triangle {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if(side1 >= side2 + side3)
            throw new IllegalTriangleException(side1);
        if(side2 >= side1 + side3)
            throw new IllegalTriangleException(side2);
        if(side3 >= side1 + side2)
            throw new IllegalTriangleException(side3);
        else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public Triangle(double side1) {
        this.side1 = side1;
    }

}
