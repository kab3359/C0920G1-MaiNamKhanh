package session_7.bai_tap.resizeable;

import session_7.bai_tap.colorable.Colorable;

public class Square extends Shape implements Resizeable, Colorable {
    private double lenght;

    public Square(double lenght) {
        this.lenght = lenght;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    @Override
    public double getArea(){
        return lenght * lenght;
    }
    @Override
    public void resize(double percent){
        double area = getArea() + percent;
        System.out.println("diện tích hình vuông sau khi tăng: " + area);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
