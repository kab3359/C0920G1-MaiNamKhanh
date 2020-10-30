package session_5.bai_tap;

public class AccessModifier {
    private double radius = 1.0;
    private String color = "red";
    AccessModifier(){
    }
    AccessModifier(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
}
