package session_7.bai_tap.resizeable;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(2);
        for (Shape shape : shapes){
            if(shape instanceof Circle){
                System.out.println("Diện tích hình tròn: " + shape.getArea());
                Resizeable resizeable = (Circle) shape;
                resizeable.resize(Math.random()*100);
            }
            else if(shape instanceof Rectangle){
                System.out.println("Diện tích hình chữ nhất: " + shape.getArea());
                Resizeable resizeable = (Rectangle) shape;
                resizeable.resize(Math.random()*100);
            }
            else if(shape instanceof Square){
                System.out.println("Diện tích hình vuông: " + shape.getArea());
                Resizeable resizeable = (Square) shape;
                resizeable.resize(Math.random()*100);
                ((Square) resizeable).howToColor();
            }
        }
    }
}
